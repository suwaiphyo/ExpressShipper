package com.smk.clients;

import com.smk.model.User;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

public interface INetworkEngine {

    @FormUrlEncoded
    @POST("/api/register")
    void postUser(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("phone") String phone,
            Callback<User> callback);

    @FormUrlEncoded
    @POST("/api/login")
    void postLogin(
            @Field("email") String email,
            @Field("password") String password,
            Callback<User> callback);
}
