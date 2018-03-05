package com.kalenicz.maciej.retrofi2test;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class UserList {

    @SerializedName("data")
    private List<Datum> data = new ArrayList();

    public class Datum {

        @SerializedName("id")
        private Integer id;
        @SerializedName("first_name")
        private String first_name;
        @SerializedName("last_name")
        private String last_name;


        public Integer getId() {
            return id;
        }

        public String getFirst_name() {
            return first_name;
        }

        public String getLast_name() {
            return last_name;
        }
    }

    public List<Datum> getData() {
        return data;
    }

}