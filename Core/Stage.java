public class Stage {
    public  String standing;

    public Stage(int stat) {
        if (stat == 0) {
            standing = "AWAITING COMMENCEMENT";
        }
        if (stat == 1) {
            standing = "IN PROGRESS";
        }
        if (stat == 2) {
            standing = "COMPLETED";
        }
        if (stat == 3) {
            standing = "FAILED";
        }
    }

    public String getStanding(){
      return standing;
    }
}
