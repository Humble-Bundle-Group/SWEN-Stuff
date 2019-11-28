import java.util.Scanner;

public class Driver
{
	private StockManager sm;
	private CarFleet cf;
	private StockLibrary sl;
	
	public static void menu()
	{
		this.sm = new StockManager();
		this.sl = new StockLibrary("IslandCarRental");
		try
		{
			sl = sm.loadLibrary(sl);
		}
		catch (Exception e)
		{
		}
		this.cf = new CarFleet();
		System.out.println("1. Add parts");
		System.out.println("2. Withdraw parts");
		System.out.println("3. Update part info");
		System.out.println("4. Delete parts");
		System.out.println("5. Add cars");
		System.out.println("6. Start repair");
		System.out.println("7. End repair");
		System.out.println("8. Save Stock Information");
		System.out.println("9. Save Fleet Information");
		System.out.println("10. Exit");
		
		int opt;
		Scanner in = new Scanner(System.in);
		try{
			opt = Integer.parseInt(in.next())
		}
		catch (NumberFormatException e)
		{
			System.out.println("Invalid entry for option. Please enter a number from 1 to 10");
			this.menu();
		}
		while((opt<1) || (opt > 10))
		{
			System.out.println("Invalid entry for option. Please enter a number from 1 to 10");
			this.menu();
		}
		switch(opt)
		{
			case 1:
				sm.addPart();
				break;
			case 2:
				sm.withdrawPart();
				break;
			case 3:
				sm.updatePart();
				break;
			case 4:
				sm.removePart();
				break;
			case 5:
				Vehicle v;
				String vin;
				String make;
				String model;
				int year;
				System.out.println("Enter the VIN of the new vehicle: ");
				vin = in.next();
				System.out.println("Enter the make of the vehicle: ");
				make = in.next();
				System.out.println("Enter the model of the vehicle: ");
				model = in.next();
				year = readInt(in);
				v = new Vehicle(vin, make, model, year, 0);
				cf.addVehicle(v);
				break;
			case 6:
				cf.startRepair();
				break;
			case 7:
				cf.endRepair();
				break;
			case 8:
				sm.saveLibrary();
				break;
			case 9:
				cf.saveFleet();
				break;
			case 10:
				sm.saveLibrary();
				cf.saveFleet();
				System.out.println("Thank you for using this program.");
				System.exit(0);
				break;
			default:
				break;
		}
	}
	
	public static void main(String args[])
	{
		Driver d = new Driver();
		while(true)
		{
			d.menu();
		}
		
	}
}