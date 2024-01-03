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

        String aboutGame ="Welcome to the Hero's choice game! In this text-based game you are an adventurer travelling around a village\nexploring the beautiful tranquility of the universe you heard a woman screaming from a cave\nyou then decided to rescue the lady by going through the cave\nAfter following them to the cave an adventure ensured\nas the player the choices you make after the story and decides what happens.\nPrepare yourself for an adventure that will test your courage.\nEnter help to display Help commands!\n \nLet the game begin!\n ";
        for(int i= 0; i<aboutGame.length(); i++){
            System.out.print(aboutGame.charAt(i));
            Thread.sleep(15); //reference from: https://www.geeksforgeeks.org/thread-sleep-method-in-java-with-examples/
        }
        Thread.sleep(700);
        System.out.println();

    }

    public void firstStory() throws InterruptedException{
        String firstSt ="You stand at the entrance of the foreboding cave, the cold wind sending shivers down your spine\nInside, echoes of distant water droplets and mysterious sounds hint at the vastness of the caverns beyond\nYour quest is clear - rescue the trapped lady and escape these treacherous depths ";
        for(int i= 0; i<firstSt.length(); i++){
            System.out.print(firstSt.charAt(i));
            Thread.sleep(15); //reference from: https://www.geeksforgeeks.org/thread-sleep-method-in-java-with-examples/
        }
        Thread.sleep(700);
        System.out.println();
    }

    public void goodEnding() throws InterruptedException {
        String ending ="You bravely faced the challenges within the cave and successfully rescued the girl.\nTo your surprise, she reveals herself as the lost princess of the kingdom. Grateful for your heroism,\n she and the entire kingdom recognize you as their savior. Love blossoms between you two, and eventually, you become the king, \n ruling the kingdom together. You both live happily ever after.";
        for(int i= 0; i<ending.length(); i++){
            System.out.print(ending.charAt(i));
            Thread.sleep(15);
        }
        Thread.sleep(700);
        System.out.println();
    }

    public void badEnding() throws InterruptedException {
        try {
            String ending ="Unfortunately, you couldn't rescue the girl, and you got killed by the mob.\nYour  effort ends in failure, and the village mourns the loss of both you and the trapped girl.";
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
        String ending ="Deciding to avoid further trouble, you cautiously make your way out of the cave.Returning home,\nyou rest, leaving the mysteries of the cave behind. Life goes on without any significant changes,\n and the tranquility of the village is undisturbed.";
        for(int i= 0; i<ending.length(); i++){
            System.out.print(ending.charAt(i));
            Thread.sleep(15);
        }
        Thread.sleep(700);
        System.out.println();
    }




}
