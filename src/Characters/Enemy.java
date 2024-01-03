package Characters;/*
the Characters.Enemy is an Characters.NPC and therefore inherit the characteristics of the Characters.NPC class
the enemy is a dangerous Characters.NPC that will attempt to not allow the player to accomplished
the mission.
 */

import Game.GameLogic;
import Objects.Story;

public class Enemy extends NPC {
    private Story story;
    private GameLogic gameLogic;

    public Enemy(String name,String description, int x, int y , GameLogic gameLogic){
     super(name,description,x,y); //this calls the constructor of the superclass Characters.NPC with the provided arguments
        this.story = new Story();
        this.gameLogic = gameLogic;
    }



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