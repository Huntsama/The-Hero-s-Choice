/**
 * The Location class set out the base for the movement in the game
 * x and y are used as points in the plan (matrix) where each point can be increase or decrease
 * showing the movement to either north, south, east and west.
 */

//The class is in the Objects package
package Objects;

public class Location {

    //Creating instance variables x and y
    private int x;
    private int y;

    /**
     * Constructor to instantiate the class instances
     * @param x point for x-coordinate
     * @param y point for y-coordinate
     */
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * get the x value when called
     * @return the  x-coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * get the y value when called
     * @return the  y-coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * the method allow the player to move North by increasing the y value by 1,
     * So far as the player position is not greater than 4.
     * A path block message is printed if player wants to still move beyond 4
     */

    public void moveNorth() {
        if (y < 4) { // Updated boundary for moving north
            y++;
            System.out.println("You moved north");

        } else {
            System.out.println("You cannot move north, the path is blocked");
        }
    }

    /**
     * the method allow the player to move South by decreasing the y value by 1,
     * however in other to activate the neutral ending where the player walk out from the cave
     * additional logic needed to test all x points.
     * When the y becomes -1 the player is out of the cave
     */
    public void moveSouth() {
        if ((x == 0 && y == 0) || (y > 0 && x != 1 && x != 2 && x != 3 && x != 4)) { // Updated logic for moving south
            y--;
            System.out.println("You moved south");

        } else {
            System.out.println("You cannot move south, the path is blocked");
        }
    }

    /**
     * the method allow the player to move West,
     * if the x position is greater than 0 decrease the x point by 1
     * A path block message is printed if the condition becomes false
     */

    public void moveWest() {
        if (x > 0) {
            x--;
            System.out.println("You moved west");

        } else {
            System.out.println("You cannot move west, the path is blocked");
        }
    }

    /**
     * the method allow the player to move East,
     * if the x position is less than 4 increase the x point by 1
     * A path block message is printed if the condition becomes false
     */

    public void moveEast() {
        if (x < 4) { // Updated boundary for moving east
            x++;
            System.out.println("You moved east");

        } else {
            System.out.println("You cannot move east, the path is blocked");
        }
    }

    /**
     * printing the values of x and y
     * @return the x and y values to string
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
