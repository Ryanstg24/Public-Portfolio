package contacts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testContactIdRequiredAndUnique() {
        // Arrange
        String contactId = "1234567890";
        String firstName = "Ryan";
        String lastName = "St George";
        String phone = "1234567890";
        String address = "494 Test Ct.";

        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, firstName, lastName, phone, address);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("", firstName, lastName, phone, address);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", firstName, lastName, phone, address);
        });

        Assertions.assertDoesNotThrow(() -> {
            new Contact(contactId, firstName, lastName, phone, address);
        });
    }

    @Test
    public void testFirstNameRequired() {
        // Arrange
        String contactId = "1234567890";
        String lastName = "St George";
        String phone = "1234567890";
        String address = "494 Test Ct.";

        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, null, lastName, phone, address);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, "", lastName, phone, address);
        });

        Assertions.assertDoesNotThrow(() -> {
            new Contact(contactId, "Ryan", lastName, phone, address);
        });
    }

    @Test
    public void testLastNameRequired() {
        // Arrange
        String contactId = "1234567890";
        String firstName = "Ryan";
        String phone = "1234567890";
        String address = "494 Test Ct.";

        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, null, phone, address);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, "", phone, address);
        });

        Assertions.assertDoesNotThrow(() -> {
            new Contact(contactId, firstName, "St George", phone, address);
        });
    }

    @Test
    public void testPhoneRequiredAndTenDigits() {
        // Arrange
        String contactId = "1234567890";
        String firstName = "Ryan";
        String lastName = "St George";
        String address = "494 Test Ct.";

        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, lastName, null, address);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, lastName, "", address);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, lastName, "123456789", address);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, lastName, "12345678901", address);
        });

        Assertions.assertDoesNotThrow(() -> {
            new Contact(contactId, firstName, lastName, "1234567890", address);
        });
    }

    @Test
    public void testAddressRequiredAndNoMoreThanThirtyCharacters() {
        // Arrange
        String contactId = "1234567890";
        String firstName = "Ryan";
        String lastName = "St George";
        String phone = "1234567890";

        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, lastName, phone, null);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, lastName, phone, "");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, lastName, phone, "1234567891234567891234567890123");
        });

        Assertions.assertDoesNotThrow(() -> {
            new Contact(contactId, firstName, lastName, phone, "494 Test Ct.");
        });
    }
}
