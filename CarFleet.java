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
		{
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