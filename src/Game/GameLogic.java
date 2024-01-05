/**
 * The Gamelogic is the main engine of the game, and it contains most of the logic of the game.
 * When the game begins it calls the start method from this class it method to start
 * The displayHelp, pickUpItems,showPickUpItem etc are all called from this class
 *
 */


//The class is in the Game package
package Game;

//Importing Game Objects from various packages
import Characters.Ally;
import Characters.Enemy;
import Characters.NPC;
import Objects.Item;
import Characters.Player;
import Objects.Story;
import Objects.UserInterface;

//importing Scanner from the Standard Java Package
import java.util.Scanner;

public class GameLogic {

    //Creating instance variables of the class
    private Player player;
    private Scanner scanner;
    private Item torch, map, sword;
    private Ally miner;
    private Ally princess;
    private Enemy kidnapper;
    private Story story;
    private UserInterface userInterface;


    /**
     * Constructor to instantiate the class instances
     * Items, Ally and Enemy and their locations are initialized
     */
    public GameLogic() {
        this.player = new Player();
        this.scanner = new Scanner(System.in);
        this.torch = new Item("Torch", 2, 2);
        this.map = new Item("Map", 0, 1);
        this.sword = new Item("Sword", 0, 2);
        this.miner = new Ally("miner", "miner in the cave",1, 1);
        this.princess = new Ally("girl", "kidnapped girl",3, 3);
        this.kidnapper = new Enemy("kidnapper","The kidnapper" ,4, 4,this);
        this.story = new Story();
        this.userInterface = new UserInterface();
    }


    /**
     *  The method start is called in the main to begin the game
     *  When the game began the introStory, firstStory and exploreCave() methods are called.
     * @throws Exception throw a generic exception of type Exception
     */

    public void start() throws Exception {
        userInterface.startGame();
        story.introStory();
        story.firstStory();
        exploreCave();
        System.out.println("Thanks for playing"); //this is printed when you quit the game
        scanner.close();

        throw new Exception("An error occurred when starting the game.");
    }

    /**
     *  The exploreCave method allows for the interaction of the player.
     *  It allows the player to make an input by typing a command
     *  Until the player types quit, the user can type various command to interact with the game
     * @throws Exception throw a generic exception of type Exception
     */
    private void exploreCave() throws Exception {

//      System.out.println("Current location: (" + player.getLocation().getX() + ", " + player.getLocation().getY() + ")");

        while (true) {
            showPickUpItem();
            showNpcEncounter();
            leavingCave();
            System.out.print("Enter your command: ");
            String command = scanner.nextLine().toLowerCase();
            switch (command) {
                case "quit":
                    return;
                case "help":
                    displayHelp();
                    break;
                case "inventory":
                    player.checkInventory();
                    break;
                case "torch":
                case "map":
                case "sword":
                    player.useItem(command);
                    break;
                default:
                    player.move(command);
                    break;
            }
        }

    }


    /**
     * The help method display the various commands and how to use them in the game
     * by indicating the keywords to type when playing the game
     */
    private void displayHelp() {

        System.out.println("\n\5----------------------------------------------------------------\5");
        System.out.println("\nThe \"help\" command displays a list of available commands that can be used in the game.\n\nHere is a list of commands that you can use:");
        System.out.println("<direction>: Moves the player in the specified direction (north, south, west, east)");
        System.out.println("\"inventory\"  - Check your inventory");
        System.out.println("\"type <item name>\" - Use an item from your inventory");
        System.out.println("\"help\" - Display this help message");
        System.out.println("\"quit\" - Quit the game");
        System.out.println("Objective of the game:");
        System.out.println("Explore your choices carefully, because your actions have consequences. Be mindful of your decisions as you navigate through this adventure.");
    }


    /**
     *  The pickUpItem method is limited to the GameLogic class only and checks a number of conditions.
     *  If the item has not been encountered and is at the same location as the player,
     *  prompts the player to decide whether to pick it up or not.
     *
     * @param item The item to be picked up
     */
    private void pickUpItem(Item item) {
        // Check if the item is not yet encountered and is at the player's current location
        if (!item.isEncountered() && player.getLocation().getX() == item.getLocation().getX()
                && player.getLocation().getY() == item.getLocation().getY()) {
            // Prompt the player to pick up the item
            System.out.println("you found a " + item.getName() + ". do you want to pick it up? (type yes to pick it up)");

            // Set up a loop to handle valid responses
            boolean validResponses =false;
            while (!validResponses){
                // Get the player's response
                String response = scanner.nextLine().toLowerCase();
                // Check the response
                if("yes".equals(response)){
                    // If the player chooses to pick up the item
                    item.setEncountered(true);
                    player.pickUpItem(item);
                    validResponses = true;
                } else if ("no".equals(response)) {
                    // If the player chooses not to pick up the item
                    validResponses = true;
                    System.out.println("You ignored the " + item.getName() + " and did not pick it up");

                }else{
                    // If the response is invalid, prompt the player again
                    System.out.println("Invalid response. Please type 'yes' or 'no' ");
                }

            }


        }
    }

    /**
     * Shows available items and prompts the player to pick them up
     * The method is accessed only within this class
     * this calls the pickUpItem method with the instance of the item such as torch, map and sword
     */
    private void showPickUpItem() {
        pickUpItem(torch);
        pickUpItem(map);
        pickUpItem(sword);
    }


    /*
the method is accessed only within this class
this calls the NpcEncounter method with various instances of the super class Characters.NPC
 */
    private void showNpcEncounter() throws InterruptedException {
        npcEncounter(miner);
        npcEncounter(kidnapper);
        npcEncounter(princess);
    }


    /*
     the npcEncounter is the similar to the pickUpItem method.However, this method compares the location of the player
     to and  Characters.NPC which can either be an Characters.Ally or an Characters.Enemy. If the conditions are met an Characters.NPC shows ups.
    @param Characters.NPC : npc
     */

    private void npcEncounter(NPC npc) throws InterruptedException {
        if (!npc.isEncountered() && npc.getLocation().getX() == player.getLocation().getX()
                && npc.getLocation().getY() == player.getLocation().getY()) {
            System.out.println("You encounter " + npc.getName());
            npc.setEncountered(true);
            if (npc instanceof Enemy) {
                ((Enemy) npc).enemyEncounter(player);
            } else if (npc instanceof Ally) {
                ((Ally) npc).allyEncounter(player);
            }

        }
    }
    public void quit(){
        System.out.println("Game Over");
        System.out.println("Thank you for playing ");
        System.exit(1);
    }

    private void leavingCave() throws InterruptedException {
        if (player.getLocation().getX() == 0 && player.getLocation().getY() == -1) {
            System.out.println("You left the cave");
            story.neutralEnding();
            quit();
        }
    }

}
