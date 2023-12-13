public class Player {
    private Location location;
    private Inventory inventory;

    public Player() {
        this.location = new Location(0, 0);
        this.inventory = new Inventory();
    }

    public Location getLocation() {
        return location;
    }

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

    public void useItem(String itemName) {
        if (inventory.contains(itemName)) {
            switch (itemName.toLowerCase()) {
                case "torch":
                    System.out.println("You turn the torch on, but now your cover is blown and an enemy is following you!");
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

    public void pickUpItem(Item item) {
        inventory.addItem(item);
        System.out.println("Picked up: " + item.getName());
    }

    public void checkInventory() {
        inventory.showInventory();
    }
}
