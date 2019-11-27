import java.util.*;
import java.io.*;


public class Part implements Comparable<Part>, Serializable
{
    private String id;
    private int count;

    public Part(String id, int count)
    {
        this. id = id;
        this.count = count;
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

    public String toString()
    {
        return ("ID: " + this.getID() + " Count: " + this.getCount());
    }
}