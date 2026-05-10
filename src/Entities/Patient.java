package Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {

    // Add Specific Fields
    private String patientId;
    private String bloodGroup;
    private List<String> allergies;
    private String emergencyContact;
    private LocalDate registrationDate;
    private String insuranceId;

    private List<MedicalRecord> medicalRecords;
    private List<Appointment> appointments;

    // Full Constructor
    public Patient(String id,
                   String firstName,
                   String lastName,
                   LocalDate dateOfBirth,
                   String gender,
                   String phoneNumber,
                   String email,
                   String address,
                   String patientId,
                   String bloodGroup,
                   String emergencyContact,
                   LocalDate registrationDate,
                   String insuranceId) {

        // Call Parent Constructor
        super(id,
                firstName,
                lastName,
                dateOfBirth,
                gender,
                phoneNumber,
                email,
                address);

        this.patientId = patientId;
        this.bloodGroup = bloodGroup;
        this.emergencyContact = emergencyContact;
        this.registrationDate = registrationDate;
        this.insuranceId = insuranceId;

        allergies = new ArrayList<>();
        medicalRecords = new ArrayList<>();
        appointments = new ArrayList<>();
    }

    // Getters and Setters

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }

    public List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    // Override displayInfo()
    @Override
    public void displayInfo() {

        // Call Parent Method
        super.displayInfo();

        System.out.println("Patient ID: " + patientId);
        System.out.println("Blood Group: " + bloodGroup);
        System.out.println("Emergency Contact: " + emergencyContact);
        System.out.println("Registration Date: " + registrationDate);
        System.out.println("Insurance ID: " + insuranceId);
        System.out.println("Allergies: " + allergies);
    }

    // Add Medical Record
    public void addMedicalRecord(MedicalRecord medicalRecord) {

        medicalRecords.add(medicalRecord);
    }

    // Add Appointment
    public void addAppointment(Appointment appointment) {

        appointments.add(appointment);
    }

    // Update Insurance
    public void updateInsurance(String newInsuranceId) {

        this.insuranceId = newInsuranceId;
    }
}