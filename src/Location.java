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
        if (y < 3) {
            y++;
            System.out.println("you moved north");

        } else {
            System.out.println("you cannot move north, the path is blocked");
        }
    }

    public void moveSouth() {
        if (y > 0) {
            y--;
            System.out.println("you moved south");

        } else {
            System.out.println("you cannot move south, the path is blocked ");
        }
    }

    public void moveWest() {
        if (x > 0) {

            x--;
            System.out.println("you moved west");

        } else {
            System.out.println("you cannot move west, the path is blocked ");
        }
    }

    public void moveEast() {
        if (x < 3) {
            x++;
            System.out.println("you moved east");

        } else {
            System.out.println("you cannot move east, the path is blocked ");
        }
    }

    @Override
    public String toString() {
        return "(" + x + "." + y + ")";
    }


}
