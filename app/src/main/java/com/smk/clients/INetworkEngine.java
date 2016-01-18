package com.smk.clients;

import com.smk.model.AccessToken;
import com.smk.model.Payment;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

public interface INetworkEngine {

	@FormUrlEncoded
	@POST("/oauth/access_token")
	void getAccessToken(
			@Field("grant_type") String grant_type,
			@Field("client_id") String client_id,
			@Field("client_secret") String client_secret,
			@Field("scope") String scope,
			@Field("username") String username,
			@Field("password") String password,
			Callback<AccessToken> callback);

	@FormUrlEncoded
	@POST("/api-v1/payment/confirm")
	void getPaymentConfirm(
			@Field("access_token") String token,
			@Field("code") String code,
			@Field("client_id") Integer user_id,
			Callback<Payment> callback);

	@FormUrlEncoded
	@POST("/api-v1/userlogin")
	void postUser(
			@Field("email") String email,
			@Field("password") String password,
			Callback<AccessToken> callback);
	

}
