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
}
