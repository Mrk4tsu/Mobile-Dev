package com.ndthang.listtodo.models;

import java.util.HashMap;

public class Tasks {
    String name;
    String date;
    String message;
    String priority;
    public HashMap<String, String> toFireBaseOB() {
        HashMap<String, String> taskObject = new HashMap<>();
        taskObject.put("name", name);
        taskObject.put("date", date);
        taskObject.put("message", message);
        taskObject.put("priority", priority);
        return taskObject;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Tasks(){

    }
    public Tasks(String name, String date, String message, String priority) {
        this.name = name;
        this.date = date;
        this.message = message;
        this.priority = priority;
    }
}
