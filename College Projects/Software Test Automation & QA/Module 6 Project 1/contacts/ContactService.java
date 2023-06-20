package contacts;
import java.util.HashMap;
import java.util.Map;

public class ContactService {
    //Map to store contacts
    private final Map<String, Contact> contacts;

    public ContactService() {
        this.contacts = new HashMap<>();
    }

    //Add a contact to the map
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null.");
        }

        String contactId = contact.getContactId();
        if (contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact with ID " + contactId + " already exists.");
        }

        contacts.put(contactId, contact);
    }

    //Delete a contact from the map
    public void deleteContact(String contactId) {
        if (contactId == null || contactId.isEmpty()) {
            throw new IllegalArgumentException("Contact ID cannot be null or empty.");
        }

        contacts.remove(contactId);
    }

    //Get a contact from the map
    public void updateContactField(String contactId, String field, String value) {
        if (contactId == null || contactId.isEmpty()) {
            throw new IllegalArgumentException("Contact ID cannot be null or empty.");
        }

        Contact contact = contacts.get(contactId);
        //Error Handling if contact does not exist
        if (contact == null) {
            throw new IllegalArgumentException("Contact with ID " + contactId + " does not exist.");
        }

        switch (field) {
            case "firstName":
                contact = updateFirstName(contact, value);
                break;
            case "lastName":
                contact = updateLastName(contact, value);
                break;
            case "phone":
                contact = updatePhone(contact, value);
                break;
            case "address":
                contact = updateAddress(contact, value);
                break;
            default:
                throw new IllegalArgumentException("Invalid field: " + field);
        }

        contacts.put(contactId, contact);
    }

    public Contact getContact(String contactId) {
        if (contactId == null || contactId.isEmpty()) {
            throw new IllegalArgumentException("This Contact ID cannot be null or empty!");
        }

        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact with ID " + contactId + " does not exist!");
        }

        return contact;
    }

    //Update first name
    private Contact updateFirstName(Contact contact, String firstName) {
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name cannot be null or empty.");
        }

        if (firstName.length() > 10) {
            throw new IllegalArgumentException("First name cannot be longer than 10 characters.");
        }

        return new Contact(contact.getContactId(), firstName, contact.getLastName(), contact.getPhone(), contact.getAddress());
    }

    //Update last name
    private Contact updateLastName(Contact contact, String lastName) {
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be null or empty.");
        }

        if (lastName.length() > 10) {
            throw new IllegalArgumentException("Last name cannot be longer than 10 characters.");
        }

        return new Contact(contact.getContactId(), contact.getFirstName(), lastName, contact.getPhone(), contact.getAddress());
    }

    //Update phone number
    private Contact updatePhone(Contact contact, String phone) {
        if (phone == null || phone.isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be null or empty.");
        }

        if (phone.length() != 10) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits.");
        }

        return new Contact(contact.getContactId(), contact.getFirstName(), contact.getLastName(), phone, contact.getAddress());
    }

    //Update address
    private Contact updateAddress(Contact contact, String address) {
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty.");
        }

        if (address.length() > 30) {
            throw new IllegalArgumentException("Address cannot be longer than 30 characters.");
        }

        return new Contact(contact.getContactId(), contact.getFirstName(), contact.getLastName(), contact.getPhone(), address);
    }
}
