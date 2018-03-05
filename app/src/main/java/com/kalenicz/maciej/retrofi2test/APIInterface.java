package com.kalenicz.maciej.retrofi2test;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

interface APIInterface {

    @GET("/.json")
    Call<UserList> doGetUserList();

    @PATCH("/data/{number}/.json")
    Call<User> updateUserInfo(
            @Path("number") String number,
            @Body User user);
}