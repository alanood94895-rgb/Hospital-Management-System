package Entities;
import java.time.LocalDate;


public class Appointment {

    private String appointmentId;
    private String patientId;
    private String doctorId;
    private LocalDate appointmentDate;
    private String appointmentTime;
    private String status;
    private String reason;
    private String notes;

    public Appointment(String appointmentId, String patientId, String doctorId, LocalDate appointmentDate,
                       String appointmentTime, String status, String reason, String notes) {


        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status = status;
        this.reason = reason;
        this.notes = notes;
    }

    public void reschedule(LocalDate newDate, String newTime) {
        this.appointmentDate = newDate;
        this.appointmentTime = newTime;
        status = "Rescheduled";
    }

    public void cancel() {
        status = "Cancelled";
    }

    public void complete() {
        status = "Completed";
    }

    public void displayInfo() {
        System.out.println("Appointment ID: " + appointmentId);
        System.out.println("Status: " + status);
    }

    public String getPatientId() {
        return patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void  assignDoctor() {

    }


}

