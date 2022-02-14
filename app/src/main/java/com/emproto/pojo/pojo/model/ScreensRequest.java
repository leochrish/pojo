package com.emproto.pojo.pojo.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ScreensRequest {

    @SerializedName("ids")
    private List<String> ids;

    public ScreensRequest(List<String> ids) {
        this.ids = ids;
    }

    public List<String> getIds() {
        return ids;
    }
}