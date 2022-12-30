package ru.fotostrana.socketapp.retrofit;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface APIInterface {
    @GET()
    Call<Pro_IPModel> getUserDetails(@Url String url);

    @GET("?format=json")
    Call<Pro_IPModel> getIp();


    @POST("api/setting")
    Call<Example> setting_api(@Body Map<String, String> body);


    @GET("?fields=61439")
    Call<Pro_IPModel> getipdata();

    @DELETE()
    Call<TraficLimitResponse> Call_Delete_Trafic(@Url String url);

    @POST()
    Call<TraficLimitResponse> Call_Add_Trafic(@Url String url);

}