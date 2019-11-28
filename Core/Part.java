import java.util.*;
import java.io.*;


public class Part implements Comparable<Part>
{
    private String id;
    private int count;
	private float cost;
	private String manufacturer;
	private String name;
	private String type;

    public Part(String id, String name, int count, float cost, String type, String man)
    {
        this. id = id;
        this.count = count;
		this.manufacturer = man;
		this.cost = cost;
		this.type = type;
		this.name = name;
    }

    public Part(String id)
    {
        this.id = id;
        this.count = 1;
    }

    public String getID()
    {
        return this.id;
    }

    public int getCount()
    {
        return this.count;
    }

    public void addCount(int added)
    {
        this.count += added;
    }

    public void removeCount(int removed)
    {
        this.count -= removed;
    }

    public int compareTo(Part p)
    {
        return p.getID().compareTo(this.getID());
    }
	
	public void setName(String newName)
	{
		this.name = newName;
	}
	
	public void setType(String newType)
	{
		this.type = newType;
	}
	
	public void setCost(float newCost)
	{
		this.cost = newCost;
	}
	
	public void setMan(String newMan)
	{
		this.manufacturer = newMan;
	}
	
	public void setID(String newID)
	{
		this.ID = newID;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getMan()
	{
		return this.manufacturer;
	}
	
	public int getCount()
	{
		return this.count;
	}
	
	public float getCost()
	{
		return this.cost;
	}
	
	public String fileString()
	{
		String s = this.toString;
		String s1[] = s.split("\n");
		String result  = "";
		for(String info : s1)
		{
			result += " " + info;
		}
		return result;
	}

    public String toString()
    {
        String s = "ID: " + this.getID();
		s += "\nName: " + this.getName();
		s += "\nCount: " + this.getCount();
		s += "\nCost: " + this.getCost();
		s += "\nType: " + this.getType();
		s += "\nManufacturer: " + this.getMan();
    }
}