/**
 * The Enemy class represents hostile characters within the game world that the player may encounter.
 * Extends the NPC class and includes additional methods related to enemy encounters.
 * Each enemy has a name, description, location, encounter status, story, and game logic.
 * The enemy can trigger different endings based on player interactions.
 *
 * The enemyEncounter method handles the specific logic when the player encounters an enemy,
 * such as checking if the player has a sword and triggering corresponding story endings.
 *
 */

//The class is in the Characters package
package Characters;

//import GameLogic and Story from Game and Objects package respectively
import Game.GameLogic;
import Objects.Story;

public class Enemy extends NPC {
    //Creating instance variables
    private Story story;
    private GameLogic gameLogic;

    /**
     * Constructor to instantiate the Enemy class
     * @param name The name of the enemy.
     * @param description A brief description of the enemy
     * @param x The x-coordinate of the enemy's location
     * @param y The y-coordinate of the enemy's location
     * @param gameLogic the game logic instance associated with the enemy
     */
    public Enemy(String name,String description, int x, int y , GameLogic gameLogic){
     super(name,description,x,y); //Calls the constructor of the superclass NPC with the provided arguments
        this.story = new Story();
        this.gameLogic = gameLogic;
    }

    /**
     * The method handles specific logic when the player encounters an enemy.
     * If the player encounters the enemy and has a sword, the good ending story is triggered
     * @param player The player involved in the encounter
     * @throws InterruptedException  If the encounter involves thread interruption.
     */
    public void enemyEncounter(Player player) throws InterruptedException {
        if (player.hasItem("Sword")) {
            System.out.println("You have defeated " + getName() + " with your sword!");
            story.goodEnding();
            gameLogic.quit();
        } else {
            System.out.println("You encountered " + getName() + " but you don't have a sword. Bad ending!");
            story.badEnding();
            gameLogic.quit();
        }
    }
}