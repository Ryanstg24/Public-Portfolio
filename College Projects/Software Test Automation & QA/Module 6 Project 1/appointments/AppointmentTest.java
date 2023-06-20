package appointments;

import java.util.Date;

public class AppointmentTest {
    public static void main(String[] args) {
        testValidAppointment();
        testInvalidAppointmentId();
        testInvalidAppointmentDate();
        testInvalidDescription();
    }

    public static void testValidAppointment() {
        String appointmentId = "1234567890";
        Date appointmentDate = new Date(); // Use the current date
        String description = "Meeting";

        try {
            Appointment appointment = new Appointment(appointmentId, appointmentDate, description);
            System.out.println("Valid appointment created: " + appointment.getAppointmentId());
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to create valid appointment: " + e.getMessage());
        }
    }

    public static void testInvalidAppointmentId() {
        String appointmentId = "12345678901"; // Longer than 10 characters
        Date appointmentDate = new Date();
        String description = "Meeting";

        try {
            Appointment appointment = new Appointment(appointmentId, appointmentDate, description);
            System.out.println("Invalid appointment ID test failed. An appointment with an invalid ID was created.");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid appointment ID test passed. Error message: " + e.getMessage());
        }
    }

    public static void testInvalidAppointmentDate() {
        String appointmentId = "1234567890";
        Date appointmentDate = new Date(System.currentTimeMillis() - 86400000); // One day in the past
        String description = "Meeting";

        try {
            Appointment appointment = new Appointment(appointmentId, appointmentDate, description);
            System.out.println("Invalid appointment date test failed. An appointment with an invalid date was created.");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid appointment date test passed. Error message: " + e.getMessage());
        }
    }

    public static void testInvalidDescription() {
        String appointmentId = "1234567890";
        Date appointmentDate = new Date();
        String description = "This is a very long description that exceeds the maximum allowed length of 50 characters.";

        try {
            Appointment appointment = new Appointment(appointmentId, appointmentDate, description);
            System.out.println("Invalid description test failed. An appointment with an invalid description was created.");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid description test passed. Error message: " + e.getMessage());
        }
    }
}
