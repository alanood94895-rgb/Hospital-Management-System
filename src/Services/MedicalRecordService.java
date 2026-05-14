package Services;

import Behaviour.Editable;
import Behaviour.Manageable;
import Behaviour.Searchable;
import Entities.MedicalRecord;
import Entities.Patient;
import Utils.Constants;
import Utils.HelperUtils;
import Utils.InputHandler;
import Utils.MenuMessages;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MedicalRecordService implements Manageable, Searchable, Editable {
    private static List <MedicalRecord> medicalRecords = new ArrayList<>();
    PatientService patientService = new PatientService();

    public void addRecord(MedicalRecord record){

        Patient patient = patientService.getPatientById(record.getPatientId());
        if (HelperUtils.isNull(patient)){
            System.out.println(Constants.PATIENT_NOT_FOUND);
            return;
        }
        medicalRecords.add(record);
        patient.addMedicalRecord(record);
        System.out.println(Constants.RECORD_ADDED_SUCCESSFULLY);
    }

    public void addNewRecords(){


        String patientId = InputHandler.getStringInput("Enter patient Id: ");

        String doctorId = InputHandler.getStringInput("Enter Doctor Id: ");

        LocalDate visitDate = LocalDate.now();

        String diagnosis = InputHandler.getStringInput("Enter diagnosis: ");

        String prescription = InputHandler.getStringInput("Enter prescription: ");

        String testResults = InputHandler.getStringInput("Enter testResults: ");

        String notes = InputHandler.getStringInput("Enter notes: ");

        MedicalRecord medicalRecord = new MedicalRecord(
                HelperUtils.generateId("MR",3),patientId,doctorId,visitDate,diagnosis,prescription,testResults,notes
        );

        addRecord(medicalRecord);

    }

    public void updateMedicalRecord() {

        String recordId = InputHandler.getStringInput("Enter record ID: ");

        MedicalRecord record = getRecordById(recordId);

        if (HelperUtils.isNull(record)) {
            return;
        }

        String diagnosis = InputHandler.getStringInput("Enter new diagnosis: ");
        String prescription = InputHandler.getStringInput("Enter new prescription: ");
        String testResults = InputHandler.getStringInput("Enter new testResults: ");

        MedicalRecord updatedRecord = new MedicalRecord();
        updatedRecord.setRecordId(recordId);
        updatedRecord.setDiagnosis(diagnosis);
        updatedRecord.setPrescription(prescription);
        updatedRecord.setTestResults(testResults);

        edit(updatedRecord);
    }
    @Override
    public void edit(Object updatedData) {

        if (!(updatedData instanceof MedicalRecord)) {
            System.out.println("Invalid medical record data");
            return;
        }
        MedicalRecord updated = (MedicalRecord) updatedData;

        for (MedicalRecord m : medicalRecords) {

            if (m.getRecordId().equals(updated.getRecordId())) {

                m.setDiagnosis(updated.getDiagnosis());
                m.setPrescription(updated.getPrescription());
                m.setTestResults(updated.getTestResults());
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
    public void getRecords(){
        if (HelperUtils.isNull(medicalRecords)){
            System.out.println(Constants.RECORD_NOT_FOUND);
            return;
        }
        for(MedicalRecord m : medicalRecords) {
            m.displayInfo();
        }
    }
    public MedicalRecord getRecordById(String recordId){
        for(MedicalRecord record : medicalRecords) {
            if (record.getRecordId().equals(recordId)) {
                return record;
            }
        }
        System.out.println(Constants.RECORD_NOT_FOUND);
        return null;
    }

    public void getRecordsByPatientId(String patientId){
        if (HelperUtils.isNull(medicalRecords)){
            System.out.println(Constants.RECORD_NOT_FOUND);
            return;
        }
        for(MedicalRecord m : medicalRecords) {
            if (m.getPatientId().equals(patientId)) {
                m.displayInfo();
                return;
            }
        }
        System.out.println(Constants.RECORD_NOT_FOUND);
    }

    public void getRecordsByDoctorId(String doctorId){
        if (HelperUtils.isNull(medicalRecords)){
            System.out.println(Constants.RECORD_NOT_FOUND);
            return;
        }
        for(MedicalRecord m : medicalRecords) {
            if (m.getDoctorId().equals(doctorId)) {
                m.displayInfo();
                return;
            }
        }
        System.out.println(Constants.RECORD_NOT_FOUND);
    }

    @Override
    public void add(Object entity) {
        MedicalRecord medicalRecord = (MedicalRecord) entity;
        medicalRecords.add(medicalRecord);

    }

    @Override
    public void remove(String id) {
        MedicalRecord medicalRecord = getRecordById(id);
        if(HelperUtils.isNotNull(medicalRecord)){
            medicalRecords.remove(medicalRecord);
        }

    }

    @Override
    public Void getAll() {

        if(HelperUtils.isNull(medicalRecords)){
            return null;
        }
        medicalRecords.forEach(MedicalRecord::displayInfo);
        return null;
    }

    @Override
    public void search(String keyword) {

        boolean found = false;

        for (MedicalRecord m : medicalRecords) {

            if (
                    m.getRecordId().equals(keyword)||
                            m.getDiagnosis().equals(keyword)||
                            m.getPrescription().equals(keyword)||
                            m.getPatientId().equals(keyword)||
                            m.getDoctorId().equals(keyword)
            ) {

                m.displaySummary();
                found = true;
            }
        }

        if (!found) {
            System.out.println(Constants.RECORD_NOT_FOUND);
        }
    }

    @Override
    public void searchById(String id) {
        MedicalRecord medicalRecord = getRecordById(id);
        if(HelperUtils.isNotNull(medicalRecord)){
            medicalRecord.displayInfo();
        }

    }

    public void generatePatientHistoryReport(String patientId) {

        Patient patient = patientService.getPatientById(patientId);

        if (HelperUtils.isNull(patient)) {
            return;
        }

        System.out.println("PATIENT HISTORY REPORT");
        System.out.println("=======================");

        System.out.println("Patient ID: " + patient.getId());
        System.out.println("Name: " + patient.getFirstName() + " " + patient.getLastName());
        System.out.println("Blood Group: " + patient.getBloodGroup());

        System.out.println();
        System.out.println("MEDICAL RECORDS:");
        System.out.println("----------------------------------");

        boolean found = false;

        for (MedicalRecord record : medicalRecords) {
            if (record.getPatientId().equals(patientId)) {
                record.displaySummary();
                found = true;
            }
        }

        if (!found) {
            System.out.println(Constants.RECORD_NOT_FOUND);
        }
    }


    public void handleMedicalRecordMenu() {

        Boolean exit = true;

        while (exit) {

            System.out.println(MenuMessages.MEDICAL_RECORD_MENU_MESSAGE);

            int option = InputHandler.getIntInput(Constants.ENTER_OPTION, 0, 7);

            switch (option) {
                case 1->
                        addNewRecords();
                case 2->
                        getRecords();
                case 3->
                        getRecordsByPatientId(InputHandler.getStringInput("Enter Patient Id"));
                case 4->
                        getRecordsByDoctorId(InputHandler.getStringInput("Enter Doctor Id"));
                case 5->
                        updateMedicalRecord();
                case 6->
                        remove(InputHandler.getStringInput("Enter Patient Id"));
                case 7->
                        generatePatientHistoryReport(InputHandler.getStringInput("Enter Patient Id"));
                case 0->
                        exit = false;
            }
        }
    }

    @Override
    public void validate() {

    }
}