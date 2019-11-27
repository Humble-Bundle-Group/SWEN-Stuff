public class Status {
    private String condition;

    public Status(int stat) {
        if (stat == 0) {
            condition = "OPERATIONAL";
        }
        if (stat == 1) {
            condition = "NEEDS REPAIR(OPERATIONAL)";
        }
        if (stat == 2) {
            condition = "NEEDS REPAIR(NON-OPERATIONAL)";
        }
        if (stat == 3) {
            condition = "IN REPAIR";
        }
    }

    public String getCondition(){
      return this.condition;
    }
}
