package Services;

import Behaviour.Editable;
import Behaviour.Manageable;
import Behaviour.Searchable;

import Entities.MedicalRecord;
import Entities.EmergencyPatient;
import Entities.InPatient;
import Entities.OutPatient;
import Entities.Patient;

import Utils.Constants;
import Utils.HelperUtils;
import Utils.InputHandler;
import Utils.MenuMessages;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PatientService implements Manageable, Searchable, Editable {

    private static List<Patient> patients = new ArrayList<>();



    // ADD PATIENTS

    public static void addPatients(Patient patient) {

        if (HelperUtils.isNull(patient)) {
            System.out.println("Cannot add null patient.");
            return;
        }

        for (Patient p : patients) {

            if (p.getId().equals(patient.getId())) {
                System.out.println("Patient with ID " + patient.getId() + " already exists.");
                return;
            }
        }

        patients.add(patient);
        System.out.println(Constants.PATIENT_ADDED_SUCCESSFULLY);
    }


    // REGISTER NORMAL PATIENT

    private static void registerPatient() {

        String firstName = InputHandler.getStringInput("First Name: ");
        String lastName = InputHandler.getStringInput("Last Name: ");

        LocalDate DOB = InputHandler.getDateInput("Date of Birth: ");
        String gender = InputHandler.getStringInput("Gender: ");

        String phone = InputHandler.getStringInput("Phone: ");
        String email = InputHandler.getStringInput("Email: ");
        String address = InputHandler.getStringInput("Address: ");

        String bloodGroup = InputHandler.getStringInput("Blood Group: ");
        String emergencyContact = InputHandler.getStringInput("Emergency Contact: ");
        String insuranceId = InputHandler.getStringInput("Insurance ID: ");

        Boolean hasAllergies = InputHandler.getConfirmation("Do have any allergies? ");

        List<String> allergies = new ArrayList<>();

        if (hasAllergies) {

            String allergiesInput = InputHandler.getStringInput("Enter allergies separated by commas: ");
            allergies.add(Arrays.toString(allergiesInput.split(",")));
        }

        Patient p = new Patient(
                HelperUtils.generateId("P", 3),
                firstName,
                lastName,
                DOB,
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

        addPatients(p);
    }


    // REGISTER IN PATIENT


    private static void registerInPatient() {

        String firstName = InputHandler.getStringInput("First Name: ");
        String lastName = InputHandler.getStringInput("Last Name: ");

        LocalDate DOB = InputHandler.getDateInput("Date of Birth: ");
        String gender = InputHandler.getStringInput("Gender: ");

        String phone = InputHandler.getStringInput("Phone: ");
        String email = InputHandler.getStringInput("Email: ");
        String address = InputHandler.getStringInput("Address: ");

        String bloodGroup = InputHandler.getStringInput("Blood Group: ");
        String emergencyContact = InputHandler.getStringInput("Emergency Contact: ");
        String insuranceId = InputHandler.getStringInput("Insurance ID: ");

        Boolean hasAllergies = InputHandler.getConfirmation("Do have any allergies? ");

        List<String> allergies = new ArrayList<>();

        if (hasAllergies) {

            System.out.println("Enter allergies separated by commas:");
            String allergiesInput = InputHandler.getStringInput("Enter allergies separated by commas: ");

            allergies.add(Arrays.toString(allergiesInput.split(",")));
        }

        String room = InputHandler.getStringInput(" Room Number: ");
        String bed = InputHandler.getStringInput(" Bed Number: ");

        String drId = InputHandler.getStringInput("Admitting Doctor ID: ");
        double daily = InputHandler.getDoubleInput("Daily Charges : ");

        InPatient inPatient = new InPatient(
                HelperUtils.generateId("InP", 3),
                firstName,
                lastName,
                DOB,
                gender,
                phone,
                email,
                address,
                bloodGroup,
                emergencyContact,
                LocalDate.now(),
                insuranceId,
                allergies,
                LocalDate.now(),
                null,
                room,
                bed,
                drId,
                daily
        );

        addPatients(inPatient);
    }



    // REGISTER OUT PATIENT


    private static void registerOutPatient() {

        String firstName = InputHandler.getStringInput("First Name: ");
        String lastName = InputHandler.getStringInput("Last Name: ");

        LocalDate DOB = InputHandler.getDateInput("Date of Birth: ");
        String gender = InputHandler.getStringInput("Gender: ");

        String phone = InputHandler.getStringInput("Phone: ");
        String email = InputHandler.getStringInput("Email: ");

        String address = InputHandler.getStringInput("Address: ");
        String bloodGroup = InputHandler.getStringInput("Blood Group: ");

        String emergencyContact = InputHandler.getStringInput("Emergency Contact: ");
        String insuranceId = InputHandler.getStringInput("Insurance ID: ");

        Boolean hasAllergies = InputHandler.getConfirmation("Do have any allergies? ");

        List<String> allergies = new ArrayList<>();

        if (hasAllergies) {

            System.out.println("Enter allergies separated by commas:");
            String allergiesInput = InputHandler.getStringInput("Enter allergies separated by commas: ");

            allergies.add(Arrays.toString(allergiesInput.split(",")));
        }

        String prefDr = InputHandler.getStringInput(" Preferred Doctor ID: ");

        OutPatient outPatient = new OutPatient(
                HelperUtils.generateId("OUTP", 3),
                firstName,
                lastName,
                DOB,
                gender,
                phone,
                email,
                address,
                bloodGroup,
                emergencyContact,
                LocalDate.now(),
                insuranceId,
                allergies,
                null,
                null,
                prefDr
        );

        addPatients(outPatient);
    }



    // REGISTER EMERGENCY PATIENT

    private static void registerEmergencyPatient() {

        String firstName = InputHandler.getStringInput("First Name: ");
        String lastName = InputHandler.getStringInput("Last Name: ");

        LocalDate DOB = InputHandler.getDateInput("Date of Birth: ");
        String gender = InputHandler.getStringInput("Gender: ");

        String phone = InputHandler.getStringInput("Phone: ");
        String email = InputHandler.getStringInput("Email: ");

        String address = InputHandler.getStringInput("Address: ");
        String bloodGroup = InputHandler.getStringInput("Blood Group: ");

        String emergencyContact = InputHandler.getStringInput("Emergency Contact: ");
        String insuranceId = InputHandler.getStringInput("Insurance ID: ");

        Boolean hasAllergies = InputHandler.getConfirmation("Do you have any allergies? ");

        List<String> allergies = new ArrayList<>();

        if (hasAllergies) {

            System.out.println("Enter allergies separated by commas:");

            String allergiesInput = InputHandler.getStringInput("Enter allergies separated by commas: ");
            allergies = Arrays.asList(allergiesInput.split(","));
        }

        String room = InputHandler.getStringInput("Room Number: ");
        String bed = InputHandler.getStringInput("Bed Number: ");

        String drId = InputHandler.getStringInput("Admitting Doctor ID: ");

        String eType = InputHandler.getStringInput("Emergency Type: ");
        String mode = InputHandler.getStringInput("Arrival Mode: ");

        int triage = InputHandler.getIntInput("Triage Level (1-5): ", 1, 5);

        Boolean admittedViaER = InputHandler.getConfirmation("Admitted via ER? ");

        EmergencyPatient emergencyPatient = new EmergencyPatient(
                HelperUtils.generateId("EmergP", 4),
                firstName,
                lastName,
                DOB,
                gender,
                phone,
                email,
                address,
                bloodGroup,
                emergencyContact,
                LocalDate.now(),
                insuranceId,
                allergies,
                LocalDate.now(),
                null,
                room,
                bed,
                drId,
                7.0,
                eType,
                mode,
                triage,
                admittedViaER
        );

        addPatients(emergencyPatient);
    }



    // OVERLOADED METHODS


    public void addPatient(String firstName, String lastName, String phone) {

        Patient patient = new Patient();

        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setPhoneNumber(phone);

        patients.add(patient);
    }

    public void addPatient(String firstName, String lastName, String phone, String bloodGroup, String email) {

        Patient patient = new Patient();

        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setPhoneNumber(phone);
        patient.setPhoneNumber(bloodGroup);
        patient.setPhoneNumber(email);

        patients.add(patient);
    }



    // GET PATIENT


    public Patient getPatientById(String patientId) {

        for (Patient p : patients) {

            if (p.getId().equals(patientId)) {
                return p;
            }
        }

        System.out.println(Constants.PATIENT_NOT_FOUND);
        return null;
    }



    // SEARCH METHODS


    public void searchPatientsByName(String name) {

        for (Patient p : patients) {

            if (
                    p.getFirstName().equalsIgnoreCase(name)
                            || p.getLastName().equalsIgnoreCase(name)
            ) {

                p.displayInfo();
            }
        }
    }

    public void searchPatients(String firstName, String lastName) {

        for (Patient p : patients) {

            if (
                    p.getFirstName().equals(firstName)
                            && p.getLastName().equals(lastName)
            ) {

                p.displayInfo();
                return;
            }
        }

        System.out.println(Constants.PATIENT_NOT_FOUND);
    }



    // DISPLAY METHODS


    public static void displayPatients() {

        if (HelperUtils.isNull(patients)) {

            System.out.println("No patients registered.");
            return;
        }

        for (Patient p : patients) {
            p.displayInfo();
        }
    }

    public void displayPatients(String filter) {

        for (Patient p : patients) {

            System.out.println("Filtered By " + filter);

            if (p.getInsuranceId().equals(filter)) {
                System.out.println();
            }

            if (p.getBloodGroup().equals(filter)) {
                System.out.println();
            }

            if (p.getGender().equals(filter)) {
                System.out.println();
            }

            if (p.getRegistrationDate().equals(filter)) {
                System.out.println();
            }
        }
    }

    public void displayPatients(int limit) {

        while (limit != 0) {

            for (Patient p : patients) {

                p.displayInfo();
                limit--;
            }
        }
    }



    // MEDICAL HISTORY

    public void displayPatientHistory(String patientId) {

        Patient p = getPatientById(patientId);

        if (HelperUtils.isNull(p)) {

            System.out.println(Constants.PATIENT_NOT_FOUND);
            return;
        }

        if (p.getMedicalRecords().isEmpty()) {

            System.out.println("No medical records.");
        }
        else {

            for (MedicalRecord m : p.getMedicalRecords()) {
                m.displayInfo();
            }
        }
    }



    // UPDATE PATIENT

    public void updatePatient() {

        String patientId = InputHandler.getStringInput("Enter patient ID: ");

        Patient existingPatient = getPatientById(patientId);

        if (HelperUtils.isNull(existingPatient)) {
            return;
        }

        String phone = InputHandler.getStringInput("Enter new phone number: ");
        String email = InputHandler.getStringInput("Enter new email: ");
        String address = InputHandler.getStringInput("Enter new address: ");
        String emergencyContact = InputHandler.getStringInput("Enter new emergency contact: ");
        String insuranceId = InputHandler.getStringInput("Enter new insurance ID: ");

        Patient updatedPatient = new Patient();

        updatedPatient.setId(patientId);
        updatedPatient.setPhoneNumber(phone);
        updatedPatient.setEmail(email);
        updatedPatient.setAddress(address);
        updatedPatient.setEmergencyContact(emergencyContact);
        updatedPatient.setInsuranceId(insuranceId);

        edit(updatedPatient);
    }



    // MANAGEABLE METHODS


    @Override
    public void add(Object entity) {

        Patient patient = (Patient) entity;

        for (Patient p : patients) {

            if (p.getId().equals(patient.getId())) {
                return;
            }
        }

        patients.add(patient);
    }

    @Override
    public void remove(String id) {

        Patient p = getPatientById(id);

        if (HelperUtils.isNull(p)) {

            System.out.println(Constants.PATIENT_NOT_FOUND);
            return;
        }

        patients.remove(p);

        System.out.println(Constants.PATIENT_REMOVED_SUCCESSFULLY);
    }

    @Override
    public Void getAll() {

        if (!HelperUtils.isNull(patients)) {

            patients.forEach(p -> p.displayInfo());
        }
        else {

            System.out.println("No patients");
        }
        return null;
    }



    // SEARCHABLE METHODS

    @Override
    public void search(String keyword) {

        boolean found = false;

        for (Patient p : patients) {

            if (

                    p.getId().equalsIgnoreCase(keyword)
                            || p.getFirstName().equalsIgnoreCase(keyword)
                            || p.getLastName().equalsIgnoreCase(keyword)
                            || p.getGender().equalsIgnoreCase(keyword)
                            || p.getPhoneNumber().equalsIgnoreCase(keyword)
                            || p.getEmail().equalsIgnoreCase(keyword)
                            || p.getAddress().equalsIgnoreCase(keyword)
                            || p.getBloodGroup().equalsIgnoreCase(keyword)
                            || p.getEmergencyContact().equalsIgnoreCase(keyword)
                            || p.getInsuranceId().equalsIgnoreCase(keyword)
                            || p.getDateOfBirth().toString().equalsIgnoreCase(keyword)
                            || p.getRegistrationDate().toString().equalsIgnoreCase(keyword)

            ) {

                p.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println(Constants.PATIENT_NOT_FOUND);
        }
    }

    @Override
    public void searchById(String id) {

        if (HelperUtils.isNull(patients)) {

            System.out.println("No patients registered.");
            return;
        }

        for (Patient patient : patients) {

            if (patient.getId().equalsIgnoreCase(id)) {

                patient.displayInfo();
                return;
            }
        }

        System.out.println(Constants.PATIENT_NOT_FOUND);
    }



    // EDITABLE METHODS


    @Override
    public void edit(Object updatedData) {

        if (!(updatedData instanceof Patient)) {

            System.out.println("Invalid patient data");
            return;
        }

        Patient updatedPatient = (Patient) updatedData;

        for (Patient p : patients) {

            if (p.getId().equals(updatedPatient.getId())) {

                p.setPhoneNumber(updatedPatient.getPhoneNumber());
                p.setEmail(updatedPatient.getEmail());
                p.setAddress(updatedPatient.getAddress());
                p.setEmergencyContact(updatedPatient.getEmergencyContact());
                p.setInsuranceId(updatedPatient.getInsuranceId());

                System.out.println(Constants.PATIENT_UPDATED_SUCCESSFULLY);
                return;
            }
        }

        System.out.println(Constants.PATIENT_NOT_FOUND);
    }

    @Override
    public void validate() {

    }



    // MENU HANDLER

    public void handlePatientMenu() {

        Boolean patientExit = true;

        while (patientExit) {

            System.out.println(MenuMessages.PATIENT_MENU_MESSAGE);

            int option = InputHandler.getIntInput(Constants.ENTER_OPTION, 0, 9);

            switch (option) {

                case 1 -> {
                    registerPatient();
                }

                case 2 -> {
                    registerInPatient();
                }

                case 3 -> {
                    registerOutPatient();
                }

                case 4 -> {
                    registerEmergencyPatient();
                }

                case 5 -> {
                    getAll();
                }

                case 6 -> {

                    String key = InputHandler.getStringInput("Search keyword: ");
                    search(key);
                }

                case 7 -> {
                    updatePatient();
                }

                case 8 -> {

                    String patientId = InputHandler.getStringInput("Enter patient Id: ");
                    remove(patientId);
                }

                case 9 -> {

                    String patientId = InputHandler.getStringInput("Enter patient Id: ");
                    displayPatientHistory(patientId);
                }

                case 0 -> {
                    patientExit = false;
                }
            }
        }
    }
}