import java.util.*;
import java.io.*;

public class StockLibrary
{
    private ArrayList<Part> partsList;
    private String name;

    public void printStock()
    {
        for (Part p : partsList)
        {
            System.out.println(p);
        }
    }
	
	public float readFloat(Scanner in)
	{
		float temp;
		try{
			temp = Float.parseFloat(in.next())
			return temp;
		}
		catch(NumberFormatException e)
		{
			System.out.println("Invalid data entered. Please enter a floating point number.")
			readFloat(in);
		}
	}
	
	public int readInt(Scanner in)
	{
		int temp;
		try{
			temp = Integer.parseInt(in.next())
			return temp;
		}
		catch(NumberFormatException e)
		{
			System.out.println("Invalid data entered. Please enter an integer number.")
			readFloat(in);
		}
	}
	
	public void updatePart()
	{
		this.printStock();
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the ID of the part you would like to change: ");
		String ID = in.next();
		int opt;
		Part p = searchPart(new  Part(ID));
		this.partsList.remove(p);
		System.out.println("1. ID");
		System.out.println("2. Count");
		System.out.println("3. Cost");
		System.out.println("4. Name");
		System.out.println("5. Type");
		System.out.println("6. Manufcturer");
		
		System.out.print("Enter option: ");
		opt = readInt(in);
		while((opt<1) || (opt > 6))
		{
			System.out.println("Invalid entry for option. Please enter a number from 1 to 10");
			this.updatePart();
		}
		switch(opt)
		{
			case 1:
				System.out.print("Enter the new ID of the part: ");
				String newID = in.next()
				p.setID(newID);
				break;
			case 2:
				System.out.print("Enter the new amount of the part: ");
				int newCount = readInt(in);
				p.setCount(newCount);
				break;
			case 3:
				System.out.print("Enter the new cost of the part: ");
				float newCost = readFloat(in);
				p.setCost(newCost);
				break;
			case 4:
				System.out.print("Enter the new cost of the part: ");
				String newName = in.next();
				p.setName(newName);
				break;
			case 5:
				System.out.print("Enter the new type of the part: ");
				String newType = in.next();
				p.setName(newType);
				break;
			case 6:
				System.out.print("Enter the new manufacturer of the part: ")
				String newMan = in.next();
				p.setMan(newMan);
				break;
			default:
				break;
		}
	}		
		
    public StockLibrary(String name)
    {
        this.name = name;
        this.partsList = new ArrayList<Part>();
    }

    public void addPart(Part p)
    {
        Part temp = new Part("NULL");
        boolean exists = false;
        for (Part part : this.partsList)
        {
            if(part.compareTo(p) == 0)
            {
                //System.out.println("Existing entry found!");
                exists = true;
                temp = part;
            }
        }
        if(!exists)
        {
            this.partsList.add(p);
        }
        else
        {
            this.partsList.remove(temp);
            temp.addCount(p.getCount());
            this.partsList.add(temp);
        }
    }

    public void withdrawPart(Part p, int count)
    {
        Part temp = new Part("NULL");
        boolean exists = false;
        for (Part part : this.partsList)
        {
            if(part.compareTo(p) == 0)
            {
                exists = true;
                temp = part;
            }
        }
        if(!exists)
        {
            System.out.println("Part not found.");
        }
        else
        {
            this.partsList.remove(temp);
            if(temp.getCount() > count)
            {
                temp.removeCount(count);
                this.partsList.add(temp);
            }
            else
            {
                Scanner in = new Scanner(System.in);
                String opt;
                System.out.println("Not enough stock to remove desired amount. Only " + temp.getCount() + " units exist");
                System.out.println("Withdraw total stock? (" + temp.getCount() + " items) (Y)es or (N)o?");
                System.out.print("Option: ");
                opt = in.next();
                while(((opt.compareTo("y")==0) || (opt.compareTo("Y") == 0)) && ((opt.compareTo("n")==0) || (opt.compareTo("N") == 0)))
                {
                    System.out.println("Invalid option entered. Please enter Y for yes and N for no.");
                    System.out.println("Option: ");
                    opt = in.next();
                }
                if((opt.compareTo("y")==0) || (opt.compareTo("Y") == 0))
                {
                    temp.removeCount(temp.getCount());
                    this.partsList.add(temp);
                }
                else
                {
                    this.partsList.add(temp);
                }
            }
        }
    }

    public ArrayList<Part> getStockList()
    {
        return this.partsList;
    }

    public Part searchPart(Part p)
    {
        Part temp = new Part("");
        Collections.sort(this.partsList);
        int result = Collections.binarySearch(this.partsList, p);
        if(result>=0)
        {
            return this.partsList.get(result);
        }
        else
        {
            System.out.println("Part not found.");
            return temp;
        }
    }

    public void deletePart(Part p)
    {
        Collections.sort(this.partsList);
        int result = Collections.binarySearch(this.partsList, p);
        if(result>0)
        {
            this.partsList.remove(this.partsList.get(result));
        }
        else
        {
            System.out.println("Part not found.");
        }
    }
}