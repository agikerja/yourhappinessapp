package com.ta.yourhappinessproject;

import com.ta.yourhappinessproject.Model.LoginModel;
import com.ta.yourhappinessproject.Model.RegisterModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    //setelah model, kesini dulu
    //POST perlu urlencoded
    @POST("users/signin")
    @FormUrlEncoded
    Call<LoginModel> login(@Field("username") String username, @Field("password") String password);
    @POST("users/signup")
    @FormUrlEncoded
    Call<RegisterModel> register(@Field("username") String username, @Field("email")String email, @Field("password") String password);
}
