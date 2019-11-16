public class RepairJob {
    private String id;
    private Vehicle automobile;
    private Stage status;
    private String description;

    public RepairJob(String ident, Vehicle car, int progress, String synopsis) {
        id = ident;
        automobile = car;
        status = new Stage(progress);
        description = synopsis;
    }

    public String getId() {
        return id;
    }

    public Vehicle getAutomobile() {
        return automobile;
    }

    public Stage getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public void changeStatus(int state) {
        this.status = new Stage(state);
    }
}
