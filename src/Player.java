public class Player {
    private Location location;

    public Player() {
        this.location = new Location();
    }

    public Location getLocation() {
        return location;
    }

    public void move(String direction) {
        switch (direction.toLowerCase()) {
            case "north":
                location.moveNorth();
                break;
            case "south":
                location.moveSouth();
                break;
            case "west":
                location.moveWest();
                break;
            case "east":
                location.moveEast();
                break;
            default:
                System.out.println("Please enter north, south, west, or east.");
        }
    }
}