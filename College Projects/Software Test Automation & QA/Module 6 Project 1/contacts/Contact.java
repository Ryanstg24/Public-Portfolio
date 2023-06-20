package contacts;
public class Contact {
    //Declaring variables
    private final String contactId;
    private final String firstName;
    private final String lastName;
    private final String phone;
    private final String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        //Error Handling if contact ID is null or empty
        if (contactId == null || contactId.isEmpty()) {
            throw new IllegalArgumentException("Contact ID cannot be null or empty.");
        }
        //Error Handling if contact ID is longer than 10 characters
        if (contactId.length() > 10) {
            throw new IllegalArgumentException("Contact ID cannot be longer than 10 characters.");
        }
        //Error Handling if first name is null or empty
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name cannot be null or empty.");
        }
        //Error Handling if first name is longer than 10 characters
        if (firstName.length() > 10) {
            throw new IllegalArgumentException("First name cannot be longer than 10 characters.");
        }
        //Error Handling if last name is null or empty
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be null or empty.");
        }
        //Error Handling if last name is longer than 10 characters
        if (lastName.length() > 10) {
            throw new IllegalArgumentException("Last name cannot be longer than 10 characters.");
        }
        //Error Handling if phone number is null or empty
        if (phone == null || phone.isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be null or empty.");
        }
        //Error Handling if phone number is not 10 digits
        if (phone.length() != 10) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits.");
        }
        //Error Handling if address is null or empty
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty.");
        }
        //Error Handling if address is longer than 30 characters
        if (address.length() > 30) {
            throw new IllegalArgumentException("Address cannot be longer than 30 characters.");
        }
        
        //This is the constructor for the Contact class
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    //Getters for the Contact class
    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}
