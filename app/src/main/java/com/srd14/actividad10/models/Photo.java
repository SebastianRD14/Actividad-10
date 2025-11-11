package com.srd14.actividad10.models;

public class Photo {
    // Variables
    private int imageId;

    private String title;

    private String description;

    private String date;

    // Constructor de la clase
    public Photo(int imageId, String title, String description, String date) {
        this.imageId = imageId;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    // Getters
    public int getImageId() {
        return imageId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getImagePath() {
        return "android.resource://com.srd14.actividad10/" + imageId;
    }
}
