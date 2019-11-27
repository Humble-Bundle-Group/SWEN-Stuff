import java.util.ArrayList;

public class CarFleet{
  private ArrayList<Vehicle> list;

  public CarFleet(){
    this.list = new ArrayList<Vehicle>();
  }

  public int checkList(String id){
    int i;

    for(i=0; i< list.size(); i++){
      if(list.get(i).getVin() == id) {
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
}
