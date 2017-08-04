package com.permoveo.matchlayoutmvvm.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by byfieldj on 8/4/17.
 */

public class Photo implements Serializable {

    @SerializedName("thumb_paths")
    public Thumbnail thumbnail;
}
