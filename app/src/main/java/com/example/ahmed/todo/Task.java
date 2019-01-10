package com.example.ahmed.todo;

import android.widget.DatePicker;
import android.widget.TimePicker;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;


public class Task implements Serializable {

    private String taskDetails, priority, taskDate, taskTime;
    private int id;

    public Task(int id, String taskDetails, String taskDate, String taskTime, String priority) {
        this.taskDetails = taskDetails;
        this.priority = priority;
        this.taskDate = taskDate;
        this.taskTime = taskTime;
        this.id = id;
    }

    public String getTaskDetails() {
        return taskDetails;
    }

    public void setTaskDetails(String taskDetails) {
        this.taskDetails = taskDetails;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }

    public String getTaskTime() {
        return taskTime;
    }

    public void setTaskTime(String taskTime) {
        this.taskTime = taskTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}