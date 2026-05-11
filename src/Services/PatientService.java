package Services;

import Entities.Appointment;
import Entities.MedicalRecord;
import Entities.Patient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatientService {

    Scanner scanner = new Scanner(System.in);

    static List<Patient> patients = new ArrayList<>();

    List<MedicalRecord> medicalRecords = new ArrayList<>();
    List<Appointment> appointments = new ArrayList<>();


    // Add Patient


    public Patient addPatient() {

        System.out.println("Add New Patient");

        System.out.print("Enter patient id: ");
        String id = scanner.nextLine();

        // check duplicate patient
        if (getPatientById(id) != null) {
            System.out.println("Patient already exists.");
            return null;
        }

        System.out.print("Enter patient first name: ");
        String patientFName = scanner.nextLine();

        System.out.print("Enter patient last name: ");
        String patientLName = scanner.nextLine();

        System.out.print("Enter patient DOB (YYYY-MM-DD): ");
        LocalDate DOB = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter patient gender: ");
        String gender = scanner.nextLine();

        System.out.print("Enter patient phone number: ");
        String phone = scanner.nextLine();

        System.out.print("Enter patient email: ");
        String email = scanner.nextLine();

        System.out.print("Enter patient address: ");
        String address = scanner.nextLine();

        System.out.print("Enter patient blood group: ");
        String bloodGroup = scanner.nextLine();

        System.out.print("Enter emergency contact: ");
        String emergencyContact = scanner.nextLine();

        System.out.print("Enter registration date (YYYY-MM-DD) or press Enter for today: ");

        String registrationInput = scanner.nextLine();

        LocalDate registrationDate;

        if (registrationInput.isEmpty()) {
            registrationDate = LocalDate.now();
        } else {
            registrationDate = LocalDate.parse(registrationInput);
        }

        System.out.print("Enter insurance id: ");
        String insuranceId = scanner.nextLine();

        List<String> allergies = new ArrayList<>();

        System.out.println("Enter patient allergies:");

        while (true) {

            String allergy = scanner.nextLine();

            allergies.add(allergy);

            System.out.println("Enter a to continue or q to stop");

            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("q")) {
                break;
            }
        }

        Patient patient = new Patient(
                id,
                patientFName,
                patientLName,
                DOB,
                gender,
                phone,
                email,
                address,
                id,
                bloodGroup,
                allergies,
                emergencyContact,
                registrationDate,
                medicalRecords,
                insuranceId,
                appointments
        );

        return patient;
    }



    public List<Patient> addPatients() {

        while (true) {

            Patient patient = addPatient();

            if (patient != null) {

                patients.add(patient);

                System.out.println("Patient added successfully.");
            }

            System.out.println("Enter a to continue or q to exit");

            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("q")) {
                break;
            }
        }

        return patients;
    }


    // Edit patient

    public void editPatient(String patientId) {

        Patient patient = getPatientById(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.println("UPDATE PATIENT ");

        System.out.print("Enter updated patient first name: ");
        patient.setFirstName(scanner.nextLine());

        System.out.print("Enter updated patient last name: ");
        patient.setLastName(scanner.nextLine());

        System.out.print("Enter updated patient DOB (YYYY-MM-DD): ");
        patient.setDateOfBirth(LocalDate.parse(scanner.nextLine()));

        System.out.print("Enter updated patient gender: ");
        patient.setGender(scanner.nextLine());

        System.out.print("Enter updated patient phone number: ");
        patient.setPhoneNumber(scanner.nextLine());

        System.out.print("Enter updated patient email: ");
        patient.setEmail(scanner.nextLine());

        System.out.print("Enter updated patient address: ");
        patient.setAddress(scanner.nextLine());

        System.out.print("Enter updated patient blood group: ");
        patient.setBloodGroup(scanner.nextLine());

        System.out.print("Enter updated emergency contact: ");
        patient.setEmergencyContact(scanner.nextLine());

        System.out.print("Enter updated registration date (YYYY-MM-DD): ");
        patient.setRegistrationDate(LocalDate.parse(scanner.nextLine()));

        System.out.print("Enter updated insurance id: ");
        patient.setInsuranceId(scanner.nextLine());

        // update allergies
        List<String> allergies = new ArrayList<>();

        System.out.println("Enter updated allergies:");

        while (true) {

            String allergy = scanner.nextLine();

            allergies.add(allergy);

            System.out.println("Enter a to continue or q to stop");

            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("q")) {
                break;
            }
        }

        patient.setAllergies(allergies);

        System.out.println("Patient updated successfully.");
    }



    // Remove Patient

    public void removePatient(String patientId) {

        boolean removed = patients.removeIf(patient -> patient.getPatientId().equals(patientId));

        if (removed) {
            System.out.println("Patient removed successfully.");
        } else {
            System.out.println("Patient not found.");
        }
    }


    // Get Patient by ID

    public Patient getPatientById(String patientId) {

        for (Patient patient : patients) {

            if (patient.getPatientId().equals(patientId)) {
                return patient;
            }
        }

        return null;
    }


    // Display all patients

    public void displayAllPatients() {

        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }

        System.out.println("ALL PATIENTS");

        for (Patient patient : patients) {

            patient.displayInfo();
        }
    }


    // =========================================
    // SEARCH PATIENT BY NAME
    // =========================================

    public void searchPatientsByName(String name) {

        boolean found = false;

        for (Patient patient : patients) {

            String fullName =
                    patient.getFirstName() + " " + patient.getLastName();

            if (fullName.toLowerCase().contains(name.toLowerCase())) {

                patient.displayInfo();

                found = true;
            }
        }

        if (!found) {
            System.out.println("No patients found with this name.");
        }
    }
}