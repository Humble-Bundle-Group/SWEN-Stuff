import java.util.*;
import java.io.*;
import java.net.*;
import java.time.LocalDate;

public class Mechanic
{
    private String username;
    private String password;

    public void connect(String IP, int portNum)
    {
        try
        {
            Socket s = new Socket(IP, portNum);
            System.out.println("Connected successfully to: " + IP + " on port number: " + portNum);
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            out.writeUTF("100 Hello");
            String line = in.readUTF();

            System.out.println("From server: " + line);
            while(true)
            {
                this.menu(s, in, out);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getClass() + "\n" + e.getMessage());
            System.out.println("Unable to make connection, fatal error. Exiting.");
            System.exit(1);
        }

    }

    public void menu(Socket s, DataInputStream in, DataOutputStream out)
    {
        Part p;
        Scanner input = new Scanner(System.in);
        String message = "";
        String buffer = "";
        System.out.println(" ___________________________");
        System.out.println("| 1. Search Part.           |");
        System.out.println("| 2. Request Part.          |");
        System.out.println("|---------------------------|");
        System.out.print("| Option:");
        int opt = Integer.parseInt(input.next());
        while((opt > 2) || (opt < 1))
        {
            System.out.println("Invalid option entered. Please enter a listed option.");
            opt = Integer.parseInt(input.next());
        }
        switch(opt) {
            case 1:
                System.out.println("Enter the ID of the part you want to search for: ");
                String ID = input.next();
                message = "180 " + ID;
                break;
            case 2:
                System.out.println("Enter the ID of the part you want to request: ");
                ID = input.next();
                System.out.println("Enter the quantity of the part you want to request: ");
                int quant = Integer.parseInt(input.next());
                message = "190 " + ID + " " + quant;
                try{
                    out.writeUTF(message);

                }
                catch (Exception e)
                {
                    try
                    {
                        buffer = in.readUTF();
                        String[] buffMessages = buffer.split(" ");
                        if(buffMessages[0].compareTo("192") == 0)
                        {
                            System.out.println("Only " + buffMessages[1] + " units available. Withdraw max amount?\n 1 - Yes, 0 - No\nOption: ");
                             opt = Integer.parseInt(input.next());
                             while((opt != 1) || (opt != 0))
                             {
                                 System.out.println("Invalid option entered. Please enter 1 for yes and 0 for no.");
                                 System.out.print("Option: ");
                                 opt = Integer.parseInt(input.next());
                             }
                             if(opt == 1)
                             {
                                 out.writeUTF("194 " + ID + buffMessages[1]);
                                 System.out.println(in.readUTF());
                             }
                             if(opt == 0)
                             {
                                 out.writeUTF("220 Cancel");
                             }
                        }
                        if(buffMessages[0].compareTo("191") == 0)
                        {
                            System.out.println(in.readUTF());
                        }
                    }
                    catch (Exception ex)
                    {

                    }

                }
                break;
            default:
                break;
        }
        try
        {
            out.writeUTF(message);
            String result = in.readUTF();
            System.out.println(result);
        }
        catch (Exception e)
        {

        }


    }

    public static void main(String args[])
    {
        Mechanic m = new Mechanic();

        m.connect("127.0.0.1", 5000);
    }
}