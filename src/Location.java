
/*
the Location class defines the coordinates where a player can move to and an
NPC and item be placed.
the idea of 4 X 4 matrix was employed to define the locations and the game map.
the x and y shows the coordinates in horizontal and vertical directions
 */

public class Location {
    //instance variables
    private int x;
    private int y;

    //Constructor to instantiate the Location
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //return the x coordinate
    public int getX() {
        return x;
    }

    //return the y coordinate
    public int getY() {
        return y;
    }

    /*
    the method allow the player to move north
    starting at the (0,0) position from the bottom
    since it's a 4x4 you cannot go above 3.
    north - y-axis
     */
    public void moveNorth() {
        if (y < 3) {
            y++;
            System.out.println("you moved north");

        } else {
            System.out.println("you cannot move north, the path is blocked");
        }
    }

    /*
   the method allow the player to move south
   starting at the (0,3) position from the top
   since it's a 4x4 you cannot go beyond 0.
   south - y-axis
    */
    public void moveSouth() {
        if (y > 0) {
            y--;
            System.out.println("you moved south");

        } else {
            System.out.println("you cannot move south, the path is blocked ");
        }
    }

    /*
 the method allow the player to move west
 assuming the player is at the left. It allow
 the player to move right on the x-axis.
 west - x-axis
  */
    public void moveWest() {
        if (x > 0) {

            x--;
            System.out.println("you moved west");

        } else {
            System.out.println("you cannot move west, the path is blocked ");
        }
    }
    /*
  the method allow the player to move east
  assuming the player is at the right. It allow
  the player to move left on the x-axis.
  east - x-axis
   */
    public void moveEast() {
        if (x < 3) {
            x++;
            System.out.println("you moved east");

        } else {
            System.out.println("you cannot move east, the path is blocked ");
        }
    }

    //returning the x and y toString by overriding the toString method in the object class
    @Override
    public String toString() {
        return "(" + x + "." + y + ")";
    }


}
