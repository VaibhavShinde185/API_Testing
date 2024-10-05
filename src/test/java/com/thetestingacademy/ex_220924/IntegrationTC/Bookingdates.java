package com.thetestingacademy.ex_220924.IntegrationTC;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bookingdates {

    @SerializedName("checkin")
    private String checkin;

    @SerializedName("checkout")
    private String checkout;

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

}
