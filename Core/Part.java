package Core;

public class Part {
    private String partnNumber;
    private String name;
    private String type;
    private String manufacturer;
    private float cost;

    public Part(String number, String pName, String pType, String pManu, float pCost) {
        partnNumber = number;
        name = pName;
        type = pType;
        manufacturer = pManu;
        cost = pCost;
    }

    public String getPartnNumber() {
        return partnNumber;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public float getCost() {
        return cost;
    }

    public void changeCost(float newCost) {
        cost = newCost;
    }


}