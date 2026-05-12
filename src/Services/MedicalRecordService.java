package Services;

import Entities.MedicalRecord;
import Utils.Constants;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicalRecordService {
    List<MedicalRecord> medicalRecords = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);


    // ADD RECORD
    public void addRecord(MedicalRecord record) {
        medicalRecords.add(record);
        System.out.println(Constants.RECORD_ADDED_SUCCESSFULLY);
    }

    // ==================================================
    // CREATE NEW RECORD OBJECT
    // ==================================================

    public MedicalRecord addNewRecords() {

        System.out.println("Enter Record Id:");
        String recordId = scanner.nextLine();

        System.out.println("Enter patient Id:");
        String patientId = scanner.nextLine();

        System.out.println("Enter Doctor Id:");
        String doctorId = scanner.nextLine();

        LocalDate visitDate = LocalDate.now();

        System.out.println("Enter diagnosis:");
        String diagnosis = scanner.nextLine();

        System.out.println("Enter prescription:");
        String prescription = scanner.nextLine();

        System.out.println("Enter testResults:");
        String testResults = scanner.nextLine();

        System.out.println("Enter notes:");
        String notes = scanner.nextLine();

        MedicalRecord medicalRecord =
                new MedicalRecord(
                        recordId,
                        patientId,
                        doctorId,
                        visitDate,
                        diagnosis,
                        prescription,
                        testResults,
                        notes
                );

        return medicalRecord;
    }

    // ==================================================
    // EDIT RECORD
    // ==================================================

    public void editMedicalRecord(String recordId,
                                  MedicalRecord updatedRecord) {

        for (MedicalRecord m : medicalRecords) {

            if (m.getRecordId().equals(recordId)) {

                m.setDiagnosis(
                        updatedRecord.getDiagnosis()
                );

                m.setPrescription(
                        updatedRecord.getPrescription()
                );

                m.setNotes(
                        updatedRecord.getNotes()
                );

                System.out.println(
                        Constants.RECORD_UPDATED_SUCCESSFULLY
                );

                return;
            }
        }

        System.out.println(Constants.RECORD_NOT_FOUND);
    }

    // ==================================================
    // REMOVE RECORD
    // ==================================================

    public void removeRecord(String recordId) {

        for (MedicalRecord m : medicalRecords) {

            if (m.getRecordId().equals(recordId)) {

                medicalRecords.remove(m);

                System.out.println(
                        Constants.RECORD_REMOVED_SUCCESSFULLY
                );

                return;
            }
        }

        System.out.println(Constants.RECORD_NOT_FOUND);
    }

    // ==================================================
    // GET RECORDS BY PATIENT ID
    // ==================================================

    public void getRecordsByPatientId(String patientId) {

        for (MedicalRecord m : medicalRecords) {

            if (m.getPatientId()
                    .equals(patientId)) {

                m.displayInfo();
            }
        }
    }

    // ==================================================
    // GET RECORDS BY DOCTOR ID
    // ==================================================

    public void getRecordsByDoctorId(String doctorId) {

        for (MedicalRecord m : medicalRecords) {

            if (m.getDoctorId()
                    .equals(doctorId)) {

                m.displayInfo();
            }
        }
    }

    // ==================================================
    // DISPLAY ALL RECORDS
    // ==================================================

    public void displayAllRecords() {

        for (MedicalRecord m : medicalRecords) {

            m.displayInfo();
        }
    }

    // ==================================================
    // DISPLAY PATIENT HISTORY
    // ==================================================

    public void displayPatientHistory(String patientId) {

        System.out.println(
                "Patient Medical History:"
        );

        getRecordsByPatientId(patientId);
    }

    // ==================================================
    // HANDLE MEDICAL RECORD MENU
    // ==================================================

    public Boolean handleMedicalRecordMenu(Integer option) {

        switch (option) {

            case 1 -> {

                MedicalRecord record =
                        addNewRecords();

                addRecord(record);
            }

            case 2 -> {

                System.out.print(
                        "Enter Record ID to edit: "
                );

                String recordId =
                        scanner.nextLine().trim();

                MedicalRecord updatedRecord =
                        addNewRecords();

                editMedicalRecord(
                        recordId,
                        updatedRecord
                );
            }

            case 3 -> {

                System.out.print(
                        "Enter Record ID to remove: "
                );

                removeRecord(
                        scanner.nextLine().trim()
                );
            }

            case 4 -> {

                System.out.print(
                        "Enter Patient ID to view history: "
                );

                displayPatientHistory(
                        scanner.nextLine().trim()
                );
            }

            case 5 -> {

                System.out.print(
                        "Enter Doctor ID to view records: "
                );

                getRecordsByDoctorId(
                        scanner.nextLine().trim()
                );
            }

            case 6 -> {

                displayAllRecords();
            }

            case 7 -> {

                return false;
            }

            default -> {

                System.out.println("Invalid option.");
            }
        }

        return true;
    }
}