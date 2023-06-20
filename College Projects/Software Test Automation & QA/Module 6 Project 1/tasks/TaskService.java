package tasks;
import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private Map<String, Task> tasks;

    public TaskService() {
        tasks = new HashMap<>();
    }

    public void addTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task must not be null");
        }

        String taskId = task.getTaskId();
        if (tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task with ID " + taskId + " already exists");
        }

        tasks.put(taskId, task);
    }

    public void deleteTask(String taskId) {
        if (taskId == null) {
            throw new IllegalArgumentException("Task ID must not be null");
        }

        tasks.remove(taskId);
    }

    public void updateTaskName(String taskId, String newName) {
        if (taskId == null) {
            throw new IllegalArgumentException("Task ID must not be null");
        }

        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task with ID " + taskId + " does not exist");
        }

        task = new Task(taskId, newName, task.getDescription());
        tasks.put(taskId, task);
    }

    public void updateTaskDescription(String taskId, String newDescription) {
        if (taskId == null) {
            throw new IllegalArgumentException("Task ID must not be null");
        }

        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task with ID " + taskId + " does not exist");
        }

        task = new Task(taskId, task.getName(), newDescription);
        tasks.put(taskId, task);
    }

    //Recently added due to failed test
    public Task getTask(String taskId) {
        if (taskId == null) {
            throw new IllegalArgumentException("Task ID must not be null");
        }

        return tasks.get(taskId);
    }
}
