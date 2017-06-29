package pokemonmaker;
import java.sql.*;
import java.io.*;

/**
 *
 * @author Joshua Hester
 * 
 * Add all the information to a database and use sql operations on the data
 * 
 */
public class Database {
    private Connection connection = null;
    public static Statement statement = null;
    public Database(){
        //Open database connection
        try{
            String databaseURL = "jdbc:mysql://localhost";

            connection = DriverManager.getConnection(databaseURL,"root","root");
            System.out.println("Database connected successfully");
            statement = connection.createStatement();
        }catch(SQLException e){
            System.out.println("Database connection error: Please make sure MySQL and the jdbc library are installed");
            System.out.println(e.getMessage());
        }
        
         //remove this afer you fix everything !!!!
        UpdateSQL("DROP DATABASE POKEMONCREATOR");
        
        
        
        //Create the Pokemon Database.
        //Since the database is stored on the system, anything already in the database will fail.
        UpdateSQL("CREATE DATABASE POKEMONCREATOR");
        UpdateSQL("USE POKEMONCREATOR");
        UpdateSQL("CREATE TABLE Pokemon("
                + "natid INT            NOT NULL,"
                + "form INT             NOT NULL,"
                + "regionid INT         NOT NULL,"
                + "generation INT       NOT NULL,"
                + "species CHAR(17)     NOT NULL,"
                + "type1 CHAR(12)       NOT NULL,"
                + "type2 CHAR(12),"
                + "ability1 CHAR(20)    NOT NULL,"
                + "ability2 CHAR(20),"
                + "ability3 CHAR(20),"
                + "hp INT,"                         //stat block
                + "attack INT,"
                + "defense INT,"
                + "specialattack INT,"
                + "specialdefense INT,"
                + "speed INT,"
                + "stattotal INT,"
                + "PRIMARY KEY(natid,form))");
        
        readPokemonIntoDatabase();
 
       
    }
    
    public void UpdateSQL(String sql /* Any SQL logic statement */){
        try{
            statement.executeUpdate(sql);
        }catch(SQLException e){
            System.out.println("SQL statement update error");
            System.out.println(e.getMessage());
        }
    }
    
    public Object RetrieveSQLData(String sql /* Any SQL logic statement */){
        Object output = null;
        try{
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                    output =  (Object) result.getObject(1);
                }
        }catch(SQLException e){
            System.out.println("SQL statement update error");
            System.out.println(e.getMessage());
        }
        return output;
    }
    
    public void readPokemonIntoDatabase(){
        Pokemon pokemon = new Pokemon();
        XMLReader reader = new XMLReader("src/pokemonmaker/pokemon");
        for(int i=0;i<reader.getDirectorySize();i++){
            File pokemonFile = reader.getNextFile();
            reader.readPokemonFile(pokemon,pokemonFile);
            UpdateSQL(generateEntryString(pokemon));
        }
    }
    
    public void getPokemonindexByGeneration (int generation){
        String string = "Select natid, form FROM Pokemon WHERE generation="+generation+";";
        System.out.print(RetrieveSQLData(string));
        
        
    } 
    
    private String generateEntryString(Pokemon pokemon){
        
        String string ="INSERT INTO Pokemon (natid,form,regionid,generation,species,type1,type2,ability1,ability2,ability3,hp,attack,defense,specialattack,specialdefense,speed,stattotal)"
                + "VALUES ("
                + pokemon.getNationalIndex()+ ","
                + pokemon.getForm()+","
                + pokemon.getRegionalIndex()+ ","
                + pokemon.getGeneration()+ ",'"
                + pokemon.getSpecies()+ "','"
                + pokemon.getPrimaryType()+ "','"
                + pokemon.getSecondaryType()+ "','"
                + pokemon.getPrimaryAbility()+ "','"
                + pokemon.getSecondaryAbility()+ "','"
                + pokemon.getHiddenAbility()+ "',"
                + pokemon.getStats(0)+","
                + pokemon.getStats(1)+","
                + pokemon.getStats(2)+","
                + pokemon.getStats(3)+","
                + pokemon.getStats(4)+","
                + pokemon.getStats(5)+","
                + pokemon.getStats(6)
                + ")";
        
        
        
        return string;
    }
}
