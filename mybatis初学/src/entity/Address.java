package entity;

public class Address {
    private String homeaddress;
    private String schooladdress;

    public Address(String homeaddress, String schooladdress) {
        this.homeaddress = homeaddress;
        this.schooladdress = schooladdress;
    }

    public String getHomeaddress() {
        return homeaddress;
    }

    public void setHomeaddress(String homeaddress) {
        this.homeaddress = homeaddress;
    }

    public String getSchooladdress() {
        return schooladdress;
    }

    public void setSchooladdress(String schooladdress) {
        this.schooladdress = schooladdress;
    }
}
