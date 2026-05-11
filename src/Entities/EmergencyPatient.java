package Entities;

import Entities.Patient;

import java.time.LocalDate;
import java.util.List;

public class EmergencyPatient extends Patient {

    String emergencyType;
    String arrivalMode;
    Integer triageLevel;
    Boolean admittedViaER;

    public EmergencyPatient(String id,
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
                            String emergencyType ,
                            String arrivalMode ,
                            Integer triageLevel ,
                            Boolean admittedViaER) {


        super( id,
                firstName,
                lastName,
                dateOfBirth,
                gender,
                phoneNumber,
                email,
                address,
                id,
                bloodGroup,
                emergencyContact,
                registrationDate,
                insuranceId
        );


        this.emergencyType = emergencyType;
        this.arrivalMode = arrivalMode;
        this.triageLevel = triageLevel;
        this.admittedViaER = admittedViaER;
    }


    @Override
    public void displayInfo() {
        super.displayInfo();

        System.out.println("Emergency Type: " + emergencyType);
        System.out.println("Arrival Mode: " + arrivalMode);
        System.out.println("Triage Level: " + triageLevel);
        System.out.println("Admitted Via ER: " + admittedViaER);

    }
}