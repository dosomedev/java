package com.dosomedev;

import java.util.Comparator;

public class TaskComparator implements Comparator<Task> {
    @Override
    public int compare(Task task1, Task task2) {
        return Integer.compare(task1.getPriority(), task2.getPriority());
    }
}
