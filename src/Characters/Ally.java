/**
 *The Ally class represents friendly characters within the game world that the player may encounter.
 *Extends the NPC class
 *Each Ally has a name, description, location, and encounter status
 *
 */

//The class is in the Characters package
package Characters;
//import Objects from the Standard java class
import java.util.Objects;


public class Ally extends NPC {

    /**
     * Constructor to instantiate the Ally class
     * @param name The name of the ally
     * @param description A brief description of the ally
     * @param x The x-coordinates of the ally's location
     * @param y The y-coordinates of teh ally's location
     */
    public Ally(String name,String description, int x, int y) {
        super(name, description, x, y);   //Calls the constructor of the superclass NPC with the provided arguments
    }

    /**
     * The method handles specific logic when the player encounter an ally.
     * It provides different dialogues based on the ally's identity.
     * @param player The player involved in the encounter
     * @throws InterruptedException If the encounter involves thread interruption.
     */
    public void allyEncounter(Player player) throws InterruptedException {
        if (Objects.equals(getName(), "girl")) {
            System.out.println("oh my god , I managed to escape. but he wont stop following me , \nplease help me i saw that he dropped his sword back in the north-west of the cave");
        } else {
            System.out.println("i was mining when I got scared by the screams of a girl getting dragged by a tall and strong guy . \nI threw my torch in the south-east, and I saw him  going north-east. \nBe cautious with the torch, it's quite bright!");
        }
    }


}
