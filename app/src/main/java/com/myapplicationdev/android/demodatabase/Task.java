package com.myapplicationdev.android.demodatabase;

public class Task {
    private int id;
    private String description;
    private String date;


    public Task(int id, String description, String date) {
        this.id = id;
        this.description = description;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }
}
