package Objects;

public class Story {

    public Story(){}

    /*
About the game story and introduction of the game method
this is used to welcome the player and introduce the game and the mission to the player
the method uses thread.sleep and time in millisconds to animate the introduction story
by looping through and displaying the words one after the other with the time specified.
*/
    public void introStory() throws InterruptedException {

        String aboutGame ="Welcome to the Hero's choice game! In this text-based game you are an adventurer travelling around to go back to your village\nthen out of nowhere you heard a woman screaming from a cave\nyou then decided to rescue the lady by going through the cave\nAfter following them to the cave an adventure ensured\nas the player you decides what happens.\nyour actions have consequences\nEnter help to display Help commands!\n \nLet the game begin!\n ";
        for(int i= 0; i<aboutGame.length(); i++){
            System.out.print(aboutGame.charAt(i));
            Thread.sleep(15); //reference from: https://www.geeksforgeeks.org/thread-sleep-method-in-java-with-examples/
        }
        Thread.sleep(700);
        System.out.println();

    }

    public void firstStory() throws InterruptedException{
        String firstSt ="You are at the entrance of the cave where you followed the screams of the girl.\nYou've gathered all the courage you have to enter and try to save the girl.";
        for(int i= 0; i<firstSt.length(); i++){
            System.out.print(firstSt.charAt(i));
            Thread.sleep(15); //reference from: https://www.geeksforgeeks.org/thread-sleep-method-in-java-with-examples/
        }
        Thread.sleep(700);
        System.out.println();
    }

    public void goodEnding() throws InterruptedException {
        String ending ="You bravely rescued the girl in the cave, who happens to be the lost princess.\nThe kingdom appreciates your heroism, and you become their king, ruling together. Love blossoms,\nand you both live happily ever after.";
        for(int i= 0; i<ending.length(); i++){
            System.out.print(ending.charAt(i));
            Thread.sleep(15);
        }
        Thread.sleep(700);
        System.out.println();
    }

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
