package Entities;

import Utils.Constants;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Patient extends Person {

    static Scanner scanner = new Scanner(System.in);


    // Patient Specific Fields

    private String patientId;
    private String bloodGroup;
    private List<String> allergies;
    private String emergencyContact;
    private LocalDate registrationDate;
    private String insuranceId;

    private List<String> medicalRecords;
    private List<String> appointments;


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
        medicalRecords = new ArrayList<String>();
        appointments = new ArrayList<String>();
    }

    public Patient() {

    }

    // Get and Set

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

    public List<String> getMedicalRecords() {
        return medicalRecords;
    }

    public List<String> getAppointments() {
        return appointments;
    }

    // Override displayInfo()

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Blood Group :"+bloodGroup );
        System.out.println("Allergies");
        for(String x : allergies){
            System.out.print(x + ",");
        }

        System.out.println("Emergency Contact :"+emergencyContact);
        System.out.println("Registration Date :"+registrationDate);
        System.out.println("Insurance Id      :"+insuranceId);

        System.out.println("Medical Records");
        System.out.println();
        medicalRecords.stream().map(x -> x + ",").forEach(System.out::print);
        System.out.println("Appointments");
        System.out.println();
        appointments.stream().map(x -> x + ",").forEach(System.out::print);

    }

    public void addMedicalRecord(){
        System.out.println(Constants.ADD_MEDICAL_RECORD);
        medicalRecords.add(scanner.nextLine());
    }

    public void addAppointment(){
        System.out.println(Constants.ADD_APPOINTMENT);
        appointments.add(scanner.nextLine());
    }

    public void updateInsurance(){
        System.out.println(Constants.ENTER_INSURANCE);
        this.insuranceId = scanner.nextLine();
    }

}