package Services;

import java.util.ArrayList;
import java.util.List;


public class MedicalRecordService {
    private List<MedicalRecord> records = new ArrayList<>();

    // Add Record
    public void addRecord(MedicalRecord record) {
        records.add(record);
    }

}
