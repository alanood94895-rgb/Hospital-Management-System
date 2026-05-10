package Entities;

import Entities.Patient;
import Entities.Person;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Nurse extends Person {

    private String nurseId;
    private String departmentId;
    private String shift;
    private String qualification;

    private List<Patient> assignedPatients;

    public Nurse(String id, String firstName, String lastName,
                 LocalDate dob, String gender,
                 String phone, String email, String address,
                 String nurseId, String departmentId,
                 String shift, String qualification) {

        super(id, firstName, lastName, dob,
                gender, phone, email, address);

        this.nurseId = nurseId;
        this.departmentId = departmentId;
        this.shift = shift;
        this.qualification = qualification;

        assignedPatients = new ArrayList<>();
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Nurse ID: " + nurseId);
        System.out.println("Shift: " + shift);
    }

    public void assignPatient(Patient patient) {
        assignedPatients.add(patient);
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public String getShift() {
        return shift;
    }
}