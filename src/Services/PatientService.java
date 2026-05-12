package Services;

import Behaviour.Manageable;
import Behaviour.Searchable;
import Entities.Patient;
import Utils.Constants;
import Utils.HelperUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PatientService implements Manageable, Searchable {

    static Scanner scanner = new Scanner(System.in);
    private static List<Patient> patients = new ArrayList<>();

    // GET ALL PATIENTS
    public static List<Patient> getPatients() {
        return patients;
    }

    // ADD PATIENT
    public static void addPatients(Patient patient) {
        patients.add(patient);
        System.out.println(Constants.PATIENT_ADDED_SUCCESSFULLY);
    }

    // CREATE PATIENT OBJECT
    public static Patient addPatient() {

        System.out.println("Enter first name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter last name:");
        String lastName = scanner.nextLine();

        System.out.println("Enter gender:");
        String gender = scanner.nextLine();

        System.out.println("Enter phone number:");
        String phone = scanner.nextLine();

        System.out.println("Enter DOB (yyyy-MM-dd):");
        LocalDate dob = LocalDate.parse(scanner.nextLine());

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

        System.out.println("Any allergies? (yes/no)");
        List<String> allergies = new ArrayList<>();

        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            System.out.println("Enter allergies comma separated:");
            allergies = Arrays.asList(scanner.nextLine().split(","));
        }

        return new Patient(
                HelperUtils.generateId("P"),
                firstName,
                lastName,
                dob,
                gender,
                phone,
                email,
                address,
                bloodGroup,
                emergencyContact,
                LocalDate.now(),
                insuranceId,
                allergies
        );
    }

    // UPDATE
    public void updatePatient(String id, Patient updated) {
        for (Patient p : patients) {
            if (p.getId().equals(id)) {
                p.setPhoneNumber(updated.getPhoneNumber());
                p.setEmail(updated.getEmail());
                p.setAddress(updated.getAddress());

                System.out.println(Constants.PATIENT_UPDATED_SUCCESSFULLY);
                return;
            }
        }
        System.out.println(Constants.PATIENT_NOT_FOUND);
    }

    // REMOVE
    public void removePatient(String id) {
        patients.removeIf(p -> p.getId().equals(id));
        System.out.println(Constants.PATIENT_REMOVED_SUCCESSFULLY);
    }

    // SEARCH BY NAME
    public void searchPatients(String name) {
        for (Patient p : patients) {
            if (p.getFirstName().equalsIgnoreCase(name)
                    || p.getLastName().equalsIgnoreCase(name)) {
                p.displayInfo();
            }
        }
    }

    // DISPLAY ALL
    public void displayPatients() {
        for (Patient p : patients) {
            p.displayInfo();
        }
    }

    // MENU HANDLER (FIXED)
    public Boolean handlePatientsMenu(Integer option) {

        switch (option) {

            case 1 -> {
                Patient p = addPatient();
                addPatients(p);
            }

            case 2 -> {
                System.out.print("Enter Patient ID to edit: ");
                String id = scanner.nextLine();

                Patient updated = addPatient();
                updatePatient(id, updated);
            }

            case 3 -> {
                System.out.print("Enter Patient ID to remove: ");
                removePatient(scanner.nextLine());
            }

            case 4 -> {
                System.out.print("Enter name: ");
                searchPatients(scanner.nextLine());
            }

            case 5 -> displayPatients();

            case 6 -> {
                return false;
            }

            default -> System.out.println("Invalid option");
        }

        return true;
    }

    // INTERFACE METHODS (EMPTY FOR NOW)
    @Override public void add(Object entity) {

    }
    @Override public void remove(String id) {

    }
    @Override public Void getAll() {
        return null; }
    @Override public void search(String keyword) {

    }
    @Override public void searchById(String id) {

    }
}