package Entities;
import Utils.Constants;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Doctor extends Person{

    private String doctorId;
    private String specialization;
    private String qualification;
    private int experienceYears;
    private String departmentId;
    private double consultationFee;
    private List<String> availableSlots;
    private List<String> assignedPatients;

    public Doctor(String id,
                  String firstName,
                  String lastName,
                  LocalDate dateOfBirth,
                  String gender,
                  String phoneNumber,
                  String email,
                  String address,
                  String doctorId,
                  String specialization,
                  String qualification,
                  int experienceYears,
                  String departmentId,
                  double consultationFee,
                  List<String> availableSlots,
                  List<String> assignedPatients) {

        super(id,
                firstName,
                lastName,
                dateOfBirth,
                gender,
                phoneNumber,
                email,
                address);

        this.doctorId = doctorId;
        this.specialization = specialization;
        this.qualification = qualification;
        this.experienceYears = experienceYears;
        this.departmentId = departmentId;
        this.consultationFee = consultationFee;
        this.availableSlots = new ArrayList<>();
        this.assignedPatients =new ArrayList<>();
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    public List<String> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(List<String> availableSlots) {
        this.availableSlots = availableSlots;
    }

    public List<String> getAssignedPatients() {
        return assignedPatients;
    }

    public void setAssignedPatients(List<String> assignedPatients) {
        this.assignedPatients = assignedPatients;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();

        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Specialization: " + specialization);
        System.out.println("Qualification: " + qualification);
        System.out.println("Experience: " + experienceYears + " years");
        System.out.println("Department ID: " + departmentId);
        System.out.println("Consultation Fee:" + consultationFee);

        System.out.println("Available Slots: " + availableSlots);
        System.out.println("Assigned Patients: " + assignedPatients);
    }

    // Method to assign a patient

    public void assignPatient(String patientId , String doctorId) {
        assignedPatients.add(patientId);
        System.out.println(patientId + " assigned to Doctor " + doctorId);
    }

    // Method to remove a patient

    public void removePatient(String patientId,String doctorId) {
        if (assignedPatients.remove(patientId)) {
            System.out.println(doctorId + " removed from Doctor " + doctorId);
        } else {
            System.out.println("Patient not found");
        }
    }

    // Method to update availability
    public void updateAvailability(List<String> newSlots) {
        availableSlots = newSlots;
        System.out.println("Availability updated.");
    }

    public static class Surgeon extends Doctor {
        static Scanner scanner = new Scanner(System.in);
        private Integer surgeriesPerformed;
        private List<String> surgeryTypes;
        private Boolean operationTheatreAccess;


        public Surgeon(String id,
                       String firstName,
                       String lastName,
                       LocalDate dateOfBirth,
                       String gender,
                       String phoneNumber,
                       String email,
                       String address,
                       String specialization,
                       String qualification,
                       Integer experienceYears,
                       String departmentId,
                       double consultationFee ,
                       Integer surgeriesPerformed ,
                       Boolean operationTheatreAccess) {


            super( id,
                    firstName,
                    lastName,
                    dateOfBirth,
                    gender,
                    phoneNumber,
                    email,
                    address,
                    id,
                    specialization,
                    qualification,
                    experienceYears,
                    departmentId,
                    consultationFee,
                    new ArrayList<>(),
                    new ArrayList<>()
            );


            this.surgeriesPerformed = surgeriesPerformed;
            this.operationTheatreAccess = operationTheatreAccess;
            this.surgeryTypes = new ArrayList<>();
        }

        @Override
        public void displayInfo() {
            super.displayInfo();
            System.out.println("Surgeries Performed: " + surgeriesPerformed);
            System.out.println("Operation Theatre Access: " + operationTheatreAccess);
            for(String x : surgeryTypes){
                System.out.print(x + " , ");
            }
        }
        public void updateSurgeryCount(){
            surgeriesPerformed = surgeriesPerformed + 1 ;
        }

        public void performSurgery(){
            if(operationTheatreAccess){
                System.out.println(Constants.SURGEON_CAN_OPERATE);
                System.out.println("Enter surgery type: ");
                surgeryTypes.add(scanner.nextLine());
                updateSurgeryCount();

            }else{
                System.out.println(Constants.SURGEON_CANNOT_OPERATE);
            }



        }
    }
}
