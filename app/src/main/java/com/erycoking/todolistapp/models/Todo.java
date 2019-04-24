package com.erycoking.todolistapp.models;


import java.io.Serializable;

public class Todo implements Serializable {

    private int user_id;
    private int id;
    private String title;
    private boolean Completed;

    public Todo() {
    }

    public Todo(int user_id, int id, String title, boolean completed) {
        this.user_id = user_id;
        this.id = id;
        this.title = title;
        Completed = completed;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return Completed;
    }

    public void setCompleted(boolean completed) {
        Completed = completed;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "user_id=" + user_id +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", Completed=" + Completed +
                '}';
    }
}
