
/**
 the item class allows for items to be used in the game
 various items can be created from the item class
 items can also be placed in various locations
 */


//The class is in the Objects package
package Objects;

public class Item {

    //creating instance variables name, location and encountered
    private String name;
    private Location location;
    private boolean encountered;


    /**
     * Constructor to instantiate the class
     * @param name name of an item
     * @param x the x point of the item
     * @param y the y point of the item
     */
    public Item(String name, int x, int y){
        this.name = name;
        this.location = new Location(x,y);
        this.encountered = false;
    }

    /**
     * Get the name of the item
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the Location of the item
     * @return the item location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * the method allow external code to check value of encountered
     * @return get the value of encountered (true or false)
     */
    public boolean isEncountered() {
        return encountered;
    }

    /**
     * the method allow to  Set the value of encountered either true of false
     * @param encountered set the value
     */
    public void setEncountered(boolean encountered){
        this.encountered = encountered;
    }

}
