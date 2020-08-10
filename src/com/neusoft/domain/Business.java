package com.neusoft.domain;

public class Business {
    private int businessId;
    private String pawword;
    private String businessName;
    private String businessAddress;
    private String businessExplain;
    private double starPrice;
    private double deliveryPrice;

    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    public String getPawword() {
        return pawword;
    }

    public void setPawword(String pawword) {
        this.pawword = pawword;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessAddress(String string) {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getBusinessExplain(String string) {
        return businessExplain;
    }

    public void setBusinessExplain(String businessExplain) {
        this.businessExplain = businessExplain;
    }

    public double getStarPrice(double aDouble) {
        return starPrice;
    }

    public void setStarPrice(double starPrice) {
        this.starPrice = starPrice;
    }

    public double getDeliveryPrice(double aDouble) {
        return deliveryPrice;
    }

    public void setDeliveryPrice(double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    @Override
    public String toString() {
        return  "\n"+businessId +
                 pawword + " " +
                 businessName + " " +
                 businessAddress + " " +
                 businessExplain + " " +
                 starPrice +" "+
                 deliveryPrice ;
    }
}
