package tasks;
public class Task {
    private final String taskId;
    private final String name;
    private final String description;

    public Task(String taskId, String name, String description) {
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Task ID must not be null and cannot exceed 10 characters");
        }
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name must not be null and cannot exceed 20 characters");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must not be null and cannot exceed 50 characters");
        }

        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
