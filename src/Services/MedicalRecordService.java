package Services;

import Entities.MedicalRecord;

import java.util.ArrayList;
import java.util.List;


public class MedicalRecordService {
    // List To Store Medical Records
    private List<MedicalRecord> records =
            new ArrayList<>();

    // Add Record (Create)
    public void addRecord(MedicalRecord record) {

        records.add(record);

        System.out.println(
                "Medical Record Added Successfully"
        );
    }

    // Edit Record (Update)
    public void editRecord(String recordId,
                           MedicalRecord updatedRecord) {

        for (int i = 0; i < records.size(); i++) {

            if (records.get(i)
                    .getRecordId()
                    .equals(recordId)) {

                records.set(i, updatedRecord);

                System.out.println(
                        "Record Updated Successfully"
                );

                return;
            }
        }

        System.out.println("Record Not Found");
    }

    // Remove Record (Delete)
    public void removeRecord(String recordId) {

        boolean removed = records.removeIf(
                record ->
                        record.getRecordId()
                                .equals(recordId)
        );

        if (removed) {

            System.out.println(
                    "Record Removed Successfully"
            );

        } else {

            System.out.println("Record Not Found");
        }
    }

    // Get Record By ID
    public MedicalRecord getRecordById(String recordId) {

        for (MedicalRecord record : records) {

            if (record.getRecordId()
                    .equals(recordId)) {

                return record;
            }
        }

        return null;
    }

    // Get Records By Patient ID
    public List<MedicalRecord> getRecordsByPatientId(
            String patientId) {

        List<MedicalRecord> result =
                new ArrayList<>();

        for (MedicalRecord record : records) {

            if (record.getPatientId()
                    .equalsIgnoreCase(patientId)) {

                result.add(record);
            }
        }

        return result;
    }

    // Get Records By Doctor ID
    public List<MedicalRecord> getRecordsByDoctorId(
            String doctorId) {

        List<MedicalRecord> result =
                new ArrayList<>();

        for (MedicalRecord record : records) {

            if (record.getDoctorId()
                    .equalsIgnoreCase(doctorId)) {

                result.add(record);
            }
        }

        return result;
    }

    // Display Patient History
    public void displayPatientHistory(String patientId) {

        List<MedicalRecord> patientRecords =
                getRecordsByPatientId(patientId);

        System.out.println(
                "===== PATIENT MEDICAL HISTORY ====="
        );

        if (patientRecords.isEmpty()) {

            System.out.println("No Records Found");
            return;
        }

        for (MedicalRecord record : patientRecords) {

            record.displayInfo();

            System.out.println(
                    "----------------------"
            );
        }
    }
}