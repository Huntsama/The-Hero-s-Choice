package Objects;

public class Location {
    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveNorth() {
        if (y < 4) { // Updated boundary for moving north
            y++;
            System.out.println("You moved north");

        } else {
            System.out.println("You cannot move north, the path is blocked");
        }
    }

    public void moveSouth() {
        if ((x == 0 && y == 0) || (y > 0 && x != 1 && x != 2 && x != 3 && x != 4)) { // Updated logic for moving south
            y--;
            System.out.println("You moved south");

        } else {
            System.out.println("You cannot move south, the path is blocked");
        }
    }

    public void moveWest() {
        if (x > 0) {
            x--;
            System.out.println("You moved west");

        } else {
            System.out.println("You cannot move west, the path is blocked");
        }
    }

    public void moveEast() {
        if ((x < 4) && !(x == 0 && y == -1)) { // Updated boundary for moving east
            x++;
            System.out.println("You moved east");

        } else {
            System.out.println("You cannot move east, the path is blocked");
        }
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
