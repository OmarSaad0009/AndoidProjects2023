package com.example.apiproject;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CountryResponse {
    @SerializedName("data")
    private List<Country> Countries;

    public List<Country> getCountries() {
        return Countries;
    }


}
