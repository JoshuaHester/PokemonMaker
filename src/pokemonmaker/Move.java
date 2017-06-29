package pokemonmaker;

/**
 *
 * @author Joshua Hester
 */
public class Move {
    
    private int entry;
    private int power;
    private int pp;
    private Type type;
    private String name;
    private Movetype movetype;
    
    public void Move(int entry,int pp,String name,Type type,int power,Movetype movetype){
        this.entry=entry;
        this.pp=pp;
        this.name=name;
        this.type=type;
        this.power=power;
        this.movetype=movetype;
    }
    
    
    
}
