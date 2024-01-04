package Characters;/*
the player class is defines the properties, functionality and operations of the player
it has the move method which is define the movement of the player to varous coordinates
the player can also pick up an item when encountered it and add to the inventory
the player can as well use the use the item in the inventory

 */


import Game.GameLogic;
import Objects.Inventory;
import Objects.Item;
import Objects.Location;
import Objects.Story;


public class Player {


    private Location location;
    private Inventory inventory;
    private Story story;
    private GameLogic gameLogic;


    //passing the Game.GameLogic instance to the Characters.Player constructor
    public Player(GameLogic gameLogic) {
        this.location = new Location(0, 0);
        this.inventory = new Inventory();
        this.story = new Story();
        this.gameLogic = gameLogic;
    }

    //returning the location of the player
    public Location getLocation() {
        return location;
    }

    /*
    the move method uses switch case to move the player to north, south ,west and east based on the location
    in other to avoid error all input from the user is converted to lowerCase.
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

    /*
    the useItem method allows the player to use items in the inventory
    based on the item selected to be used the description and consequencies are displayed
     */
    public void useItem(String itemName) throws Exception {
        if (inventory.contains(itemName)) {
            switch (itemName.toLowerCase()) {
                case "torch":
                    System.out.println("You turn the torch on, but now your cover is blown and an enemy is following you!");
                    story.badEnding();
                    gameLogic.quit();
                    break;
                case "map":
                    System.out.println("This is where you are: " + getLocation());
                    break;
                case "sword":
                    System.out.println("You wield the sword, ready for battle!");
                    break;
                default:
                    System.out.println("Invalid command type -> help <- for more information");
            }
        } else {
            System.out.println("You don't have this item in your inventory.");
        }
    }

    /*
    the pickUpItem allow the player to to add items it encounters into the inventory
     */
    public void pickUpItem(Item item) {
        inventory.addItem(item);
        System.out.println(item.getName() + " is added to your inventory list");
    }

    /*
    the checkInventory allow the player to display the inventory
     */
    public void checkInventory() {
        inventory.showInventory();
    }


    public boolean hasItem(String itemName) {
        return inventory.contains(itemName);
    }

}
