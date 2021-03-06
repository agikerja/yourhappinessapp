package com.ta.yourhappinessproject.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoginModel {
    @SerializedName("result")
    private List<Result> result;
    @SerializedName("status")
    private String status;

    public LoginModel(List<Result> result, String status) {
        this.result = result;
        this.status = status;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
