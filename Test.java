package Utilitee;
import Core.*;
import Core.RepairJob;
import Core.Vehicle;

import javax.swing.*;

public class Test {
    public static void main(String args[])
    {
        RepairManager test = new RepairManager();
        RepairJob r1 = new RepairJob("1",new Vehicle("22255","Toyota","Corolla",20191127,1),1,"ist fucked");
        RepairJob r2 = new RepairJob("1",new Vehicle("22255","Nissan","fucku",20191127,0),1,"ist fucked nigg");
        RepairJob r3 = new RepairJob("1",new Vehicle("22255","BTFO","Joemama",20191127,2),0,"ist imtyad");
        test.addRepair(r1);
        test.addRepair(r2);
        System.out.println(test.toString(0));
        System.out.println(test.toString(1));
        test.removeRepair(1);
        test.addRepair(r3);
        System.out.println(test.toString(0));
        System.out.println(test.toString(1));

    }
}
