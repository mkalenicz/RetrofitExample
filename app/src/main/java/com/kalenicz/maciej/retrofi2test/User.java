package com.kalenicz.maciej.retrofi2test;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("first_name")
    private String first_name;
    @SerializedName("last_name")
    private String last_name;

    public User(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }
}
