public class NPC {
    private String name;
    private Location location;
    private boolean encountered;

    public NPC(String name, int x, int y) {
        this.name = name;
        this.location = new Location(x, y);
        this.encountered = false;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public boolean isEncountered() {
        return encountered;
    }

    public void setEncountered(boolean encountered) {
        this.encountered = encountered;
    }
}