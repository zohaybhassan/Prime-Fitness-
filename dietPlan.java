package application;

public class dietPlan {
    private String trainerid;
    private String Customerid;
    private String plan;
    
    public dietPlan(String trainerid, String customerid, String plan) {
        this.trainerid = trainerid;
        this.Customerid = customerid;
        this.plan = plan;
    }
    public String getTrainerid() {
        return trainerid;
    }
    public void setTrainerid(String trainerid) {
        this.trainerid = trainerid;
    }
    public String getCustomerid() {
        return Customerid;
    }
    public void setCustomerid(String customerid) {
        this.Customerid = customerid;
    }
    public String getPlan() {
        return plan;
    }
    public void setPlan(String plan) {
        this.plan = plan;
    }
}