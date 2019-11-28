public class Status {
    private String condition;
	private int stat;

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
		this.stat = stat;
    }

    public String getCondition(){
      return this.condition;
    }
	
	public int getStat()
	{
		return this.stat;
	}
}