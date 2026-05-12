package Entities;

import Behaviour.Displayable;
import Entities.Doctor;

import java.util.ArrayList;
import java.util.List;

public class Department implements Displayable {

    private String departmentId;
    private String departmentName;
    private String headDoctorId;

    private List<Doctor> doctors;
    private List<Nurse> nurses;

    private int bedCapacity;
    private int availableBeds;

    // Constructor
    public Department(String departmentId,
                      String departmentName,
                      String headDoctorId,
                      List<Doctor> doctors,
                      List<Nurse> nurses,
                      int bedCapacity,
                      int availableBeds) {

        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.headDoctorId = headDoctorId;
        this.bedCapacity = bedCapacity;
        this.availableBeds = bedCapacity;

        this.doctors = new ArrayList<>();
        this.nurses = new ArrayList<>();
    }

    // Getters and Setters
    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getHeadDoctorId() {
        return headDoctorId;
    }

    public void setHeadDoctorId(String headDoctorId) {
        this.headDoctorId = headDoctorId;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public List<Nurse> getNurses() {
        return nurses;
    }

    public int getBedCapacity() {
        return bedCapacity;
    }

    public void setBedCapacity(int bedCapacity) {
        this.bedCapacity = bedCapacity;
    }

    public int getAvailableBeds() {
        return availableBeds;
    }

    public void setAvailableBeds(int availableBeds) {
        this.availableBeds = availableBeds;
    }

    public void assignDoctor(Doctor doctor) {
        doctors.add(doctor);
        System.out.println("Doctor assigned to department.");

    }

    public void assignNurse(Nurse nurse) {
        nurses.add(nurse);
        System.out.println("Nurse assigned to department.");

    }

    public void updateBedAvailability() {


    }

    // Display info
    public void displayInfo() {
        System.out.println("Department ID: " + departmentId);
        System.out.println("Department Name: " + departmentName);
        System.out.println("Head Doctor ID: " + headDoctorId);
        System.out.println("Bed Capacity: " + bedCapacity);
        System.out.println("Available Beds: " + availableBeds);
        System.out.println("Doctors: " + doctors.size());
        System.out.println("Nurses: " + nurses.size());
    }

    @Override
    public void displaySummary() {

    }
}