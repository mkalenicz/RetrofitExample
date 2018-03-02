package com.kalenicz.maciej.retrofi2test;

/**
 * Created by maciej on 02.03.2018.
 */

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class UserList {

//        @SerializedName("page")
//    public Integer page;
//    @SerializedName("per_page")
//    public Integer perPage;
//    @SerializedName("total")
//    public Integer total;
//    @SerializedName("total_pages")
//    public Integer totalPages;
//
    @SerializedName("data")
    private List<Datum> data = new ArrayList();

    public class Datum {

        @SerializedName("id")
        private Integer id;
        @SerializedName("first_name")
        private String first_name;
        @SerializedName("last_name")
        private String last_name;

//        @SerializedName("avatar")
//        public String avatar;

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