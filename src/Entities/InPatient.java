package Entities;

import Behaviour.Billable;
import Behaviour.Displayable;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class InPatient extends Patient implements Displayable, Billable {
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
                     LocalDate admissionDate ,
                     LocalDate dischargeDate,
                     String roomNumber ,
                     String bedNumber,
                     String admittingDoctorId,
                     Double dailyCharges) {

        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, bloodGroup, emergencyContact, registrationDate, insuranceId, allergies);

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
    }

    @Override
    public void displaySummary() {
        System.out.println("===== In Patient Summary =====");
        System.out.println("Patient ID: " + getId());
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Bed Number: " + bedNumber);
        System.out.println("Admission Date: " + admissionDate);
        System.out.println("Discharge Date: " + dischargeDate);
        System.out.println("Total Charges: " + calculateTotalCharges());

    }

    public Integer calculateStayDuration(){
        return Math.toIntExact(ChronoUnit.DAYS.between(admissionDate, dischargeDate));
    }

    public Double calculateTotalCharges(){
        return calculateStayDuration() * dailyCharges;

    }

    @Override
    public void calculateCharges() {
        Double totalCharges = calculateTotalCharges();
        System.out.println("Total Charges: " + totalCharges);
    }

    @Override
    public void generateBill() {
        System.out.println("===== Patient Bill =====");
        System.out.println("Patient ID: " + getId());
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Stay Duration: " + calculateStayDuration() + " days");
        System.out.println("Daily Charges: " + dailyCharges);
        System.out.println("Total Bill: " + calculateTotalCharges());

    }

    @Override
    public void processPayment(double amount) {
        Double totalBill = calculateTotalCharges();

        if (amount >= totalBill) {
            System.out.println("Payment successful.");
            System.out.println("Paid Amount: " + amount);

            if (amount > totalBill) {
                System.out.println("Change Returned: " + (amount - totalBill));
            }
        } else {
            System.out.println("Insufficient payment.");
            System.out.println("Remaining Balance: " + (totalBill - amount));
        }

    }
}