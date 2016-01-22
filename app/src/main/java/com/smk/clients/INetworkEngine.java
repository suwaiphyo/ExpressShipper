package com.smk.clients;

import com.smk.model.City;
import com.smk.model.Shipping;
import com.smk.model.User;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
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

    @FormUrlEncoded
    @POST("/api/shipping")
    void postShipping(
            @Field("shipper_id") Integer shipper_id,

            @Field("cargo_address") String cargo_address,
            @Field("cargo_city_id") Integer cargo_city_id,
            @Field("cargo_township_id") Integer cargo_township_id,

            @Field("shipping_name") String shipping_name,
            @Field("shipping_email") String shipping_email,
            @Field("shipping_phone") String shipping_phone,
            @Field("shipping_address") String shipping_address,
            @Field("shipping_city_id") Integer shipping_city_id,
            @Field("shipping_township_id") Integer shipping_township_id,

            @Field("cargo") String cargo,

            @Field("delivery_company_id") Integer delivery_company_id,
            Callback<Shipping> callback);

    @GET("/api/city")
    void getCity(
            Callback<List<City>> callback);


}
