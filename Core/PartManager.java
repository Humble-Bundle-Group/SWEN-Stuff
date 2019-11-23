package Core;

public class PartManager {
    private String id;
    private String name;

    public PartManager(String pID, String pName) {
        id = pID;
        name = pName;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void changeName(String name) {
        this.name = name;
    }
}
