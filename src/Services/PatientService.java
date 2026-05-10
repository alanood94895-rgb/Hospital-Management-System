package Services;

import Entities.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientService {

    private static List<Patient> patients =
            new ArrayList<>();

    // Add Patient
    public void addPatient(Patient patient) {

        patients.add(patient);

        System.out.println("Patient Added Successfully");
    }

    // Edit Patient
    public void editPatient(String patientId, Patient updatedPatient) {

        for (int i = 0; i < patients.size(); i++) {

            if (patients.get(i).getPatientId().equals(patientId)) {

                patients.set(i, updatedPatient);

                System.out.println("Patient Updated Successfully");
                return;
            }
        }

        System.out.println("Patient Not Found");
    }

    // Remove Patient
    public void removePatient(String patientId) {

        boolean removed = patients.removeIf(patient -> patient.getPatientId().equals(patientId));

        if (removed) {
            System.out.println("Patient Removed Successfully");

        } else {

            System.out.println("Patient Not Found");
        }
    }

    // Get Patient By ID
    public Patient getPatientById(String patientId) {

        for (Patient patient : patients) {

            if (patient.getPatientId().equals(patientId)) {

                return patient;
            }
        }

        return null;
    }

    // Display All Patients
    public void displayAllPatients() {

        if (patients.isEmpty()) {

            System.out.println("No Patients Found");
            return;
        }

        System.out.println(" PATIENT LIST");

        for (Patient patient : patients) {

            patient.displayInfo();

            System.out.println(" ");
        }
    }

    // Search Patients By Name
    public List<Patient> searchPatientsByName(String name) {

        List<Patient> result = new ArrayList<>();

        for (Patient patient : patients) {

            String fullName = patient.getFirstName() + " " + patient.getLastName();

            if (fullName.toLowerCase().contains(name.toLowerCase())) {

                result.add(patient);
            }
        }

        return result;
    }
}