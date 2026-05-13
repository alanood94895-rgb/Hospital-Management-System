package Entities;

import Behaviour.Displayable;

import java.time.LocalDate;
import java.util.List;

public class OutPatient extends Patient implements Displayable {
    Integer visitCount;
    LocalDate lastVisitDate;
    String preferredDoctorId;

    public OutPatient(String id,
                      String firstName,
                      String lastName,
                      LocalDate dateOfBirth,
                      String gender,
                      String phoneNumber,
                      String email,
                      String address,
                      String bloodGroup,
                      String emergencyContact,
                      LocalDate registrationDate,
                      String insuranceId,
                      List<String> allergies,
                      Integer visitCount,
                      LocalDate lastVisitDate,
                      String preferredDoctorId    ) {



        super(id,
                firstName,
                lastName,
                dateOfBirth,
                gender,
                phoneNumber, email, address, bloodGroup, emergencyContact, registrationDate, insuranceId, allergies);


        this.visitCount = visitCount;
        this.lastVisitDate = lastVisitDate;
        this.preferredDoctorId = preferredDoctorId;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
    }

    @Override
    public void displaySummary() {
        System.out.println("===== Out Patient Summary =====");
        System.out.println("Patient ID: " + getId());
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Visit Count: " + visitCount);
        System.out.println("Last Visit Date: " + lastVisitDate);
        System.out.println("Preferred Doctor ID: " + preferredDoctorId);

    }

    public void scheduleFollowUp(){
        List<String> appointments =  getAppointments();

        System.out.println("Enter next appointment");
        appointments.add(scanner.nextLine());
        setAppointments(appointments);


    }

    public void updateVisitCount() {
        this.visitCount++;
        this.lastVisitDate = LocalDate.now();
        System.out.println("Visit count updated to: " + visitCount);
    }


}