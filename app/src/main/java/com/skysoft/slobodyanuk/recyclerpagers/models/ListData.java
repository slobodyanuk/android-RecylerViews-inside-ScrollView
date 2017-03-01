package com.skysoft.slobodyanuk.recyclerpagers.models;

/**
 * Created by serhii_slobodyanuk on 01.03.17.
 */
public class ListData {
    private final String title;
    private final String subtitle;

    public ListData(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }
}
