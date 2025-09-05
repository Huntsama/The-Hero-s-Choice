package entities;

/*
the Enemy is an NPC and therefore inherit the characteristics of the NPC class
the enemy is a dangerous NPC that will attempt to not allow the player to accomplished
the mission.
 */


public class Enemy extends NPC {
 public Enemy(String name,String description, int x, int y){
     super(name,description,x,y); //this calls the constructor of the superclass NPC with the provided arguments
 }
}