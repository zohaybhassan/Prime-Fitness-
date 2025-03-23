package application;

public class customer {
    
    private String id;
    private String fname;
    private String lname;
    private String dob;
    private boolean feepaid;
    private String phone;
    private String tid;
    private String lid;
    
    public customer(String id, String fname, String lname, String dob, boolean feepaid, String phone, String tid, String lid) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.feepaid = feepaid;
        this.phone = phone;
        this.tid = tid;
        this.lid = lid;
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }
    public boolean isFeepaid() {
        return feepaid;
    }
    public void setFeepaid(boolean feepaid) {
        this.feepaid = feepaid;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getTid() {
        return tid;
    }
    public void setTid(String tid) {
        this.tid = tid;
    }
    public String getLid() {
        return lid;
    }
    public void setLid(String lid) {
        this.lid = lid;
    }
}