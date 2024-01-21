/**
 * This is the main class that begins the game
 * A new GameLogic object (player) is created
 * the player object calls the start method in
 * the GameLogic calls to begin the game.
 */


//import GameLogic from the package Game
import Game.GameLogic;

public class Main {
    //start the game from this class
    public static void main(String[] args) throws Exception {
        //Creating a new GameLogic Object
        GameLogic player = new GameLogic();
        //Calling the start method in the GameLogic class
        player.start();
    }
}