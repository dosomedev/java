package com.dosomedev;

public class Task {
    private int priority;
    private String description;

    public Task(int priority, String description) {
        this.priority = priority;
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }
   
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "priority=" + priority +
                ", description='" + description +
                "'}";
    }
}
