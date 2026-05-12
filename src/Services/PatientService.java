package Services;

import Entities.Patient;
import Utils.Constants;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PatientService {

    static Scanner scanner = new Scanner(System.in);

    private List<Patient> patients = new ArrayList<>();

    // Add multiple patient

    public void addPatients() {

        patients.add(addPatient());

        System.out.println("Press q to quit or enter key to continue:");

        if (scanner.nextLine().equalsIgnoreCase("q")) {
            return;
        }

        addPatients();
    }

    // Add patient with full input

    public Patient addPatient() {

        System.out.println("Enter patient id:");
        String id = scanner.nextLine();

        System.out.println("Enter first name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter last name:");
        String lastName = scanner.nextLine();

        System.out.println("Enter gender:");
        String gender = scanner.nextLine();

        System.out.println("Enter phone number:");
        String phone = scanner.nextLine();

        System.out.println("Enter date of birth (yyyy-MM-dd):");
        String DOB = scanner.nextLine();

        LocalDate dateOfBirth = LocalDate.parse(DOB);

        System.out.println("Enter email:");
        String email = scanner.nextLine();

        System.out.println("Enter address:");
        String address = scanner.nextLine();

        System.out.println("Enter blood group:");
        String bloodGroup = scanner.nextLine();

        System.out.println("Enter emergency contact:");
        String emergencyContact = scanner.nextLine();

        System.out.println("Enter insurance ID:");
        String insuranceId = scanner.nextLine();

        System.out.println("Do you have allergies? (yes/no)");
        String hasAllergies = scanner.nextLine();

        List<String> allergies = new ArrayList<>();

        if (hasAllergies.equalsIgnoreCase("yes")) {

            System.out.println("Enter allergies separated by commas:");

            String allergiesInput = scanner.nextLine();

            allergies = Arrays.asList(allergiesInput.split(","));
        }

        Patient patient = new Patient(
                id,
                firstName,
                lastName,
                dateOfBirth,
                gender,
                phone,
                email,
                address,
                id,
                bloodGroup,
                emergencyContact,
                LocalDate.now(),
                insuranceId
        );

        System.out.println(Constants.PATIENT_ADDED_SUCCESSFULLY);

        return patient;
    }

    public void addPatient(String firstName,
                           String lastName,
                           String phone) {

        Patient patient = new Patient();

        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setPhoneNumber(phone);

        patients.add(patient);

        System.out.println("Patient added with minimal info.");
    }

    // Full info
    public void addPatient(String firstName,
                           String lastName,
                           String phone,
                           String bloodGroup,
                           String email) {

        Patient patient = new Patient();

        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setPhoneNumber(phone);
        patient.setBloodGroup(bloodGroup);
        patient.setEmail(email);

        patients.add(patient);

        System.out.println("Patient added with full info.");
    }

    // Full object
    public void addPatient(Patient patient) {

        patients.add(patient);

        System.out.println("Patient object added.");
    }


    // Update Patient

    public void updatePatient(String patientId,
                              Patient updatedPatient) {

        for (Patient p : patients) {

            if (p.getId().equals(patientId)) {

                p.setPhoneNumber(updatedPatient.getPhoneNumber());

                p.setEmail(updatedPatient.getEmail());

                p.setAddress(updatedPatient.getAddress());

                System.out.println(Constants.PATIENT_UPDATED_SUCCESSFULLY);

                return;
            }
        }

        System.out.println(Constants.PATIENT_NOT_FOUND);
    }

    // Remove Patient

    public void removePatient(String patientId) {

        for (Patient p : patients) {

            if (p.getId().equals(patientId)) {

                patients.remove(p);

                System.out.println(Constants.PATIENT_REMOVED_SUCCESSFULLY);

                return;
            }
        }

        System.out.println(Constants.PATIENT_NOT_FOUND);
    }

    // Get Patient By ID

    public void getPatientById(String patientId) {

        for (Patient p : patients) {

            if (p.getId().equals(patientId)) {

                p.displayInfo();

                return;
            }
        }

        System.out.println(Constants.PATIENT_NOT_FOUND);
    }


    //  searchPatients()
    public void searchPatients(String keyword) {

        for (Patient p : patients) {

            if (p.getFirstName().contains(keyword) || p.getLastName().contains(keyword)
                    || p.getPhoneNumber().contains(keyword)) {

                p.displayInfo();
            }
        }
    }


    // Search by first and last name
    public void searchPatients(String firstName, String lastName) {

        for (Patient p : patients) {

            if (p.getFirstName().equalsIgnoreCase(firstName) &&
                    p.getLastName().equalsIgnoreCase(lastName)) {

                p.displayInfo();
            }
        }
    }


    // Display all
    public void displayPatients() {

        for (Patient p : patients) {

            p.displayInfo();
        }
    }

    // Display filtered
    public void displayPatients(String filter) {

        System.out.println("Filtered By: " + filter);

        for (Patient p : patients) {

            if (p.getInsuranceId().equalsIgnoreCase(filter) ||
                    p.getBloodGroup().equalsIgnoreCase(filter) ||
                    p.getGender().equalsIgnoreCase(filter)) {

                p.displayInfo();
            }
        }
    }

    // Display limited number
    public void displayPatients(int limit) {

        for (int i = 0;
             i < limit && i < patients.size();
             i++) {

            patients.get(i).displayInfo();
        }
    }



    // Handle PatientsMenu

    public Boolean handlePatientsMenu(Integer patientOption) {

        switch (patientOption) {

            case 1 -> {

                addPatients();
            }

            case 2 -> {

                System.out.print(
                        "Enter Patient ID to edit: "
                );

                String id =
                        scanner.nextLine().trim();

                Patient updatedPatient =
                        addPatient();

                updatePatient(id, updatedPatient);
            }

            case 3 -> {

                System.out.print(
                        "Enter Patient ID to remove: "
                );

                String id =
                        scanner.nextLine().trim();

                removePatient(id);
            }

            case 4 -> {

                System.out.print(
                        "Enter name to search: "
                );

                String name =
                        scanner.nextLine().trim();

                searchPatients(name);
            }

            case 5 -> {

                displayPatients();
            }

            case 6 -> {

                return false;
            }

            default -> {

                System.out.println("Invalid option.");
            }
        }

        return true;
    }

}