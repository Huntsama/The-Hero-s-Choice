import java.util.Scanner;

public class GameLogic {
    private Player player;
    private Scanner scanner;

    public GameLogic() {
        this.player = new Player();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the Hero's choice game ");
        System.out.println("You are an adventurer in a forest ");

        exploreCave();
        System.out.println("Thanks for playing");
        scanner.close();
    }

    private void exploreCave() {
        System.out.println("After following the sound and the women screaming ,you followed at the entery of a cave n");

        while (true) {
            System.out.println("Current location: (" + player.getLocation().getX() + ", " + player.getLocation().getY() +")");
            System.out.print("Enter your command: ");
            String command = scanner.next().toLowerCase();

            if (command.equals("quit")) {
                break;
            } else if (command.equals("help")) {
                displayHelp();
            } else {
                player.move(command);
            }
        }


    }

    private void displayHelp() {
        System.out.println("Available commands:");
        System.out.println("1. north - Move north");
        System.out.println("2. south - Move south");
        System.out.println("3. west - Move west");
        System.out.println("4. east - Move east");
        System.out.println("5. help - Display this help message");
        System.out.println("6. quit - Quit the game");
        System.out.println();
        System.out.println("Objective of the game:");
        System.out.println("Explore your choices carefully, because with your action have consequences. Be mindful of your decisions as you navigate through this adventure.");
    }
}
