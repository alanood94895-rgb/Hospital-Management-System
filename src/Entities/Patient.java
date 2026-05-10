package Entities;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {

    private String patientId;
    private String bloodGroup;
    private List<String> allergies;
    private String emergencyContact;
    private LocalDate registrationDate;
    private String insuranceId;
    private List<String> medicalRecords;
    private List<String> appointments;

    public Patient(String id, String firstName, String lastName,
                   LocalDate dateOfBirth, String gender,
                   String phoneNumber, String email, String address,
                   String patientId, String bloodGroup,
                   String emergencyContact, LocalDate registrationDate,
                   String insuranceId) {

        super(id, firstName, lastName, dateOfBirth,
                gender, phoneNumber, email, address);

        this.patientId = patientId;
        this.bloodGroup = bloodGroup;
        this.allergies = allergies;
        this.emergencyContact = emergencyContact;
        this.registrationDate = registrationDate;
        this.insuranceId = insuranceId;
        this. medicalRecords = medicalRecords ;
        this. appointments = appointments ;

        allergies = new ArrayList<>();
    }

    @Override
    public void displayInfo() {

        super.displayInfo();

        System.out.println("Patient ID: " + patientId);
        System.out.println("Blood Group: " + bloodGroup);
        System.out.println("Insurance ID: " + insuranceId);
    }
    public void addMedicalRecord() {

    }

    public void  addAppointment() {

    }
    public void  updateInsurance() {

    }

    public void addAllergy(String allergy) {
        allergies.add(allergy);
    }

    public void updateInsurance(String insuranceId) {
        this.insuranceId = insuranceId;
    }
}


