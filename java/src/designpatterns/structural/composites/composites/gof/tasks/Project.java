package composites.gof.tasks;

import java.util.ArrayList;

/**
 * <h1>Composite</h1> Các đối tượng cấu thành các cấu trúc cây để mô tả bán toàn
 * bộ hệ thống phần cấp. Composite để cho các client tác động các đối tượng
 * riêng biệt và các thành phần của đối tượng một cách thống nhất.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
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