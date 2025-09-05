import java.io.Serializable;

public class Story implements Serializable {

    public Story(){}

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
}
