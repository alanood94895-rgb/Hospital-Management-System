package Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Doctor extends Person {

    // Add specific fields
    private String doctorId;
    private String specialization;
    private String qualification;
    private int experienceYears;
    private String departmentId;
    private double consultationFee;

    private List<String> availableSlots;
    private List<Patient> assignedPatients;

    public Doctor(String id, String firstName, String lastName,
                  LocalDate dob, String gender, String phone, String email, String address,
                  String doctorId, String specialization, String qualification,
                  int experienceYears, String departmentId, double consultationFee) {

        super(id, firstName, lastName, dob,
                gender, phone, email, address);

        this.doctorId = doctorId;
        this.specialization = specialization;
        this.qualification = qualification;
        this.experienceYears = experienceYears;
        this.departmentId = departmentId;
        this.consultationFee = consultationFee;

        availableSlots = new ArrayList<>();
        assignedPatients = new ArrayList<>();
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Specialization: " + specialization);
    }

    public void assignPatient(Patient patient) {
        assignedPatients.add(patient);
    }

    public void removePatient(Patient patient) {
        assignedPatients.remove(patient);
    }

    public void updateAvailability(String slot) {
        availableSlots.add(slot);
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getSpecialization() {
        return specialization;
    }
}