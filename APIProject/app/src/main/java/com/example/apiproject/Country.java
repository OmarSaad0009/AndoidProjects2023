package com.example.apiproject;

import com.google.gson.annotations.SerializedName;
// University
public class Country {
    @SerializedName("State")
    private String State;

    @SerializedName("Population")
    private String Population;
/*
    @SerializedName("min_size")
    private String minSize;*/

    public String getState() {
        return State;
    }

    public String getPopulation() {
        return Population;
    }
/*
    public String getMinSize() {
        return minSize;
    }*/

    @Override
    public String toString() {
        return "   State" +

                ", name=" + State + '\'' +
                Population;
    }
}
