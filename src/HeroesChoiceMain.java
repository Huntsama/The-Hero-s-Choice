import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HeroesChoiceMain {

    //start the game from this class
    public static void main(String[] args) throws Exception {
        GameLogic gameLogic = new GameLogic();
        Story story = new Story();
        Scanner input = new Scanner(System.in);
        story.introStory();
        gameLogic.selectOption();
        System.out.println("Enter a command");

        try {
            while (true){
                int command = 1;
                command = input.nextInt();
                switch (command){
                    case 1:
                        gameLogic.newGame();
                        break;
                    case 2:
                        gameLogic.loadPreviousGame();

                        break;
                    default:
                        System.out.println("Enter a valid command 1 - 2");

                }
            }

        }catch (Exception e){
            System.out.println("Something went wrong");
        }


        }
        //gameLogic player = new GameLogic("","");
        //player.start();


}