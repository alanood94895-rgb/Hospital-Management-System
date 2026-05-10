package Entities;

import java.time.LocalDate;


public class MedicalRecord {
    private String recordId;
    private String patientId;
    private String doctorId;
    private LocalDate visitDate;
    private String diagnosis;
    private String prescription;
    private String testResults;
    private String notes;

    public MedicalRecord(String recordId, String patientId, String doctorId, LocalDate visitDate,
                         String diagnosis, String prescription, String testResults, String notes) {

        this.recordId = recordId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.visitDate = visitDate;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        this.testResults = testResults;
        this.notes = notes;
    }

    public void displayInfo() {
        System.out.println("Diagnosis: " + diagnosis);
        System.out.println("Prescription: " + prescription);
    }

    public String getPatientId() {
        return patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }
}

