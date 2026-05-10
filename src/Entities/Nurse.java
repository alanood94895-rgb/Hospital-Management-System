package Entities;

import Entities.Patient;
import Entities.Person;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Nurse extends Person {

    // Nurse Specific Fields
    private String nurseId;
    private String departmentId;
    private String shift;
    private String qualification;

    private List<Patient> assignedPatients;

    // Full Constructor
    public Nurse(String id,
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
                 String qualification) {

        // Call Parent Constructor
        super(id,
                firstName,
                lastName,
                dateOfBirth,
                gender,
                phoneNumber,
                email,
                address);

        this.nurseId = nurseId;
        this.departmentId = departmentId;
        this.shift = shift;
        this.qualification = qualification;

        assignedPatients = new ArrayList<>();
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

    public List<Patient> getAssignedPatients() {
        return assignedPatients;
    }

    // Override displayInfo()
    @Override
    public void displayInfo() {

        // Call Parent Method
        super.displayInfo();

        System.out.println("Nurse ID: " + nurseId);
        System.out.println("Department ID: " + departmentId);
        System.out.println("Shift: " + shift);
        System.out.println("Qualification: " + qualification);
    }

    // Assign Patient
    public void assignPatient(Patient patient) {

        assignedPatients.add(patient);
    }

    // Remove Patient
    public void removePatient(Patient patient) {

        assignedPatients.remove(patient);
    }
}