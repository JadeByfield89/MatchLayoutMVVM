package com.permoveo.matchlayoutmvvm.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by byfieldj on 8/4/17.
 */

public class Match implements Serializable {

    @SerializedName("location")
    public Location location;


    @SerializedName("photo")
    public Photo photo;


    @SerializedName("match")
    public int match;


    @SerializedName("age")
    public int age;

    @SerializedName("username")
    public String username;




}
