package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {
    @Test
    public void testTaskConstructor() {
        // Valid input
        Assertions.assertDoesNotThrow(() -> {
            new Task("123", "Task 1", "Description 1");
        });

        // Task ID exceeding 10 characters
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "Task 2", "Description 2");
        });

        // Null task ID
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Task 3", "Description 3");
        });

        // Name exceeding 20 characters
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("456", "Task Name Exceeding 20 Characters", "Description 4");
        });

        // Null name
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("789", null, "Description 5");
        });

        // Description exceeding 50 characters
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("101", "Task 6", "Description Exceeding 50 Characters Description Exceeding 50 Characters");
        });

        // Null description
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("112", "Task 7", null);
        });
    }
}
