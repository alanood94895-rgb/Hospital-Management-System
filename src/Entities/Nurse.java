package Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Nurse extends Person {

    // Nurse specific fields

    private String nurseId;
    private String departmentId;
    private String shift;
    private String qualification;
    private List<String> assignedPatients;

    // Constructor

    public Nurse(
            String id,
            String firstName,
            String lastName,
            LocalDate dateOfBirth,
            String gender,
            String phoneNumber,
            String email,
            String address,
            String nurseId,
            String departmentId,
            String shift,
            String qualification,
            List<String> assignedPatients)
    {

        super(
                id,
                firstName,
                lastName,
                dateOfBirth,
                gender,
                phoneNumber,
                email,
                address
        );

        this.nurseId = nurseId;
        this.departmentId = departmentId;
        this.shift = shift;
        this.qualification = qualification;
        this.assignedPatients = new ArrayList<>(assignedPatients);
    }

    // Getters and Setters

    public String getNurseId() {
        return nurseId;
    }

    public void setNurseId(String nurseId) {
        this.nurseId = nurseId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public List<String> getAssignedPatients() {
        return assignedPatients;
    }

    public void setAssignedPatients(List<String> assignedPatients) {
        this.assignedPatients = assignedPatients;
    }

    // Display Nurse Information
    @Override
    public void displayInfo() {

        super.displayInfo();

        System.out.println("Nurse ID: " + nurseId);
        System.out.println("Department ID: " + departmentId);
        System.out.println("Shift: " + shift);
        System.out.println("Qualification: " + qualification);
        System.out.println("Assigned Patients: " + assignedPatients);
    }

    // Assign Patient
    public void assignPatient(String patientId) {

        if (!assignedPatients.contains(patientId)) {

            assignedPatients.add(patientId);

            System.out.println("Patient " + patientId + " assigned to Nurse " + nurseId);

        } else {

            System.out.println("Patient already assigned.");
        }
    }

    // Remove Patient
    public void removePatient(String patientId) {

        if (assignedPatients.remove(patientId)) {

            System.out.println("Patient " + patientId + " removed from Nurse " + nurseId);

        } else {

            System.out.println("Patient not found.");
        }
    }
}