package ru.fotostrana.socketapp.retrofit;

import com.google.gson.annotations.SerializedName;

public class TraficLimitResponse {

    @SerializedName("result")
    public String result;

    @SerializedName("access_token")
    public String access_token;

}
