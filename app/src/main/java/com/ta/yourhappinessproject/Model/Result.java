package com.ta.yourhappinessproject.Model;

import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("id")
    private String id;
    @SerializedName("role")
    private String role;

    public Result(String id, String role) {
        this.id = id;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
