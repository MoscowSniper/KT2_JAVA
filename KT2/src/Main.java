class Task {
    String title;
    String description;

    Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    void displayTask() {
        System.out.println("Задача: " + title);
        System.out.println("Описание: " + description);
    }
}

class DeadlineTask extends Task {
    String deadline;

    DeadlineTask(String title, String description, String deadline) {
        super(title, description);
        this.deadline = deadline;
    }

    @Override
    void displayTask() {
        super.displayTask();
        System.out.println("Дедлайн: " + deadline);
    }
}

class RecurringTask extends Task {
    String interval;
    String startDate;

    RecurringTask(String title, String description, String interval, String startDate) {
        super(title, description);
        this.interval = interval;
        this.startDate = startDate;
    }

    @Override
    void displayTask() {
        super.displayTask();
        System.out.println("Интервал: " + interval);
        System.out.println("Дата начала: " + startDate);
    }
}

public class Main {
    public static void main(String[] args) {
        Task task = new Task("Прочитать книгу", "Прочитать 50 страниц");
        DeadlineTask deadlineTask = new DeadlineTask("Сдать проект", "Сдать до конца месяца", "2024-12-31");
        RecurringTask recurringTask = new RecurringTask("Тренировка", "Тренироваться каждый день", "Ежедневно", "2024-11-01");

        task.displayTask();
        System.out.println();

        deadlineTask.displayTask();
        System.out.println();

        recurringTask.displayTask();
    }
}
