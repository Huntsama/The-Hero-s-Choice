package game;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Scanner;
import entities.*;
import items.*;
import utils.*;
/*
the game logic class contains most of the logic of the game
when the game begins it calls the start method from this class
it method to start, display help, pickupitems,  showPickUpItem etc
 */
public class GameLogic implements Serializable {

    //instance variables
    private Player player;
    private transient Scanner scanner;
    private Item torch, map, sword;
    private Ally miner;
    private Ally princess;
    private Enemy kidnapper;

    private Story story;

    public GameLogic(){};
    /*
    constructor to instantiate the gameLogic
    some item, Ally and Enemy and their location are placed as the game starts

     */
    public GameLogic(String pName, String pDescription) {
        this.player = new Player(pName,pDescription);
        this.scanner = new Scanner(System.in);
        this.torch = new Item("Torch", 2, 2);
        this.map = new Item("Map", 0, 1);
        this.sword = new Item("Sword", 0, 2);
        this.miner = new Ally("miner", "you met a miner, he described the area to you and offers support and guidance",1, 1);
        this.princess = new Ally("princess", "you finally met the princess tired so and thirsty",4, 4);
        this.kidnapper = new Enemy("kidnapper","The kidnapper" ,3, 3);
        this.story = new Story();

    }

    public GameLogic(String pName, String pDescription, Scanner scanner) {
        this.player = new Player(pName,pDescription);
        this.scanner = scanner;
        this.torch = new Item("Torch", 2, 2);
        this.map = new Item("Map", 0, 1);
        this.sword = new Item("Sword", 0, 2);
        this.miner = new Ally("miner", "you met a miner, he described the area to you and offers support and guidance",1, 1);
        this.princess = new Ally("princess", "you finally met the princess tired so and thirsty",4, 4);
        this.kidnapper = new Enemy("kidnapper","The kidnapper" ,3, 3);
        this.story = new Story();

    }

    /*
    the method starts is called in the main to being the game
    when the game becomes the introStroy and exploreCave() are called.
     */

    public void start() throws Exception {

        story.firstStory();
        exploreCave();
        //Welcome back message
        System.out.print("Thanks for playing"); //this is printed when you quit the game
        scanner.close();
    }

    /*
    About the game story and introduction of the game method
    this is used to welcome the player and introduce the game and the mission to the player
    the method uses thread.sleep and time in millisconds to animate the introduction story
    by looping through and displaying the words one after the other with the time specified.
     */




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
            System.out.print("Enter your command: ");
            String command = scanner.nextLine().toLowerCase();
            switch (command) {
                case "quit":
                    quiteAndSave();
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
    private void showNpcEncounter() {
        NpcEncounter(miner);
        NpcEncounter(kidnapper);
        NpcEncounter(princess);
    }


    /*
     the NpcEncounter is the similar to the pickUpItem method.However, this method compares the location of the player
     to and an NPC which can either be an Ally or an Enemy. If the conditions are met an NPC shows ups.
    @param NPC : npc
     */
    private void NpcEncounter(NPC npc) {
        if (!npc.isEncountered() && npc.getLocation().getX() == player.getLocation().getX()
                && npc.getLocation().getY() == player.getLocation().getY()) {
            System.out.println("You encounter " + npc.getName() );
            npc.setEncountered(true);

        }
    }

    public void  loadPreviousGame() throws NullPointerException  {
    try {
        GameLogic gameLogic = new LoadGame().loadGame();
        if(gameLogic != null) {
            gameLogic.scanner = new Scanner(System.in); // Reinitialize scanner after deserialization
            //Welcome back message
            System.out.println("\n\4--------------------------------\4");
            System.out.println("WELCOME BACK, " +   gameLogic.player.getName());
            System.out.println("\4--------------------------------\4");

            //users last location  
            System.out.println("\n| You were at, " + gameLogic.player.getLocation());
            System.out.println("\4-------------------------\4");
            gameLogic.start();
        } else {
            System.out.println("You do not have saved game");
        }
    }catch (Exception e){
        System.out.println("You do not have saved game ");
    }

    }




    public  void   newGame(){
        Scanner input = new Scanner(System.in);
        //Taking players name
        System.out.println("Enter your name: ");
        String pName = input.nextLine();

        GameLogic gameLogic = new GameLogic(pName,"Main Player");
        System.out.println("You are in " + gameLogic.player.getLocation());
        System.out.println("\4-------------------------\4");
        try {
            gameLogic.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public  void   newGame(Scanner input){
        //Taking players name
        System.out.println("Enter your name: ");
        String pName = input.nextLine();

        GameLogic gameLogic = new GameLogic(pName,"Main Player", input);
        System.out.println("You are in " + gameLogic.player.getLocation());
        System.out.println("\4-------------------------\4");
        try {
            gameLogic.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void quiteAndSave() throws Exception {
        System.out.println("Do you want to save the progress? (y/n) ");
        String command = scanner.nextLine().toLowerCase().strip();
        try {
            if(command.equals("y")){
                new SaveGame().saveGame(this);
                System.out.println("Game saved");
                for(int i=0; i<3; i++){
                    Thread.sleep(1000);
                    System.out.print(".");
                }
            } else if (command.equals("n")) {
                System.out.println("Quitting the Game");
            }
        } catch (Exception e) {
            System.out.println("Error occurred while saving the game: " + e.getMessage());
        }
    }

    public void selectOption(){
        System.out.println("What do you want to continue with ? ");
        System.out.println("\4-------------------\4 \4-------------------\4");
        System.out.println("   1. NEW GAME          2. PREVIOUS GAME");
        System.out.println("\4-------------------\4 \4-------------------\4 ");
    }





}
