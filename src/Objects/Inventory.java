/**
The inventory class stores various items the player has collected
the class contains methods to add items, check items in the inventory and
show items in the inventory
 */


//The class is in the Objects package
package Objects;

//Importing from standard java packages
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    //creating instance variables list of items
    private List<Item> items;

    /**
     * Constructor to Instantiate the class instances
     *
     */
    public Inventory() {
        //creates a new instance of the ArrayList class
        this.items = new ArrayList<>();
    }

    /**
    the method allows to add items in the inventory list
    @param item: item
     */
    public void addItem(Item item){
        items.add(item);
    }

    /**
     *  The contains method allow to check whether if an item is in the inventory or not
     *  it uses an enhance for loop to go through all the items in list and return true if the item is found
     *  and return false otherwise
     * @param itemName the name of the item searched for
     * @return true if found or false otherwise
     */
    public boolean contains(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }

    /**
     *  The showInventory method shows all the items in the list.
     *  It traverses through the list and display all the names of items list if items are found
     *  otherwise it shows the list is empty.
     */
    public void showInventory() {
        if (items.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Your inventory list of items:");
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". " + items.get(i).getName());
            }
        }
    }

}
