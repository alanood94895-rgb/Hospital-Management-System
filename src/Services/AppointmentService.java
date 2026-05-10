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
    // Get By Patient
    public List<Appointment> getAppointmentsByPatient(
            String patientId) {

        List<Appointment> result = new ArrayList<>();

        for (Appointment appointment : appointments) {

            if (appointment.getPatientId()
                    .equalsIgnoreCase(patientId)) {

                result.add(appointment);
            }
        }

        return result;
    }
    // Get By Doctor
    public List<Appointment> getAppointmentsByDoctor(
            String doctorId) {

        List<Appointment> result = new ArrayList<>();

        for (Appointment appointment : appointments) {

            if (appointment.getDoctorId()
                    .equalsIgnoreCase(doctorId)) {

                result.add(appointment);
            }
        }

        return result;
    }



}
