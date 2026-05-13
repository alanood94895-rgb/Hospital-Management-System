package Entities;

import Behaviour.Displayable;
import Entities.Patient;
import Entities.Person;
import Services.PatientService;
import Utils.Constants;
import Utils.HelperUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Doctor extends Person implements Displayable {
    static Scanner scanner = new Scanner(System.in);
    PatientService patientService = new PatientService();

    public List<String> getAssignedPatients() {
        return assignedPatients;
    }

    public void setAssignedPatients(List<String> assignedPatients) {

        this.assignedPatients = assignedPatients;
    }

    public List<String> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(List<String> availableSlots) {
        this.availableSlots = availableSlots;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(Integer experienceYears) {
        if (Utils.HelperUtils.isPositive(experienceYears)) {
            this.experienceYears = experienceYears;
        }
    }
    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public PatientService getPatientService() {
        return patientService;
    }

    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static void setScanner(Scanner scanner) {
        Doctor.scanner = scanner;
    }

    private String specialization;
    private String qualification;
    private Integer experienceYears;
    private String departmentId;
    private double consultationFee;
    private List<String> availableSlots;
    private List<String> assignedPatients;

    //call parent constructor
    public Doctor() {
        super();

    }

    public Doctor(String id,
                  String firstName,
                  String lastName,
                  LocalDate dateOfBirth,
                  String gender,
                  String phoneNumber,
                  String email,
                  String address ,
                  String specialization,
                  String qualification ,
                  Integer experienceYears ,
                  String departmentId,
                  double consultationFee) {

        super(id,
                firstName,
                lastName,
                dateOfBirth,
                gender,
                phoneNumber,
                email,
                address);


        this.specialization = specialization;
        this.qualification = qualification;
        this.experienceYears = experienceYears;
        this.departmentId = departmentId;
        this.consultationFee = consultationFee;
        this.availableSlots = new ArrayList<>();
        this.assignedPatients = new ArrayList<>();
    }


    public void assignPatient(String patientId) {
        if(assignedPatients.isEmpty()) {
            assignedPatients.add(patientId);
        }
        if (HelperUtils.isNotNull(patientId)
                && !assignedPatients.contains(patientId))
            assignedPatients.add(patientId);
    }


    public void removePatient(Patient patient) {
        assignedPatients.remove(patient);
        System.out.println(Constants.PATIENT_REMOVED_SUCCESSFULLY);
    }

    public void updateAvailability(String slot) {
        availableSlots.add(slot);
        System.out.println(Constants.AVAILABILITY_UPDATED);
    }




    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(specialization);
        System.out.println(qualification);
        System.out.println(experienceYears);
        System.out.println(departmentId);
        System.out.println(consultationFee);

        System.out.println("Available Slots");
        for(String slot : availableSlots){
            System.out.print(slot + ",");
        }

        System.out.println("Assigned Patients");
        for(String patient : assignedPatients){
            patient.isBlank();
        }
    }

    @Override
    public void displaySummary() {

    }

    public void updateFee(double fee){
        this.consultationFee = fee;
    }

    public void updateFee(double fee , String reason){
        this.consultationFee = fee;
    }

    public void addAvailability(String slot){
        this.availableSlots.add(slot);
    }

    public void addAvailability(List<String> slots){
        this.availableSlots = slots;
    }


}