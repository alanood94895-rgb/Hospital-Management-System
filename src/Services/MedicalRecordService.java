package Services;

import Entities.MedicalRecord;
import Entities.Nurse;
import Utils.Constants;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicalRecordService {
    List <MedicalRecord> medicalRecords = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public void addRecord(MedicalRecord record){
        medicalRecords.add(record);
        System.out.println(Constants.RECORD_ADDED_SUCCESSFULLY);
    }

    public MedicalRecord addNewRecords(){
        System.out.println("Enter Record Id: ");
        String recordId = scanner.nextLine();

        System.out.println("Enter patient Id: ");
        String patientId = scanner.nextLine();

        System.out.println("Enter Doctor Id: ");
        String doctorId = scanner.nextLine();

        LocalDate visitDate = LocalDate.now();

        System.out.println("Enter diagnosis: ");
        String diagnosis = scanner.nextLine();

        System.out.println("Enter prescription: ");
        String prescription = scanner.nextLine();

        System.out.println("Enter testResults: ");
        String testResults = scanner.nextLine();

        System.out.println("Enter notes: ");
        String notes = scanner.nextLine();

        MedicalRecord medicalRecord = new MedicalRecord(
                recordId,patientId,doctorId,visitDate,diagnosis,prescription,testResults,notes
        );

        return medicalRecord;

    }

    public void editMedicalRecord(String recordId, MedicalRecord updatedRecord){
        for(MedicalRecord m : medicalRecords){
            if(m.getRecordId().equals(recordId)){

                m.setDiagnosis(updatedRecord.getDiagnosis());
                m.setPrescription(updatedRecord.getPrescription());
                m.setNotes(updatedRecord.getNotes());


                System.out.println(Constants.RECORD_UPDATED_SUCCESSFULLY);
                return;
            }
        }
        System.out.println(Constants.RECORD_NOT_FOUND);
    }

    public void removeRecord(String recordId) {
        for (MedicalRecord n : medicalRecords) {
            if (n.getRecordId().equals(recordId)) {
                medicalRecords.remove(n);
                System.out.println(Constants.RECORD_REMOVED_SUCCESSFULLY);
                return;
            }
        }
        System.out.println(Constants.RECORD_NOT_FOUND);

    }
    public void getRecordsByPatientId(String patientId){
        for(MedicalRecord m : medicalRecords) {
            if (m.getPatientId().equals(patientId)) {
                m.displayInfo();
                return;
            }
        }
        System.out.println(Constants.RECORD_NOT_FOUND);
    }

    public void getRecordsByDoctorId(String doctorId){
        for(MedicalRecord m : medicalRecords) {
            if (m.getDoctorId().equals(doctorId)) {
                m.displayInfo();
                return;
            }
        }
        System.out.println(Constants.RECORD_NOT_FOUND);
    }

}