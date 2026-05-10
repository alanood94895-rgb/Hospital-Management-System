package Entities;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {

    // Add specific fields

    private String patientId;
    private String bloodGroup;
    private List<String> allergies;
    private String emergencyContact;
    private LocalDate registrationDate;
    private String insuranceId;

    private List<MedicalRecord> medicalRecords;
    private List<Appointment> appointments;

    public Patient(String id, String firstName, String lastName, LocalDate dob, String gender,
                   String phone, String email, String address, String patientId, String bloodGroup,
                   String emergencyContact, LocalDate registrationDate, String insuranceId) {

         // Call Parent Constructor
        super(id, firstName, lastName,
                dateOfBirth, gender, phoneNumber, email, address);


        this.patientId = patientId;
        this.bloodGroup = bloodGroup;
        this.emergencyContact = emergencyContact;
        this.registrationDate = registrationDate;
        this.insuranceId = insuranceId;

        allergies = new ArrayList<>();
        medicalRecords = new ArrayList<>();
        appointments = new ArrayList<>();
    }

    // Override displayInfo()

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Patient ID: " + patientId);
        System.out.println("Blood Group: " + bloodGroup);
        System.out.println("Emergency Contact: " + emergencyContact);
        System.out.println("Registration Date: " + registrationDate);
        System.out.println("Insurance ID: " + insuranceId);
        System.out.println("Allergies: " + allergies);
    }

    public void addMedicalRecord(MedicalRecord record) {
        medicalRecords.add(record);
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void updateInsurance(String insuranceId) {
        this.insuranceId = insuranceId;
    }

    public String getPatientId() {
        return patientId;
    }
}