package Services;

import Entities.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientService {
    static List<Patient> patients = new ArrayList<>();

    public void addPatient(Patient patient) {
        patients.add(patient);
    }
    public void removePatient(String patientId) {

        patients.removeIf(
                patient -> patient.getPatientId().equals(patientId)
        );
    }
    public Patient getPatientById(String patientId) {

        for (Patient patient : patients) {

            if (patient.getPatientId().equals(patientId)) {
                return patient;
            }
        }
        return null;
    }

    public void displayAllPatients() {

        for (Patient patient : patients) {
            patient.displayInfo();
        }
    }
}




}
