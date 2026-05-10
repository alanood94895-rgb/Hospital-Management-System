package Entities;

import java.time.LocalDate;
import java.util.List;


public class Doctor extends Person {

    private String doctorId;
    private String specialization;
    private String qualification;
    private int experienceYears;
    private String departmentId;
    private double consultationFee;
    private List <String> availableSlots ;
    private List <String> assignedPatients ;


    public Doctor(String id, String firstName, String lastName,
                  LocalDate dateOfBirth, String gender,
                  String phoneNumber, String email, String address,
                  String doctorId, String specialization,
                  int experienceYears, double consultationFee) {

        super(id, firstName, lastName,
                dateOfBirth, gender,
                phoneNumber, email, address);

        this.doctorId = doctorId;
        this.specialization = specialization;
        this.experienceYears = experienceYears;
        this.consultationFee = consultationFee;
    }

    @Override
    public void displayInfo() {

        super.displayInfo();

        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Specialization: " + specialization);
        System.out.println("Experience: " + experienceYears);
        System.out.println("Fee: " + consultationFee);
    }

}
