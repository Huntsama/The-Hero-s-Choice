package Objects;

/*
the item class allows for items to be used in the game
various items can be created from the item class
items can also be placed in various locations
 */
public class Item {

    //instance variables
    private String name;
    private Location location;
    private boolean encountered;


    //contructor to instantatiate the items
    public Item(String name, int x, int y){
        this.name = name;
        this.location = new Location(x,y);
        this.encountered = false;
    }

    //return the name of the item
    public String getName() {
        return name;
    }

    //return the location  of the item
    public Location getLocation() {
        return location;
    }

    //return the encountered
    public boolean isEncountered() {
        return encountered;
    }
    //set the encountered to encountered
    public void setEncountered(boolean encountered){
        this.encountered = encountered;
    }

}
