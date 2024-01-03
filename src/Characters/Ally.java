package Characters;

import java.util.Objects;

/*
the Characters.Ally class inherit from the Characters.NPC class
the Characters.Ally are the friendly Characters.NPC that will interact and guide the player
when the player meet them in their specified location
 */
public class Ally extends NPC {

    public Ally(String name,String description, int x, int y) {
        super(name, description, x, y);   //this calls the constructor of the superclass Characters.NPC with the provided arguments
    }

    public void allyEncounter(Player player) throws InterruptedException {
        if (Objects.equals(getName(), "girl")) {
            System.out.println("oh my god , I managed to escape. but he wont stop following me , \nplease help me i saw that he dropped his sword back in the north-west of the cave");
        } else {
            System.out.println("i was mining when I got scared by the screams of a girl getting dragged by a tall and strong guy . \nI threw my torch in the south-east, and I saw him  going north-east. \nBe cautious with the torch, it's quite bright!");
        }
    }


}
