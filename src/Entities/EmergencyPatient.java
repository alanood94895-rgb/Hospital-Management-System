package Entities;

import Behaviour.Displayable;

import java.time.LocalDate;
import java.util.List;

public class EmergencyPatient extends InPatient implements Displayable {

    String emergencyType;
    String arrivalMode;

    public Boolean getAdmittedViaER() {
        return admittedViaER;
    }

    public void setAdmittedViaER(Boolean admittedViaER) {
        this.admittedViaER = admittedViaER;
    }

    public String getEmergencyType() {
        return emergencyType;
    }

    public void setEmergencyType(String emergencyType) {
        this.emergencyType = emergencyType;
    }

    public String getArrivalMode() {
        return arrivalMode;
    }

    public void setArrivalMode(String arrivalMode) {
        this.arrivalMode = arrivalMode;
    }

    public Integer getTriageLevel() {
        return triageLevel;
    }

    public void setTriageLevel(Integer triageLevel) {
        this.triageLevel = triageLevel;
    }

    Integer triageLevel;
    Boolean admittedViaER;
    public EmergencyPatient(
            String id,
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

            // InPatient fields
            LocalDate admissionDate,
            LocalDate dischargeDate,
            String roomNumber,
            String bedNumber,
            String admittingDoctorId,
            Double dailyCharges,

            // EmergencyPatient fields
            String emergencyType,
            String arrivalMode,
            Integer triageLevel,
            Boolean admittedViaER
    ) {

        super(
                id,
                firstName,
                lastName,
                dateOfBirth,
                gender,
                phoneNumber,
                email,
                address,
                bloodGroup,
                emergencyContact,
                registrationDate,
                insuranceId,
                allergies,
                admissionDate,
                dischargeDate,
                roomNumber,
                bedNumber,
                admittingDoctorId,
                dailyCharges
        );

        this.emergencyType = emergencyType;
        this.arrivalMode = arrivalMode;
        this.triageLevel = triageLevel;
        this.admittedViaER = admittedViaER;
    }


    @Override
    public void displayInfo() {
        super.displayInfo();
    }

    @Override
    public void displaySummary() {
        System.out.println("===== Emergency Summary =====");
        System.out.println("Patient ID: " + getId());
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Emergency Type: " + emergencyType);
        System.out.println("Arrival Mode: " + arrivalMode);
        System.out.println("Triage Level: " + triageLevel);
        System.out.println("Admitted Via ER: " + admittedViaER);



    }
}