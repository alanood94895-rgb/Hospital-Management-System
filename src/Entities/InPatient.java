package Entities.Patient;

import Entities.Patient;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class InPatient extends Patient {
    LocalDate admissionDate;
    LocalDate dischargeDate;
    String roomNumber;
    String bedNumber;
    String admittingDoctorId;
    Double dailyCharges;


    public InPatient(String id,
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
                     LocalDate admissionDate,
                     LocalDate dischargeDate,
                     String roomNumber,
                     String bedNumber,
                     String admittingDoctorId,
                     Double dailyCharges) {

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

        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.roomNumber =  roomNumber;
        this.bedNumber =  bedNumber;
        this.admittingDoctorId  = admittingDoctorId;
        this.dailyCharges = dailyCharges;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Admission Date: " + admissionDate);
        System.out.println("Discharge Date: " + dischargeDate);
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Bed Number: " + bedNumber);
        System.out.println("Admitting Doctor ID: " + admittingDoctorId);
        System.out.println("Daily Charges: " + dailyCharges);
    }

    public Integer calculateStayDuration(){
        return Math.toIntExact(ChronoUnit.DAYS.between(admissionDate, dischargeDate));
    }

    public Double calculateTotalCharges(){
        return calculateStayDuration() * dailyCharges;

    }
}