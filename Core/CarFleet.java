import java.util.ArrayList;
import java.util.Scanner;

public class CarFleet{
  private ArrayList<Vehicle> list;

  public CarFleet(){
    this.list = new ArrayList<Vehicle>();
  }

  public int checkList(String id){
    int i;

    for(i=0; i< list.size(); i++){
      if(list.get(i).getVin().compareTo(id) == 0) {
        return i;
      }
    }

    return -1;
  }

  public void addVehicle(Vehicle vehicle){
    int i = checkList(vehicle.getVin());

    if(i < 0){
      list.add(vehicle);
    }
    else{
      System.out.println("ID Number already exists.");
    }
  }

  public void removeVehicle(String id){
    int i = checkList(id);
    if(i >= 0){
      list.remove(i);
    }
    else{
      System.out.println("ID could not be found.");
    }
  }

  public Vehicle searchVehicle(String id){
    int i = checkList(id);
    Vehicle empty = new Vehicle("","","",-1,-1);

    if (i >= 0){
      return list.get(i);
    }
    else{
      return empty;
    }
  }

  public void printList(){
    int i;

    for(i = 0; i < list.size(); i++){
      System.out.println(list.get(i) + "\n");
    }
  }

  public ArrayList<Vehicle> getList(){
    return this.list;
  }
  
  public void startRepair()
  {
	    Scanner in = new Scanner(System.in);
		String VIN;
		for(Vehicle veh : this.list)
		{
			if((veh.getStat() == 1) ||  (veh.getStat() == 2))
			{
				System.out.println(veh);
				System.out.println();
			}
		}
		System.out.print("Enter the ID of the vehicle you want to start repairs on: ");
		VIN = in.next();
		int i = checkList(VIN);
		if(i >= 0)
			Vehicle v = list.get(i);
			list.remove(v);
			v.changeStatus(3);
			list.add(v);
		}
		else
		{
			System.out.println("Invalid VIN entered. Please try again");
		}
  }
  
  public void endRepair()
  {
	    Scanner in = new Scanner(System.in);
		String VIN;
		for(Vehicle veh : this.list)
		{
			if(veh.getStat() == 3)
			{
				System.out.println(veh);
				System.out.println();
			}
		}
		System.out.print("Enter the ID of the vehicle you want to complete repairs on: ");
		VIN = in.next();
		int i = checkList(VIN);
		if(i >= 0)
			Vehicle v = list.get(i);
			list.remove(v);
			v.changeStatus(0);
			list.add(v);
		}
		else
		{
			System.out.println("Invalid VIN entered. Please try again");
		}
  }
  
  public void saveFleet()
    {
        String filePath = "\\data\\fleet\\";
        LocalDate now = LocalDate.now();
        filePath += now + ".txt";
        String file1 = "\\data\\fleet\\most-recent.txt";
        String basePath = new File("").getAbsolutePath();
        file1 = basePath + file1;
        basePath += filePath;
        System.out.println(file1);
        System.out.println(basePath);
        File stockFile = new File(basePath);
        File updateCache = new File(file1);
        try
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter(stockFile));
            BufferedWriter bw1 = new BufferedWriter(new FileWriter(updateCache));
            for(Vehicle v: this.list)
            {
                bw.write(v.fileString());
                bw.newLine();
                bw1.write(v.fileString());
                bw1.newLine();
            }
            bw.write("enddata\n");
            bw.close();
            bw1.write("enddata\n");
            bw1.close();
        }
        catch (IOException e)
        {
            boolean success = false;
            boolean success1 = false;
            System.out.println("Unable to save fleet file");


            try{
                success = (new File("\\data")).mkdirs();
                if(success)
                {
                    success1 = (new File("\\data\\fleet")).mkdirs();
                    if(success1) {
                        this.saveLibrary(sl);
                    }
                }
                else
                {
                    System.out.println("Critical error");
                }
            }
            catch(SecurityException se){
                System.out.println("Please allow programs to make directories in your system permissions and re-run the software.");
            }
            if(success) {
                System.out.println("File structure created");
            }
        }
    }
public void loadFleet()
    {
        String file1 = "\\data\\cars\\most-recent.txt";
        String basePath = new File("").getAbsolutePath();
        file1 = basePath + file1;
        String partData[], part;
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(file1));
            try
            {
                while ((part = br.readLine()) != null) {
                    if (part.compareTo("enddata") != 0) {
                        partData = part.split(" ");
                        //System.out.println(partData[0] +" " + partData[1] +" "+ partData[2] + " " + partData[3]);
                        Vehicle v = new Vehicle(partData[1], partData[3], (partData[5]), Integer.parseInt(partData[7]), Integer.parseInt(partData[9]));
                        this.list.add(v);
                    }
                }
            }
            catch (IOException ex)
            {
                System.out.println("Unable to load previous vehicle data.");
            }
        }
        catch (Exception e)
        {
            System.out.println("Error loading previous vehicle data found.");
        }
        
    }
  
  public static void main(String[] args){
    CarFleet fleet = new CarFleet();
    Vehicle vehicle = new Vehicle("620123660","Toyota","Corola",2020,0);
    Vehicle vehicle2 = new Vehicle("620123661","Mitsubishi","Misubishi",2020,2);
    Vehicle vehicle3 = new Vehicle("620123662","Honda","Civic",2020,3);
	Vehicle vehicle4 = new Vehicle("620123666","Honda","Civic",2020,1);

    fleet.addVehicle(vehicle);
    fleet.addVehicle(vehicle2);
    fleet.addVehicle(vehicle3);
	fleet.addVehicle(vehicle4);

    //fleet.printList();
	fleet.startRepair();
	fleet.printList();
  }
  
  
}