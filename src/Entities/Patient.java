package Entities;

import Behaviour.Displayable;
import Utils.Constants;
import Utils.HelperUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Patient extends Person implements Displayable {
    static Scanner scanner = new Scanner(System.in);

    public List<String> getAppointments() {
        return appointments;
    }



    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static void setScanner(Scanner scanner) {
        Patient.scanner = scanner;
    }



    public List<MedicalRecord> getMedicalRecords() {

        return medicalRecords;
    }

    public void setMedicalRecords(List<MedicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    private String bloodGroup;
    private List<String> allergies = new ArrayList<>();
    private String emergencyContact;
    private LocalDate registrationDate;
    private String insuranceId;
    private List<MedicalRecord> medicalRecords;
    private List<String> appointments;

    public void setAppointments(List<String> appointments) {
        this.appointments = appointments;
    }


    //call parent constructor
    public Patient() {
        super();

    }
    public Patient(String id,
                   String firstName,
                   String lastName,
                   LocalDate dateOfBirth,
                   String gender,
                   String phoneNumber,
                   String email,
                   String address,
                   String bloodGroup,
                   String emergencyContact,
                   LocalDate registrationDate,
                   String insuranceId,
                   List<String> allergies) {

        super(id,
                firstName,
                lastName,
                dateOfBirth,
                gender,
                phoneNumber,
                email,
                address);

        this.bloodGroup = bloodGroup;
        this.emergencyContact = emergencyContact;
        this.registrationDate = registrationDate;
        this.insuranceId = insuranceId;
        this.allergies = allergies;
        this.medicalRecords = new ArrayList<>();
        this.appointments = new ArrayList<>();
    }




    //Display patient information
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Blood Group:"+bloodGroup );
        System.out.println("Allergies");
        for(String x : allergies){
            System.out.print(x + ",");
        }

        System.out.println("Emergency Contact :"+emergencyContact);
        System.out.println("Registration Date :"+registrationDate);
        System.out.println("Insurance Id :"+insuranceId);

        System.out.println("Medical Records");
        System.out.println();
        for(MedicalRecord x : medicalRecords){
            System.out.print(x + ",");

        }System.out.println("Appointments");
        System.out.println();
        for(String x : appointments){
            System.out.print(x + ",");
        }

    }

    @Override
    public void displaySummary() {

    }

    public void addMedicalRecord(MedicalRecord record) {
        if (HelperUtils.isNotNull(record)) medicalRecords.add(record);
    }

    public void addAppointment(Appointment appointment){
        System.out.println(Constants.ADD_APPOINTMENT);
        appointments.add(scanner.nextLine());
    }

    public void updateInsurance(){
        System.out.println(Constants.ENTER_INSURANCE);
        this.insuranceId = scanner.nextLine();
    }
    public void updateContact(String phone){
        setPhoneNumber(phone);
    }

    public void updateContact(String phone, String email){
        setPhoneNumber(phone);
        setEmail(email);
    }
    public void updateContact(String phone, String email, String address){
        setPhoneNumber(phone);
        setEmail(email);
        setAddress(address);
    }

}