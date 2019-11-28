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
	
	public int getStat()
	{
		return this.status.getStat();
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

    public String toString(){
      return "ID Number: " + getVin() + "\nManufacturer: " + getManufacturer() + "\nModel: " + getModel() + "\nYear: " + getYear() + "\nStatus: " + getStat();
    }
	
	public String fileString()
	{
		String s = this.toString();
		String[] s1 = s.split("\n");
		String result = "";
		for(String info : s1)
		{
			result += info + " ";
		}
		return result;
	}