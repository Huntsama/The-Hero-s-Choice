package Characters;
import Objects.Location;
/*
the Characters.NPC class is a generally class for the Characters.Ally and the Characters.Enemy

 */
public class NPC {
    //instance variables
    private String description;
    private String name;
    private Location location;
    private boolean encountered;

    //Constructor to instantiate the Characters.NPC class
    public NPC(String name, String description, int x, int y) {
        this.description = description;
        this.name = name;
        this.location = new Location(x, y); //the location of Characters.NPC is set  to x, y
        this.encountered = false; // the encounter is initially set to false
    }

    //return the Characters.NPC name
    public String getName() {
        return name;
    }

    //return the Characters.NPC location
    public Location getLocation() {
        return location;
    }


    //returned the encountered
    public boolean isEncountered() {
        return encountered;
    }

    //set the encountered to encountered
    public void setEncountered(boolean encountered) {
        this.encountered = encountered;
    }
}