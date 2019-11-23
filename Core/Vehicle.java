package Core;

public class Vehicle {
    private String vin;
    private String manufacturer;
    private String model;
    private int year;
    private Status status;

    public Vehicle(String id, String manu, String mod, int date, int cond) {
        vin = id;
        manufacturer =  manu;
        model = mod;
        year = date;
        status = new Status(cond);
    }

    public int getYear() {
        return year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public String getVin() {
        return vin;
    }

    public Status getStatus() {
        return status;
    }

    public void changeStatus(int newStatus) {
        this.status = new Status(newStatus);
    }
}
