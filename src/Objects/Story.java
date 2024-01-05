/**
 * This class has all the stories of the game
 * Stories are called as and when needed from the class
 * the methods in the class  uses thread.sleep and time in milliseconds to animate the stories
 * by looping through and displaying the Character one after the other with the time specified.
 * Reference from: https://www.geeksforgeeks.org/thread-sleep-method-in-java-with-examples/
 */

//The class is in the Objects package
package Objects;

public class Story {

    //Default constructor
    public Story(){}

    /**
About the game story and introduction of the game method
this is used to welcome the player and introduce the game and the mission to the player
*/
    public void introStory() throws InterruptedException {

        String aboutGame ="Welcome to the Hero's choice game! In this text-based game you are an adventurer travelling around to go back to your village\nthen out of nowhere you heard a woman screaming from a cave, you then decided to rescue the lady by going through the cave\nAfter following them to the cave an adventure ensured,as the player you decides what happens.Remember your actions have consequences.";
        for(int i= 0; i<aboutGame.length(); i++){
            System.out.print(aboutGame.charAt(i));
            Thread.sleep(15);
        }
        Thread.sleep(700);
        System.out.println();
        System.out.println("\4--------------------------------------\4");
        System.out.println("Enter help to display Help commands!");
        System.out.println("\4--------------------------------------\4");
        System.out.println("Let the game begin!");
        System.out.println();

    }

    /**
     * The first story tells the player the current position and the mission at hand
     *The method is called together with the start method when the game begins
     * @throws InterruptedException the method may throw an InterruptionException due to the use of Thread.Sleep
     */
    public void firstStory() throws InterruptedException{
        String firstSt ="You are at the entrance of the cave where you followed the screams of the girl.\nYou've gathered all the courage you have to enter and try to save the girl.";
        for(int i= 0; i<firstSt.length(); i++){
            System.out.print(firstSt.charAt(i));
            Thread.sleep(15);
        }
        Thread.sleep(700);
        System.out.println();
    }

    /**
     * The method is called when a player meets the enemy and the player has a sword
     * @throws InterruptedException the method may throw an InterruptionException due to the use of Thread.Sleep
     */
    public void goodEnding() throws InterruptedException {
        String ending ="You bravely rescued the girl in the cave, who happens to be the lost princess.\nThe kingdom appreciates your heroism, and you become their king, ruling together. Love blossoms,\nand you both live happily ever after.";
        for(int i= 0; i<ending.length(); i++){
            System.out.print(ending.charAt(i));
            Thread.sleep(15);
        }
        Thread.sleep(700);
        System.out.println();
    }

    /**
     * The method is called when a player meets the enemy without a sword or the player light the torch
     * @throws InterruptedException the method may throw an InterruptionException due to the use of Thread.Sleep
     */

    public void badEnding() throws InterruptedException {
        try {
            String ending ="You died trying to rescue the girl, \nbut your efforts were in vain. Both the village and your mother mourn the loss.";
            for (int i = 0; i < ending.length(); i++) {
                System.out.print(ending.charAt(i));
                Thread.sleep(15);
            }
            Thread.sleep(700);
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * The method is called when a player decides to leave the cave without progressing to save the girl
     * @throws InterruptedException the method may throw an InterruptionException due to the use of Thread.Sleep
     */
    public void neutralEnding() throws InterruptedException {
        String ending ="You remember you have to care for your mother and can't risk dying. \nSo, you leave the cave, go back home, and focus on your responsibilities. \nLife goes on as usual in the village.";
        for(int i= 0; i<ending.length(); i++){
            System.out.print(ending.charAt(i));
            Thread.sleep(15);
        }
        Thread.sleep(700);
        System.out.println();
    }




}
