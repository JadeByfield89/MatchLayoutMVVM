package com.permoveo.matchlayoutmvvm.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by byfieldj on 8/4/17.
 */

public class Location implements Serializable {

    @SerializedName("city_name")
    public String city;


    @SerializedName("state_code")
    public String state;
}
