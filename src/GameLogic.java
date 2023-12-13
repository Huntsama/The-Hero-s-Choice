import java.util.Scanner;

public class GameLogic {
    private Player player;
    private Scanner scanner;
    private Item torch, map, sword;

    public GameLogic() {
        this.player = new Player();
        this.scanner = new Scanner(System.in);
        this.torch = new Item("Torch", 2, 2);
        this.map = new Item("Map", 0, 1);
        this.sword = new Item("Sword", 0, 2);
    }
    public void start() throws InterruptedException {
        introStory();
//        System.out.println("Welcome to the Hero's choice game");
//        System.out.println("You are an adventurer in a forest");
        exploreCave();
        System.out.println("Thanks for playing");
        scanner.close();
    }

    //The about story and introduction of the game
    public void introStory() throws InterruptedException {
        String BLUE = "\u001B[34m";
        String aboutGame = BLUE + "Welcome to the Hero's choice game! In this text-based game you are an adventurer travelling around a village\nexploring the beautiful tranquility of the universe\nyou heard a woman screaming from a cave, you then decided to rescue the lady by going through the cave\nAfter following them to the cave an adventure ensured\nas the player the choices you make after the story and decides what happens.\nPrepare yourself for an adventure that will test your courage.\nLet the game begin!\n ";
        for(int i= 0; i<aboutGame.length(); i++){
            System.out.print(aboutGame.charAt(i));
            Thread.sleep(15); //reference from: https://www.geeksforgeeks.org/thread-sleep-method-in-java-with-examples/
        }
        Thread.sleep(700);
        System.out.println();

    }

    private void exploreCave() {

       // System.out.println("After following the sound and the women screaming, you followed at the entry of a cave.");
//      System.out.println("Current location: (" + player.getLocation().getX() + ", " + player.getLocation().getY() + ")");

        while (true) {
            showPickUpItem();
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


    private void displayHelp() {

        System.out.println("\n\5----------------------------------------------------------------\5");
        System.out.println("\nThe \"help\" command displays a list of available commands that can be used in the game.\n\nHere is a list of commands that you can use:");
//        System.out.println("Available commands:");
        System.out.println("<direction>: Moves the player in the specified direction (north, south, west, east");
//        System.out.println("1. north - Move north");
//        System.out.println("2. south - Move south");
//        System.out.println("3. west - Move west");
//        System.out.println("4. east - Move east");
        System.out.println("\"inventory\"  - Check your inventory");
        System.out.println("\"use <item>\" - Use an item from your inventory");
        System.out.println("\"help\" - Display this help message");
        System.out.println("\"quit\" - Quit the game");
        System.out.println("Objective of the game:");
        System.out.println("Explore your choices carefully, because your actions have consequences. Be mindful of your decisions as you navigate through this adventure.");
    }

    private void pickUpItem(Item item) {
        if (!item.isEncountered() && player.getLocation().getX() == item.getLocation().getX()
                && player.getLocation().getY() == item.getLocation().getY()) {
            System.out.println("you found a " + item.getName() + ". do you want to pick it up? (yes/no)");
            String response = scanner.nextLine().toLowerCase();
            item.setEncountered(true);
            if (response.equals("yes")) {
                player.pickUpItem(item);
            } else {
                System.out.println("you ignored the " + item.getName() + "and you did not picked it up.");
            }
        }
    }

    private void showPickUpItem() {
        pickUpItem(torch);
        pickUpItem(map);
        pickUpItem(sword);
    }




}
