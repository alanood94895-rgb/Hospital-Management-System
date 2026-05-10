package Services;

import java.util.ArrayList;
import java.util.List;

public class PatientService {
    static List<Patient> patients = new ArrayList<>();

    public void addPatient(Patient patient) {
        patients.add(patient);
    }


}
