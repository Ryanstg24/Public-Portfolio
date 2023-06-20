package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {
    private TaskService taskService;

    @BeforeEach
    public void setUp() {
        taskService = new TaskService();
    }

    @Test
    public void testAddTask() {
        Task task1 = new Task("123", "Task 1", "Description 1");
        Task task2 = new Task("456", "Task 2", "Description 2");

        // Add task1
        Assertions.assertDoesNotThrow(() -> {
            taskService.addTask(task1);
        });

        // Add duplicate task1
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            taskService.addTask(task1);
        });

        // Add task2
        Assertions.assertDoesNotThrow(() -> {
            taskService.addTask(task2);
        });
    }

    @Test
    public void testDeleteTask() {
        Task task1 = new Task("123", "Task 1", "Description 1");

        // Add task1
        taskService.addTask(task1);

        // Delete task1
        Assertions.assertDoesNotThrow(() -> {
            taskService.deleteTask("123");
        });

        // Delete non-existing task
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            taskService.deleteTask("456");
        });
    }

    @Test
    public void testUpdateTaskName() {
        Task task1 = new Task("123", "Task 1", "Description 1");

        // Add task1
        taskService.addTask(task1);

        // Update task1 name
        Assertions.assertDoesNotThrow(() -> {
            taskService.updateTaskName("123", "Updated Task Name");
        });

        // Verify updated task name
        Task updatedTask = taskService.getTask("123");
        Assertions.assertEquals("Updated Task Name", updatedTask.getName());

        // Update non-existing task name
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskName("456", "Updated Task Name");
        });
    }

    @Test
    public void testUpdateTaskDescription() {
        Task task1 = new Task("123", "Task 1", "Description 1");

        // Add task1
        taskService.addTask(task1);

        // Update task1 description
        Assertions.assertDoesNotThrow(() -> {
            taskService.updateTaskDescription("123", "Updated Description");
        });

        // Verify updated task description
        Task updatedTask = taskService.getTask("123");
        Assertions.assertEquals("Updated Description", updatedTask.getDescription());

        // Update non-existing task description
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskDescription("456", "Updated Description");
        });
    }
}
