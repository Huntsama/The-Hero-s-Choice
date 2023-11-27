import java.util.Scanner;

public class GameLogic {
    private Player player;
    private Scanner scanner;

    public GameLogic(){
        this.player = new Player();
        this.scanner = new Scanner(System.in);
    }
    public void start(){
        System.out.println("Welcome to the Text Adventure Game!");
        System.out.println("You are adventurer in a village ");

        exploreVillage();
        System.out.println("Thanks for playing");
        scanner.close();
    }

    private void exploreVillage(){
        System.out.println("You explore the vallage. Everything seems peaceful.");
        while (true){
            System.out.println("What do you want to do?");
            System.out.println("1. Listen for the source of the 'Help' sound ");
            System.out.println("2. Continue exploring the village ");
            System.out.println("3. Quit the game ");
            System.out.print("Enter Choice: ");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    listenForHelp();
                    break;
                case 2:
                    continueExploring();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }


    }

    private void listenForHelp(){
        System.out.println("You listen carefully and hear a  'Help' from the cave");

        if(!player.hasResueAttempted()){
            System.out.println("You decide to check the source of the sound");

            System.out.println("As you approach the cave, you see a man dragging a woman");
            System.out.println("What do you want to do? ");
            System.out.println("1. Rascue the woman");
            System.out.println("2. Ignore and continue exploring ");
            System.out.print("Enter Choice: ");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    rescueWaman();
                    break;
                case 2:
                    System.out.println("You choose to ignore and continue exploring");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again");
            }
        }
        else {
            System.out.println("You already attempted to rescue the woman. The man is gone.");
        }
    }
    private void rescueWaman(){
        System.out.println("You decided to resuce the woman.");
        //Add more story elements later and choices based on the player's decision here

        player.setRescueAttempted(true);
        System.out.println("Thanks for playing the Hero's Choice");
        System.exit(0);
    }
    private void continueExploring(){
        System.out.println("You decide to continue exploring the village");
        //Add more store and elements and choices later based on the players decision

    }
}
