import java.util.Scanner;
/*
the game logic class contains most of the logic of the game
when the game begins it calls the start method from this class
it method to start, display help, pickupitems,  showPickUpItem etc
 */
public class GameLogic {

    //instance variables
    private Player player;
    private Scanner scanner;
    private Item torch, map, sword;
    private Ally miner;
    private Ally princess;
    private Enemy kidnapper;
    private Story story;

    /*
    constructor to instantiate the gameLogic
    some item, Ally and Enemy and their location are placed as the game starts

     */
    public GameLogic() {
        this.player = new Player(this);
        this.scanner = new Scanner(System.in);
        this.torch = new Item("Torch", 2, 2);
        this.map = new Item("Map", 0, 1);
        this.sword = new Item("Sword", 0, 2);
        this.miner = new Ally("miner", "miner in the cave",1, 1);
        this.princess = new Ally("girl", "kidnapped girl",3, 3);
        this.kidnapper = new Enemy("kidnapper","The kidnapper" ,4, 4,this);
        this.story = new Story();
    }
    /*
    the method starts is called in the main to being the game
    when the game becomes the introStroy and exploreCave() are called.
     */

    public void start() throws Exception {
        story.introStory();
        exploreCave();
        System.out.println("Thanks for playing"); //this is printed when you quit the game
        scanner.close();
    }

    /*
    About the game story and introduction of the game method
    this is used to welcome the player and introduce the game and the mission to the player
    the method uses thread.sleep and time in millisconds to animate the introduction story
    by looping through and displaying the words one after the other with the time specified.
     */

    public void introStory() throws InterruptedException {

        String aboutGame ="Welcome to the Hero's choice game! In this text-based game you are an adventurer travelling around a village\nexploring the beautiful tranquility of the universe you heard a woman screaming from a cave\nyou then decided to rescue the lady by going through the cave\nAfter following them to the cave an adventure ensured\nas the player the choices you make after the story and decides what happens.\nPrepare yourself for an adventure that will test your courage.\nEnter help to display Help commands!\n \nLet the game begin!\n ";
        for(int i= 0; i<aboutGame.length(); i++){
            System.out.print(aboutGame.charAt(i));
            Thread.sleep(15); //reference from: https://www.geeksforgeeks.org/thread-sleep-method-in-java-with-examples/
        }
        Thread.sleep(700);
        System.out.println();

    }


    /*
    the exploreCave method allows for the interaction of the player
    it allows the player to make an input by typing a command
    Until the player types quite, it will display the various options for the user to chose
    using the switch case to display various method and decisions
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


    /*
    the help method display the various commands and how to use them in the game
    by indicating the keywords to type when playing the game
     */
    private void displayHelp() {

        System.out.println("\n\5----------------------------------------------------------------\5");
        System.out.println("\nThe \"help\" command displays a list of available commands that can be used in the game.\n\nHere is a list of commands that you can use:");
        System.out.println("<direction>: Moves the player in the specified direction (north, south, west, east)");
        System.out.println("\"inventory\"  - Check your inventory");
        System.out.println("\"use <item>\" - Use an item from your inventory");
        System.out.println("\"help\" - Display this help message");
        System.out.println("\"quit\" - Quit the game");
        System.out.println("Objective of the game:");
        System.out.println("Explore your choices carefully, because your actions have consequences. Be mindful of your decisions as you navigate through this adventure.");
    }


    /*
    the pickUpItem is limited to the GameLogic class only and checks a number of conditions to see if the player
    has encountered an item or not through checking the position of the player and the position of the item the conditions are
    if the item has not been encountered yet. (!item.isEncountered) and also
    compares the x and y coordinates of the players location with those of the items location to see if they match
    if the conditions are met, the code inside the if block is executed and the player takes decision based on it.
    @param item : item
     */
    private void pickUpItem(Item item) {
        if (!item.isEncountered() && player.getLocation().getX() == item.getLocation().getX()
                && player.getLocation().getY() == item.getLocation().getY()) {
            System.out.println("you found a " + item.getName() + ". do you want to pick it up? (type yes to pick it up)");
            String response = scanner.nextLine().toLowerCase();
            item.setEncountered(true);
            if (response.equals("yes")) {
                player.pickUpItem(item);
            } else {
                System.out.println("you ignored the " + item.getName() + " and you did not picked it up.");
            }
        }
    }

/*
the method is accessed only within this class
this calls the pickUpItem method with the instance of the item such as torch, map,sword
 */
    private void showPickUpItem() {
        pickUpItem(torch);
        pickUpItem(map);
        pickUpItem(sword);
    }


    /*
the method is accessed only within this class
this calls the NpcEncounter method with various instances of the super class NPC
 */
    private void showNpcEncounter() throws InterruptedException {
        NpcEncounter(miner);
        NpcEncounter(kidnapper);
        NpcEncounter(princess);
    }


    /*
     the NpcEncounter is the similar to the pickUpItem method.However, this method compares the location of the player
     to and an NPC which can either be an Ally or an Enemy. If the conditions are met an NPC shows ups.
    @param NPC : npc
     */
    private void NpcEncounter(NPC npc) throws InterruptedException {
        if (!npc.isEncountered() && npc.getLocation().getX() == player.getLocation().getX()
                && npc.getLocation().getY() == player.getLocation().getY()) {
            System.out.println("You encounter " + npc.getName());
            npc.setEncountered(true);
            if (npc instanceof Enemy) {
                ((Enemy) npc).encounter(player);
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
