package Characters;

/*
the Characters.Ally class inherit from the Characters.NPC class
the Characters.Ally are the friendly Characters.NPC that will interact and guide the player
when the player meet them in their specified location
 */
public class Ally extends NPC {

    public Ally(String name,String description, int x, int y) {
        super(name, description, x, y);   //this calls the constructor of the superclass Characters.NPC with the provided arguments
    }


}
