import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

class Task {
    private String name;
    private Date creationDate;

    public Task(String name) {
        this.name = name;
        this.creationDate = new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}

class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(String name) {
        tasks.add(new Task(name));
    }

    public boolean removeTask(String name) {
        return tasks.removeIf(task -> task.getName().equals(name));
    }

    public List<Task> viewTasks() {
        List<Task> sortedTasks = new ArrayList<>(tasks);
        sortedTasks.sort(Comparator.comparing(Task::getCreationDate));
        return sortedTasks;
    }
}

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        manager.addTask("Сделать домашнюю работу");
        manager.addTask("Купить продукты");
        manager.addTask("Позвонить другу");

        System.out.println("Все задачи:");
        for (Task task : manager.viewTasks()) {
            System.out.println(task.getName() + " (Дата: " + task.getCreationDate() + ")");
        }

        manager.removeTask("Купить продукты");

        System.out.println("\nПосле удаления:");
        for (Task task : manager.viewTasks()) {
            System.out.println(task.getName() + " (Дата: " + task.getCreationDate() + ")");
        }
    }
}
