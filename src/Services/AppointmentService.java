package Services;

public class AppointmentService {

    private List<Appointment> appointments =
            new ArrayList<>();


    // Add Appointment
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);

    }
    // Remove Appointment
    public void removeAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }
    // Display All
    public void displayAllAppointments() {

        for (Appointment appointment : appointments) {
            appointment.displayInfo();
        }
    }


}
