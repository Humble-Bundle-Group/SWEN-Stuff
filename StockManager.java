import java.util.*;
import java.io.*;
import java.net.*;
import java.time.LocalDate;

public class StockManager
{
    private static int clearance = 2;
    private String userName;
    private String password;


    public void addPart(String id, int quantAdd, StockLibrary s)
    {
        s.addPart(new Part(id, quantAdd));
    }

    public void removePart(String id, int quant, StockLibrary s)
    {
        s.withdrawPart(new Part(id), quant);
    }

    public String searchPart(String id, StockLibrary sl)
    {
        Part p = new Part(id);
        String res = sl.searchPart(p).toString();
        System.out.println(res);
        return res;
    }

    public void saveLibrary(StockLibrary sl)
    {
        String filePath = "\\data\\stock\\";
        LocalDate now = LocalDate.now();
        filePath += now + ".txt";
        String file1 = "\\data\\stock\\most-recent.txt";
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
            for(Part p : sl.getStockList())
            {
                bw.write(p.toString() );
                bw.newLine();
                bw1.write(p.toString());
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
            System.out.println("Unable to save stock file");


            try{
                success = (new File("\\data")).mkdirs();
                if(success)
                {
                    success1 = (new File("\\data\\stock")).mkdirs();
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


    public void loadLibrary(StockLibrary sl)
    {
        String file1 = "\\data\\stock\\most-recent.txt";
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
                        Part p = new Part(partData[1], Integer.parseInt(partData[3]));
                        sl.addPart(p);
                    }
                }
                sl.printStock();
            }
            catch (IOException ex)
            {
                System.out.println("Unable to load previous stock data.");
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("No previous stock data found.");
        }
    }

    public static void main(String args[])
    {
        StockManager sm = new StockManager();
        StockLibrary sl = new StockLibrary("IslandCarRental");
        Scanner in = new Scanner(System.in);
        String partID = "";
        int quantity;
        while (partID.compareTo("enddata") != 0)
        {
            System.out.print("Enter part ID: ");
            partID = in.next();
            if(partID.compareTo("enddata") == 0)
            {
                break;
            }
            System.out.print("Enter quantity of part to be stored: ");
            quantity = Integer.parseInt(in.next());
            sm.addPart(partID, quantity, sl);
        }
        sl.printStock();/*
        partID = "";
        while (partID.compareTo("enddata") != 0)
        {
            System.out.print("Enter part ID: ");
            partID = in.next();
            if(partID.compareTo("enddata") == 0)
            {
                break;
            }
            System.out.print("Enter quantity of part to be removed: ");
            quantity = Integer.parseInt(in.next());
            sm.removePart(partID, quantity, sl);
        }
        sl.printStock();
        System.out.print("Enter the ID of the part you want to search for: ");
        partID = in.next();
        sm.searchPart(partID, sl);*/
        sm.saveLibrary(sl);
        sl = new StockLibrary("IslandCarRental");
        sm.loadLibrary(sl);

    }
}