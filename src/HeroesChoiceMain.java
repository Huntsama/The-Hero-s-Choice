import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HeroesChoiceMain {

    //start the game from this class
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        GameLogic gameLogic = new GameLogic();
        Story story = new Story();
        
        story.introStory();
        gameLogic.selectOption();
        System.out.println("Enter a command");

        try {
            while (true){
                int command = input.nextInt();
                input.nextLine(); // Consume the leftover newline
                switch (command){
                    case 1:
                        gameLogic.newGame(input);
                        return;
                    case 2:
                        gameLogic.loadPreviousGame();
                        return;
                    default:
                        System.out.println("Enter a valid command 1 - 2");
                        break;
                }
            }

        }catch (Exception e){
            System.out.println("Something went wrong: " + e.getMessage());
        } finally {
            input.close();
        }
        }
//        GameLogic player = new GameLogic("","");
//        player.start();


}