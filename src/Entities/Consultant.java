package Entities;

import Entities.Doctor;
import Entities.Patient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Consultant extends Doctor {

    private List<String> consultationTypes;
    Boolean onlineConsultationAvailable;
    Integer consultationDuration;


    public Consultant(String id,
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
                      double consultationFee) {

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

        this.consultationTypes = new ArrayList<>();
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Online Consultation Available: " + onlineConsultationAvailable);
        System.out.println("Consultation Duration: " + consultationDuration);
        System.out.println("Consultation Types");
        for(String x : consultationTypes) {
            System.out.print(x + " , ");
        }
    }

    public void scheduleConsultation(String patientId, String type) {
        System.out.println("Consultation scheduled for patient: " + patientId);
        System.out.println("Type: " + type);
        System.out.println("Duration: " + consultationDuration + " minutes");
    }

    public void provideSecondOpinion(){


    }
}