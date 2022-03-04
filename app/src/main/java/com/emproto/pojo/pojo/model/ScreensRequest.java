package com.emproto.pojo.pojo.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ScreensRequest {

    @SerializedName("ids")
    private List<String> ids;

    @SerializedName("components")
    private String components;

    @SerializedName("screenShot")
    private String screenShot;

    public ScreensRequest(List<String> ids, String components, String screenShot) {
        this.ids = ids;
        this.components = components;
        this.screenShot = screenShot;
    }

    public List<String> getIds() {
        return ids;
    }
}