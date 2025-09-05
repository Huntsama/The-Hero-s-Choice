
/*
the NPC class is a generally class for the Ally and the Enemy

 */

import java.io.Serializable;

public class NPC implements Serializable {
    //instance variables
    private String description;
    private String name;
    private Location location;
    private boolean encountered;

    //Constructor to instantiate the NPC class
    public NPC(String name, String description, int x, int y) {
        this.description = description;
        this.name = name;
        this.location = new Location(x, y); //the location of NPC is set  to x, y
        this.encountered = false; // the encounter is initially set to false
    }

    //return the NPC name
    public String getName() {
        return name;
    }

    //return the NPC location
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