package Entities;
import java.util.ArrayList;
import java.util.List;


public class Department {

    private String departmentId;
    private String departmentName;
    private String headDoctorId;

    private List<Doctor> doctors;
    private List<Nurse> nurses;

    private int bedCapacity;
    private int availableBeds;

    // Full Constructor
    public Department(String departmentId,
                      String departmentName,
                      String headDoctorId,
                      int bedCapacity,
                      int availableBeds) {

        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.headDoctorId = headDoctorId;
        this.bedCapacity = bedCapacity;
        this.availableBeds = availableBeds;

        doctors = new ArrayList<>();
        nurses = new ArrayList<>();
    }

    // Get and Set

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

    // displayInfo Method
    public void displayInfo() {

        System.out.println("Department ID: " + departmentId);
        System.out.println("Department Name: " + departmentName);
        System.out.println("Head Doctor ID: " + headDoctorId);
        System.out.println("Bed Capacity: " + bedCapacity);
        System.out.println("Available Beds: " + availableBeds);

        System.out.println("Doctors Count: " + doctors.size());
        System.out.println("Nurses Count: " + nurses.size());
    }

    // Assign Doctor
    public void assignDoctor(Doctor doctor) {

        doctors.add(doctor);
    }

    // Assign Nurse
    public void assignNurse(Nurse nurse) {

        nurses.add(nurse);
    }

    // Update
    public void updateBedAvailability(int beds) {

        this.availableBeds = beds;
    }
}