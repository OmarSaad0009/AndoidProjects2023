package com.example.apiproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("data?drilldowns=State&measures=Population&year=latest")
    Call<CountryResponse> getCountries();
}

