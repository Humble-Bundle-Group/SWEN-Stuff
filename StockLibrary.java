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
            System.out.println("Part: " + p.getID() + " - Count: " + p.getCount());
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
        if(result>0)
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