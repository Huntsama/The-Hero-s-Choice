public class Location {
    private int x;
    private int y;

    public Location() {
        this.x = 0;
        this.y = 0;
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
        } else {
            System.out.println("you cannot move north, the path is blocked");
        }
    }

    public void moveSouth() {
        if (y > 0) {
            y--;
        } else {
            System.out.println("you cannot move south, the path is blocked ");
        }
    }

    public void moveWest() {
        if (x > 0) {
            x--;
        } else {
            System.out.println("you cannot move west, the path is blocked ");
        }
    }

    public void moveEast() {
        if (x < 3) {
            x++;
        } else {
            System.out.println("you cannot move east, the path is blocked ");
        }
    }

    @Override
    public String toString() {
        return "(" + x + "." + y + ")";
    }
}
