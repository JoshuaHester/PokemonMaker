package pokemonmaker;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

/**
 *
 * @author Joshua Hester
 */
public class XMLReader {

    //private File inputFile = new File("pokemon/1-1.xml");
    
    File directory = null;
    File fileList[] = null;
    int index = 0;
    
    public XMLReader(String directoryName){
        /**
         * Creates a reader that will be used to read the files in the corresponding directory 
         */
        directory = new File(directoryName);
        fileList = directory.listFiles();
    }
    
    public File getNextFile(){
        /**
         * Finds the next file in the directory
         */
        File file = fileList[index];
        try{index++;}catch(ArrayIndexOutOfBoundsException e){System.out.println("array out of bounds");}
        return file;
    }
    
    public int getDirectorySize(){
        /**
         * returns the number of files in the directory
         */
        return fileList.length;
    }
    
    public void readPokemonFile(Pokemon pokemon, File inputFile){
        /**
         * Reads an XML file for Pokemon and stores the data as a Pokemon Object
         */
        Document document = null;
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(inputFile);
            document.getDocumentElement().normalize();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
            //read in by element. Not all elements will be present in some files, so each element is enclosed it a try-catch
        try{    pokemon.setNationalIndex(Integer.parseInt(document.getElementsByTagName("NationalIndex").item(0).getTextContent()));    }catch(Exception e){}
        try{    pokemon.setRegionalIndex(Integer.parseInt(document.getElementsByTagName("RegionalIndex").item(0).getTextContent()));    }catch(Exception e){}
        try{    pokemon.setGeneration(Integer.parseInt(document.getElementsByTagName("Generation").item(0).getTextContent()));  }catch(Exception e){}
        try{    pokemon.setSpecies(document.getElementsByTagName("Name").item(0).getTextContent()); }catch(Exception e){}
        try{    pokemon.setPrimaryAbility(Ability.valueOf(((Element) document.getElementsByTagName("Ability").item(0)).getElementsByTagName("Primary").item(0).getTextContent()));  }catch(Exception e){}
        try{    pokemon.setSecondaryAbility(Ability.valueOf(((Element) document.getElementsByTagName("Ability").item(0)).getElementsByTagName("Secondary").item(0).getTextContent()));  }catch(Exception e){}
        try{    pokemon.setHiddenAbility(Ability.valueOf(((Element) document.getElementsByTagName("Ability").item(0)).getElementsByTagName("Hidden").item(0).getTextContent()));    }catch(Exception e){}
        try{    pokemon.setPrimaryType(Type.valueOf(((Element) document.getElementsByTagName("Typing").item(0)).getElementsByTagName("Primary").item(0).getTextContent())); }catch(Exception e){}
        try{    pokemon.setSecondaryType(Type.valueOf(((Element) document.getElementsByTagName("Typing").item(0)).getElementsByTagName("Secondary").item(0).getTextContent())); }catch(Exception e){}            
        try{    pokemon.setNickname(document.getElementsByTagName("Nickname").item(0).getTextContent());    }catch(Exception e){}
        try{    pokemon.setCreationIndex(Integer.parseInt(document.getElementsByTagName("SaveNumber").item(0).getTextContent()));   }catch(Exception e){}
        try{    pokemon.setForm(Integer.parseInt(document.getElementsByTagName("Form").item(0).getTextContent()));   }catch(Exception e){}
        try{    pokemon.setStats(
                    Integer.parseInt(((Element) document.getElementsByTagName("Stats").item(0)).getElementsByTagName("HP").item(0).getTextContent()),
                    Integer.parseInt(((Element) document.getElementsByTagName("Stats").item(0)).getElementsByTagName("Attack").item(0).getTextContent()),
                    Integer.parseInt(((Element) document.getElementsByTagName("Stats").item(0)).getElementsByTagName("Defense").item(0).getTextContent()),
                    Integer.parseInt(((Element) document.getElementsByTagName("Stats").item(0)).getElementsByTagName("SpecialAttack").item(0).getTextContent()),
                    Integer.parseInt(((Element) document.getElementsByTagName("Stats").item(0)).getElementsByTagName("SpecialDefense").item(0).getTextContent()),
                    Integer.parseInt(((Element) document.getElementsByTagName("Stats").item(0)).getElementsByTagName("Speed").item(0).getTextContent()),
                    Integer.parseInt(((Element) document.getElementsByTagName("Stats").item(0)).getElementsByTagName("Total").item(0).getTextContent())
                );  }catch(Exception e){}
        
        
        
        
    }
    
    public void readMoveFile(){
        /**
         * Reads an XML file for moves and stores the data as a Move Object
         */
        
        
        
    }
    
    
    
}
