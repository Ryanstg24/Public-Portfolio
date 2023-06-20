package appointments;
import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    //Declaring Variables
    private final Map<String, Appointment> appointments;

    //Creating the hashmap
    public AppointmentService() {
        appointments = new HashMap<>();
    }

    //Adding an appointment
    public void addAppointment(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("Invalid appointment");
        }

        String appointmentId = appointment.getAppointmentId();
        if (appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID already exists");
        }

        appointments.put(appointmentId, appointment);
    }

    //Deleting an appointment
    public void deleteAppointment(String appointmentId) {
        if (appointmentId == null) {
            throw new IllegalArgumentException("Invalid appointment ID");
        }

        appointments.remove(appointmentId);
    }
}
