public class Mechanic {
    private String name;
    private String id;

    public Mechanic(String alias, String ident) {
        name = alias;
        id = ident;
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
