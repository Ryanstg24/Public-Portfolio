package contacts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    public void setup() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St.");

        Assertions.assertDoesNotThrow(() -> {
            contactService.addContact(contact);
        });

        // Trying to add a contact with the same ID should throw an exception
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(contact);
        });
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St.");
        contactService.addContact(contact);

        Assertions.assertDoesNotThrow(() -> {
            contactService.deleteContact("123");
        });

        // Trying to delete a non-existent contact should throw an exception
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("456");
        });
    }

    @Test
    public void testUpdateContactField() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St.");
        contactService.addContact(contact);

        // Update first name
        Assertions.assertDoesNotThrow(() -> {
            contactService.updateContactField("123", "firstName", "Jane");
        });
        Assertions.assertEquals("Jane", contactService.getContact("123").getFirstName());

        // Update last name
        Assertions.assertDoesNotThrow(() -> {
            contactService.updateContactField("123", "lastName", "Smith");
        });
        Assertions.assertEquals("Smith", contactService.getContact("123").getLastName());

        // Update phone number
        Assertions.assertDoesNotThrow(() -> {
            contactService.updateContactField("123", "phone", "9876543210");
        });
        Assertions.assertEquals("9876543210", contactService.getContact("123").getPhone());

        // Update address
        Assertions.assertDoesNotThrow(() -> {
            contactService.updateContactField("123", "address", "456 Oak St.");
        });
        Assertions.assertEquals("456 Oak St.", contactService.getContact("123").getAddress());

        // Trying to update an invalid field should throw an exception
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContactField("123", "invalidField", "value");
        });

        // Trying to update a non-existent contact should throw an exception
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContactField("456", "firstName", "Jane");
        });
    }
}
