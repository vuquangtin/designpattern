package com.designpatterns.gof.structural.composite.tasks;

import java.util.ArrayList;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Project extends TaskItem {
    
    String name;
    ArrayList<TaskItem> subTask = new ArrayList<>();
    
    public Project() {
    }
    
    public Project(String name, ArrayList<TaskItem> subTask) {
        this.name = name;
        this.subTask = subTask;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public ArrayList<TaskItem> getSubTask() {
        return subTask;
    }
    
    public void setSubTask(ArrayList<TaskItem> subTask) {
        this.subTask = subTask;
    }
    
    @Override
    public double getTime() {
        double time = 0;
        for (int i = 0; i < subTask.size(); i++) {
            time += subTask.get(i).getTime();
        }
        return time;
    }
    
    public void addTask(TaskItem taskItem) {
        if (subTask.contains(taskItem) == false) {
            subTask.add(taskItem);
        }
    }
    public void removeTask(TaskItem taskItem) {
        subTask.remove(taskItem);
    }
}