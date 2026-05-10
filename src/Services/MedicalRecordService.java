package Services;

import java.util.ArrayList;
import java.util.List;


public class MedicalRecordService {
    private List<MedicalRecord> records = new ArrayList<>();

    // Add Record
    public void addRecord(MedicalRecord record) {
        records.add(record);
    }
    // Remove Record
    public void removeRecord(MedicalRecord record) {
        records.remove(record);
    }
    // Display All Records
    public void displayAllRecords() {

        for (MedicalRecord record : records) {
            record.displayInfo();
        }
    }
    // Get Records By Patient ID
    public List<MedicalRecord> getRecordsByPatientId(String patientId) {

        List<MedicalRecord> result = new ArrayList<>();

        for (MedicalRecord record : records) {

            if (record.getPatientId()
                    .equalsIgnoreCase(patientId)) {

                result.add(record);
            }
        }

        return result;
    }
    // Get Records By Doctor ID
    public List<MedicalRecord> getRecordsByDoctorId(String doctorId) {

        List<MedicalRecord> result = new ArrayList<>();

        for (MedicalRecord record : records) {

            if (record.getDoctorId()
                    .equalsIgnoreCase(doctorId)) {

                result.add(record);
            }
        }

        return result;
    }
}
