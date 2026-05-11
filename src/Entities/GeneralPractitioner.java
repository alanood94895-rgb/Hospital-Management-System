package Entities;

import Entities.Doctor;

import java.time.LocalDate;
import java.util.ArrayList;

public class GeneralPractitioner extends Doctor {
    Boolean walkinAvailable;
    Boolean homeVisitAvailable;
    Boolean vaccinationCertified;


    public GeneralPractitioner(String id,
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
                               double consultationFee,
                               Boolean walkinAvailable,
                               Boolean homeVisitAvailable,
                               Boolean vaccinationCertified) {


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


        this.walkinAvailable = walkinAvailable;
        this.homeVisitAvailable = homeVisitAvailable;
        this.vaccinationCertified = vaccinationCertified;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Walk in Available: " + walkinAvailable);
        System.out.println("home Visit Available: " + homeVisitAvailable);
        System.out.println("Vaccination Certified: " + walkinAvailable);
    }

    public void scheduleHomeVisit(){
        if(homeVisitAvailable){
            System.out.println("home Visit Available");
        }
    }

    public void administerVaccine(){
        if(vaccinationCertified){
            System.out.println("Vaccination Certified");
        }
    }


}