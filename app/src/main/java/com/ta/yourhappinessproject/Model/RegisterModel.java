package com.ta.yourhappinessproject.Model;

import com.google.gson.annotations.SerializedName;

public class RegisterModel {
    @SerializedName("result")
    private Boolean result;
    @SerializedName("status")
    private String status;
    //constructor
    public RegisterModel(Boolean result, String status) {
        this.result = result;
        this.status = status;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
