package com.kalenicz.maciej.retrofi2test;

/**
 * Created by maciej on 02.03.2018.
 */

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

interface APIInterface {

//    @GET("/api/unknown")
//    Call<MultipleResource> doGetListResources();

//    @POST("/api/users")
//    Call<User> createUser(@Body User user);

    @GET("/api/users?")
    Call<UserList> doGetUserList(@Query("page") String page);
//    https://reqres.in/api/users?page=2

    @FormUrlEncoded
    @POST("/api/users?")
//    first_name : "Charles"
    Call<UserList> doCreateUserWithField(@Field("first_name") String name, @Field("last_name") String job);
}