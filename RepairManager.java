package Utilitee;

import Core.*;
import Core.RepairJob;
import Core.Vehicle;

import java.util.ArrayList;

public class RepairManager {
    private static int count;
    private ArrayList<RepairJob> repairList;

    public RepairManager() {
        repairList = new ArrayList<RepairJob>();
        count = 1;
    }

    public void addRepair(RepairJob newR) {
        newR.setId(Integer.toString(count));
        this.repairList.add(newR);
    }

    public void removeRepair(int s) {
        int found = 0;
        for (int i=0; i < this.repairList.size();i++) {
            if ( Integer.parseInt(this.repairList.get(i).getId()) == s) {
                this.repairList.remove(s);
                found = 1;
                break;
            }
        }
        if (found == 0) {
            System.out.println("Not found.");
        }

    }

    public void updateRepair(int st, int index) {
        this.repairList.get(index).changeStatus(st);
    }

    public RepairJob retrieveRepair(int s) {
        int found = 0;
        for (int i=0; i<this.repairList.size();i++) {
            if ( Integer.parseInt(this.repairList.get(i).getId()) == s) {
                found = i;
                break;
            }
        }
        if (found == 0) {
            return new RepairJob("-1",new Vehicle("-1","-1","-1",000,0),0,"nll");
        }
        return this.repairList.get(found);
    }

    public String toString(int i) {
        return this.repairList.get(i).getId() + this.repairList.get(i).getAutomobile().toString() + this.repairList.get(i).getStatus() + this.repairList.get(i).getDescription();
    }
}