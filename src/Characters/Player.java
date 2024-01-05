/**
 * The player class is define the properties, functionality and operations of the player.
 * It has the move method which is defined the movement of the player to various coordinates
 * The player can also pick up an item when encountered it and add to the inventory
 * The player can as well use the item in the inventory
 */

//The class is in the Objects package
package Characters;

//Importing Game Objects from various packages
import Game.GameLogic;
import Objects.Inventory;
import Objects.Item;
import Objects.Location;
import Objects.Story;


public class Player {

    //creating instance variables  of location, inventory, Story and GameLogic
    private Location location;
    private Inventory inventory;
    private Story story;
    private GameLogic gameLogic;


    /**
     *Constructor to instantiate the player class with default attributes
     *Initializes the player location starting at (0,0)
     */
    public Player() {
        this.location = new Location(0, 0);
        //Create an empty inventory for the player
        this.inventory = new Inventory();
        //Initialize the player's story
        this.story = new Story();
    }

    /**
     * Get the value of the location
     * @return the value of the location
     */
    public Location getLocation() {
        return location;
    }

    /**
     *  The move method uses switch case to move the player to north, south ,west and east based on the location
     *  in other to avoid input errors from the user is inputs from the player is  converted to lowerCase.
     *  When directional command is entered its respective method in the location class is triggered
     * @param direction entered by the player
     */
    public void move(String direction) {
        switch (direction.toLowerCase()) {
            case "north":
                location.moveNorth();
                break;
            case "south":
                location.moveSouth();
                break;
            case "west":
                location.moveWest();
                break;
            case "east":
                location.moveEast();
                break;
            default:
                System.out.println("Invalid command type -> help <- for more information");
        }
    }

    /**
     * The method allow the player to use a specified item from the player's inventory.
     * It  handles different effects based on the type of item used
     * @param itemName The name of the item to be used
     * @throws Exception Exception If an unexpected situation occurs during item usage.
     */
    public void useItem(String itemName) throws Exception {
        if (inventory.contains(itemName)) {
            switch (itemName.toLowerCase()) {
                // If using a torch, trigger a bad ending scenario
                case "torch":
                    System.out.println("You turn the torch on, but now your cover is blown and an enemy is following you!");
                    story.badEnding();
                    gameLogic.quit();
                    break;
                case "map":
                    // If using a map, display the player's current location
                    System.out.println("This is where you are: " + getLocation());
                    break;
                case "sword":
                    // If using a sword, prepare for battle
                    System.out.println("You wield the sword, ready for battle!");
                    break;
                default:
                    // Handle invalid item names
                    System.out.println("Invalid command type -> help <- for more information");
            }
        } else {
            // Handle the case when the item is not in the player's inventor
            System.out.println("You don't have this item in your inventory.");
        }
    }

    /**
     * The method allow for a specified item to be added to the player's inventory list
     * and print a confirmation message
     * @param item The item to be picked up and added to the player's inventory
     */
    public void pickUpItem(Item item) {
        inventory.addItem(item);
        System.out.println(item.getName() + " is added to your inventory list");
    }

    /**
     *  The method display the contents of the player's inventory by
     *  calling the showInventory method to print a list of items currently held by the player
     */
    public void checkInventory(){
        inventory.showInventory();
    }

    /**
     * The method check if the player's inventory contains an item with the specified name
     * @param itemName The name of the item to check for in the player's inventory
     * @return true if the item is present in the inventory, false otherwise
     */
    public boolean hasItem(String itemName){
        return inventory.contains(itemName);
    }
}
