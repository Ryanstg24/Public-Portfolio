package appointments;
import java.util.Date;

public class Appointment {
    //Declaring Variables
    private final String appointmentId;
    private final Date appointmentDate;
    private final String description;

    //Appointment Constructor
    public Appointment(String appointmentId, Date appointmentDate, String description) {
        //If statements to check if the appointment is valid
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Invalid appointment ID");
        }

        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointment date");
        }

        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid appointment description");
        }
        //Setting the variables
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    //Getters
    public String getAppointmentId() {
        return appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }
}
