package com.example.rindus.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Todo {

    private int userId;
    private int id;
    private String title;
    private Boolean completed;

    public Todo() {
    }

    public int getUserId() {
        return userId;
    }


    public int getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }


    public Boolean getCompleted() {
        return completed;
    }


    @Override
    public String toString() {
        return "Todo{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completed='" + completed + '\'' +
                '}';
    }
}