package pokemonmaker;

/**
 *
 * @author Joshua Hester
 */
public class Pokemon {
    /**
     * Stores data from XMLReader to be read into the Database 
     * and for generated Pokemon
     */
    private Type primaryType = null;
    private Type secondaryType = Type.NULL;
    private Ability primaryAbility = null;
    private Ability secondaryAbility = Ability.NULL;
    private Ability hiddenAbility = Ability.NULL;
    private Ability ownedAbility = Ability.NULL;
    private String species = null;
    private String nickname = null;
    private int generation;
    private int nationalIndex;
    private int regionalIndex;
    private int form = 0;
    private int creationIndex; //order the database of user generated pokemon
    private int[] stats;
    private int[] evs;
    private int[] ivs;
    
    public Pokemon(){
        stats = new int[7];
        evs = new int[7];
        ivs = new int[7];
    }
    //type
    public void setPrimaryType(Type type){primaryType = type;}
    public String getPrimaryType(){return primaryType.toString();}
    public void setSecondaryType(Type type){secondaryType = type;}
    public String getSecondaryType(){return secondaryType.toString();}
    //ability
    public void setPrimaryAbility(Ability ability){primaryAbility = ability;}
    public String getPrimaryAbility(){return primaryAbility.toString();}
    public void setSecondaryAbility(Ability ability){secondaryAbility = ability;}
    public String getSecondaryAbility(){return secondaryAbility.toString();}
    public void setHiddenAbility(Ability ability){hiddenAbility = ability;}
    public String getHiddenAbility(){return hiddenAbility.toString();}
    public void setOwnedAbility(Ability ability){ownedAbility = ability;}
    public String getOwnedAbility(){return ownedAbility.toString();}
    //species name, nickname, index numbers
    public void setSpecies(String name){species = name;}
    public String getSpecies(){return species;}
    public void setNickname(String name){nickname = name;}
    public String getNickname(){return nickname;}
    public void setGeneration(int index){generation = index;}
    public int getGeneration(){return generation;}
    public void setNationalIndex(int index){nationalIndex = index;}
    public int getNationalIndex(){return nationalIndex;}
    public void setRegionalIndex(int index){regionalIndex = index;}
    public int getRegionalIndex(){return regionalIndex;}
    public void setCreationIndex(int index){creationIndex = index;}
    public int getCreationIndex(){return creationIndex;}
    public void setForm(int index){form = index;}
    public int getForm(){return form;}
    //stats, evs, and ivs,
    public void setStats(int hp, int att, int def, int spa, int spd, int speed, int total){
        stats[0]=hp;
        stats[1]=att;
        stats[2]=def;
        stats[3]=spa;
        stats[4]=spd;
        stats[5]=speed;
        stats[6]=total;
    }
    public int getStats(int index){return stats[index];}
    public void setEVs(int hp, int att, int def, int spa, int spd, int speed, int total){
        evs[0]=hp;
        evs[1]=att;
        evs[2]=def;
        evs[3]=spa;
        evs[4]=spd;
        evs[5]=speed;
        evs[6]=total;
    }
    public int getEVS(int index){return evs[index];}
    public void setIVs(int hp, int att, int def, int spa, int spd, int speed, int total){
        ivs[0]=hp;
        ivs[1]=att;
        ivs[2]=def;
        ivs[3]=spa;
        ivs[4]=spd;
        ivs[5]=speed;
        ivs[6]=total;
    }
    public int getIVS(int index){return evs[index];}
    
    
}
