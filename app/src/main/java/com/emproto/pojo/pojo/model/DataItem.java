package com.emproto.pojo.pojo.model;

import com.google.gson.annotations.SerializedName;

public class DataItem {

    @SerializedName("titleTextColor")
    private String titleTextColor;

    @SerializedName("variant")
    private int variant;

    @SerializedName("titleColor")
    private String titleColor;

    @SerializedName("viewTag")
    private String viewTag;

    @SerializedName("contentTextColor")
    private String contentTextColor;

    @SerializedName("id")
    private String id;

    @SerializedName("title")
    private String title;

    @SerializedName("contentColor")
    private String contentColor;

    @SerializedName("content")
    private String content;

    public DataItem() {
    }

    public String getTitleTextColor() {
        return titleTextColor;
    }

    public int getVariant() {
        return variant;
    }

    public String getTitleColor() {
        return titleColor;
    }

    public String getContentTextColor() {
        return contentTextColor;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContentColor() {
        return contentColor;
    }

    public String getContent() {
        return content;
    }

    public String getViewTag() {
        return viewTag;
    }
}