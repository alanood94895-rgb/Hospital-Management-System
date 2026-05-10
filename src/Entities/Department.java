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

    public Department(String departmentId, String departmentName,
                      String headDoctorId, int bedCapacity, int availableBeds) {

        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.headDoctorId = headDoctorId;
        this.bedCapacity = bedCapacity;
        this.availableBeds = availableBeds;

        doctors = new ArrayList<>();
        nurses = new ArrayList<>();
    }
    public void assignDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void assignNurse(Nurse nurse) {
        nurses.add(nurse);
    }

    public void updateBedAvailability(int beds) {
        availableBeds = beds;
    }

    public void displayInfo() {
        System.out.println("Department: " + departmentName);
        System.out.println("Available Beds: " + availableBeds);
    }

    public String getDepartmentId() {
        return departmentId;
    }
}

