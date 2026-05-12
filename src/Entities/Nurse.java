package Entities;

import Behaviour.Displayable;
import Entities.Patient;
import Utils.Constants;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Nurse extends Person implements Displayable {

    public String getDepartmentId() {
        return departmentId;
    }

    private String departmentId;

    public String getShift() {
        return shift;
    }

    private String shift;
    private String qualification;
    private List<Patient> assignedPatients;

    public Nurse(String id,
                 String firstName,
                 String lastName,
                 LocalDate dateOfBirth,
                 String gender,
                 String phoneNumber,
                 String email,
                 String address,
                 String departmentId,
                 String shift,
                 String qualification) {

        super(id,
                firstName,
                lastName,
                dateOfBirth,
                gender,
                phoneNumber,
                email,
                address);

        this.departmentId = departmentId;
        this.shift = shift;
        this.qualification = qualification;

        this.assignedPatients = new ArrayList<>();
    }

    @Override
    public void displayInfo() {
        super.displayInfo();

        System.out.println("Department ID: " + departmentId);
        System.out.println("Shift: " + shift);
        System.out.println("Qualification: " + qualification);
    }

    @Override
    public void displaySummary() {

    }

    // Assign patient
    public void assignPatient(Patient patient) {
        assignedPatients.add(patient);
        System.out.println(Constants.PATIENT_ASSIGNED_SUCCESSFULLY);
    }

    // Remove patient
    public void removePatient(Patient patient) {
        assignedPatients.remove(patient);
        System.out.println(Constants.PATIENT_REMOVED_SUCCESSFULLY);
    }
}