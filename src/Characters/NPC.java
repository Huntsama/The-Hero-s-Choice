/**
 *  The NPC (Non-Player Character) class represents characters within the game world
 *  that the player can interact with. Each NPC has a name, description, location, and encounter status.
 *  The location is specified by x and y coordinates, and the encounter status indicates
 *  whether the NPC has been encountered by the player.
 *  The class provides methods to access and modify the NPC's name, location, and encounter status.
 *  The Enemy and Ally inherit from this class
 */

//The class is in the Characters package
package Characters;

//import location from the Objects package
import Objects.Location;

public class NPC {
    //instance variables
    private String description;
    private String name;
    private Location location;
    private boolean encountered;

    /**
     *  Constructor to instantiate the NPC class
     *  The constructor initializes the NPC with the given name, description, and coordinates.
     * @param name The name of the NPC
     * @param description A brief description of the NPC
     * @param x The x-coordinate of the NPC's location
     * @param y The y-coordinate of the NPC's location
     */
    public NPC(String name, String description, int x, int y) {
        this.description = description;
        this.name = name;
        this.location = new Location(x, y);
        this.encountered = false; // the encounter status is initially set to false
    }

    /**
     * Get the name of the NPC
     * @return The name of the NPC
     */
    public String getName() {
        return name;
    }

    /**
     * Get the location of the NPC
     * @return The location of the NPC
     */
    public Location getLocation() {
        return location;
    }


    /**
     * Returns the encounter status of the NPC
     * @return true if the NPC has been encountered, false otherwise
     */
    public boolean isEncountered() {
        return encountered;
    }

    /**
     * Sets the encounter status of the NPC.
     * @param encountered encountered The new encounter status.
     */
    public void setEncountered(boolean encountered) {
        this.encountered = encountered;
    }
}