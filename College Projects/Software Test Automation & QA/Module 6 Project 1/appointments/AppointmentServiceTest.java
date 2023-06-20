package appointments;

public class AppointmentServiceTest {
    public static void main(String[] args) {
        testAddAppointment();
        testAddDuplicateAppointment();
        testDeleteAppointment();
    }

    public static void testAddAppointment() {
        AppointmentService appointmentService = new AppointmentService();
        Appointment appointment = createAppointment("1234567890", "2023-06-06", "Meeting");

        try {
            appointmentService.addAppointment(appointment);
            System.out.println("Appointment added successfully: " + appointment.getAppointmentId());
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to add appointment: " + e.getMessage());
        }
    }

    public static void testAddDuplicateAppointment() {
        AppointmentService appointmentService = new AppointmentService();
        Appointment appointment = createAppointment("1234567890", "2023-06-06", "Meeting");

        try {
            appointmentService.addAppointment(appointment);
            appointmentService.addAppointment(appointment);
            System.out.println("Duplicate appointment test failed. Duplicate appointment was added.");
        } catch (IllegalArgumentException e) {
            System.out.println("Duplicate appointment test passed. Error message: " + e.getMessage());
        }
    }

    public static void testDeleteAppointment() {
        AppointmentService appointmentService = new AppointmentService();
        Appointment appointment = createAppointment("1234567890", "2023-06-06", "Meeting");
        appointmentService.addAppointment(appointment);

        try {
            appointmentService.deleteAppointment(appointment.getAppointmentId());
            System.out.println("Appointment deleted successfully: " + appointment.getAppointmentId());
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to delete appointment: " + e.getMessage());
        }
    }

    private static Appointment createAppointment(String appointmentId, String appointmentDate, String description) {
        // Convert appointmentDate string to java.util.Date object
        return new Appointment(appointmentId, null, description);
    }
}
