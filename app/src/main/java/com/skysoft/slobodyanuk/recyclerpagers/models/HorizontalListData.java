package com.skysoft.slobodyanuk.recyclerpagers.models;

/**
 * Created by serhii_slobodyanuk on 01.03.17.
 */

public class HorizontalListData {

    private String title;
    private String subtitle;
    private String url;


    public HorizontalListData(String title, String subtitle, String url) {
        this.title = title;
        this.subtitle = subtitle;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getUrl() {
        return url;
    }
}
