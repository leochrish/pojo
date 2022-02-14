package com.emproto.pojo.pojo.model;

public class ScreenModel {
    private String title;
    private String content;
    private String titleColor;
    private String titleTextColor;
    private String contentColor;
    private String contentTextColor;
    private int x, y;
    private String id;
    private int variant;

    public ScreenModel(String id, int variant, int x, int y, String title, String content, String titleColor, String titleTextColor, String contentColor, String contentTextColor) {
        this.id = id;
        this.variant = variant;
        this.x = x;
        this.y = y;
        this.title = title;
        this.content = content;
        this.titleColor = titleColor;
        this.titleTextColor = titleTextColor;
        this.contentColor = contentColor;
        this.contentTextColor = contentTextColor;
    }

    public ScreenModel(String id, int x, int y, String title, String content) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(String titleColor) {
        this.titleColor = titleColor;
    }

    public String getTitleTextColor() {
        return titleTextColor;
    }

    public void setTitleTextColor(String titleTextColor) {
        this.titleTextColor = titleTextColor;
    }

    public String getContentColor() {
        return contentColor;
    }

    public void setContentColor(String contentColor) {
        this.contentColor = contentColor;
    }

    public String getContentTextColor() {
        return contentTextColor;
    }

    public void setContentTextColor(String contentTextColor) {
        this.contentTextColor = contentTextColor;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getVariant() {
        return variant;
    }

    public void setVariant(int variant) {
        this.variant = variant;
    }
}
