package Entities;

import Behaviour.Displayable;
import Utils.Constants;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Appointment implements Displayable {
    static Scanner scanner = new Scanner(System.in);

    private String appointmentId;
    private String patientId;
    private String doctorId;
    private LocalDate appointmentDate;
    private String appointmentTime;
    private String status;
    private String reason;
    private String notes;

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }


    public Appointment(){;
    }

    public Appointment(String appointmentId , String patientId,
                       String doctorId, LocalDate appointmentDate,String appointmentTime,
                       String status , String reason , String notes){
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status = status;
        this.reason = reason;
        this.notes = notes;

    }

    public void displayInfo(){
        System.out.println("Appointment Id: " + appointmentId);
        System.out.println("Patient Id: " + patientId);
        System.out.println("Doctor Id: " + doctorId);
        System.out.println("Appointment Date: " + appointmentDate);
        System.out.println("Appointment Time: " + appointmentTime);
        System.out.println("Status: " + status);
        System.out.println("Reason: " + reason);
        System.out.println("Notes: " + notes);
        System.out.println();
    }

    @Override
    public void displaySummary() {

    }

    public void reschedule(){
        System.out.println("Enter new appointment date (YYYY-MM-DD): ");
        String newDate = scanner.nextLine();
        LocalDate appointmentDate = LocalDate.parse(newDate);
        setAppointmentDate(appointmentDate);

        System.out.println("Enter new appointment time: ");
        String newTime = scanner.nextLine();
        setAppointmentTime(newTime);

        setStatus("Rescheduled");

        System.out.println(Constants.APPOINTMENT_RESCHEDULED_SUCCESSFULLY);

    }
    public void cancel(){
        setStatus("Cancelled");

    }
    public void complete(){
        setStatus("Completed");

    }
    public void addNotes(String notes){
        this.notes = notes;
    }

    public void addNotes(String notes, String addedBy) {
        this.notes = "Note : " + notes + "Added By: " +addedBy ;

    }
    public void addNotes(String notes, String addedBy, LocalDateTime timestamp){
        this.notes = "Note : " + notes + "Added By: " +addedBy + "....."+timestamp;
    }

}