package com.thetestingacademy.ex_220924.gson_POJO.Serialization;

public class booking {

    private String firstname;
    private String lastname;
    private Integer totalprice;
    private boolean depositpaid;
    private bookingdates bkdt;

    private String additionalneeds;

    public bookingdates getBkdt() {
        return bkdt;
    }

    public void setBkdt(bookingdates bkdt) {
        this.bkdt = bkdt;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }
}
