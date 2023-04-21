package model;

public class Address {
   private String numberHome;
   private String district;
   private String province;

    public Address(String numberHome, String district, String province) {
        this.numberHome = numberHome;
        this.district = district;
        this.province = province;
    }

    public String getNumberHome() {
        return numberHome;
    }

    public void setNumberHome(String numberHome) {
        this.numberHome = numberHome;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
