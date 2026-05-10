package Services;

public class AppointmentService {

    private List<Appointment> appointments =
            new ArrayList<>();


    // Add Appointment
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }
}
