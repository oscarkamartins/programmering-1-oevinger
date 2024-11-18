package eventManager;

public class Event {
    private int id;
    private String name;
    private String location;
    private String host;
    private String type;
    private long dateTime;

    public Event(int id, String name, String location, String host, String type, long dateTime) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.host = host;
        this.type = type;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getHost() {
        return host;
    }

    public String getType() {
        return type;
    }

    public long getDateTime() {
        return dateTime;
    }

    public int getDate() {
        return Integer.parseInt(Long.toString(getDateTime()).substring(0, 8));
    }

    public int getTime() {
        return Integer.parseInt(Long.toString(getDateTime()).substring(8));
    }

    public String toString() {
        String string = "Id: " + getId()
            + "\nName: " + getName()
            + "\nLocation: " + getLocation()
            + "\nHost: " + getHost()
            + "\nType: " + getType()
            + "\nDate and Time: " + getDateTime() + "\n";
        return string;
    }
}