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
import java.util.Scanner;

public class PatientService implements Manageable, Searchable, Editable {
    static Scanner scanner = new Scanner(System.in);

    static public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    private static List<Patient> patients = new ArrayList<>();

    public static void addPatients(Patient patient) {
        if (HelperUtils.isNull(patient)) { System.out.println("Cannot add null patient."); return; }
        for(Patient p : patients){
            if (p.getId().equals(patient.getId())) {
                System.out.println("Patient with ID " + patient.getId() + " already exists.");
                return;
            }
        }
        patients.add(patient);
        System.out.println(Constants.PATIENT_ADDED_SUCCESSFULLY);
    }
    public static Patient addPatient(){
        scanner.nextLine();

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

        System.out.println("Do have any allergies? (yes/no)");
        String hasAllergies = scanner.nextLine();

        List<String> allergies = new ArrayList<>();
        if(hasAllergies.equalsIgnoreCase("yes")){
            System.out.println("Enter allergies separated by commas:");
            String allergiesInput = scanner.nextLine();
            allergies.add(Arrays.toString(allergiesInput.split(",")));
        }

        Patient patient= new Patient(
                HelperUtils.generateId("P"),
                firstName,
                lastName,
                dateOfBirth,
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

        return patient;

    }
    public static void updatePatient( Patient updatedPatient){
        updatedPatient.setEmail(InputHandler.getStringInput("Enter new email: "));
        updatedPatient.setPhoneNumber(InputHandler.getStringInput("Enter new phone number: "));
        updatedPatient.setEmergencyContact(InputHandler.getStringInput("Enter Emergency Contact: "));
        updatedPatient.setAddress(InputHandler.getStringInput("Enter new address: "));
        System.out.println(Constants.PATIENT_UPDATED_SUCCESSFULLY);
    }
    public void removePatient(String patientId){
        for(Patient p : patients){
            if(p.getId().equals(patientId)){

                patients.remove(p);
                System.out.println(Constants.PATIENT_REMOVED_SUCCESSFULLY);
            }
        }
    }
    public static Patient  getPatientById(String patientId){
        Patient patient = new Patient();
        for(Patient p : patients){
            if(p.getId().equals(patientId)){
                patient= p;
            }else{
                System.out.println(Constants.PATIENT_NOT_FOUND);
                break;
            }
        }

        return patient;
    }

    public void searchPatientsByName(String name){
        for(Patient p : patients){
            if(p.getFirstName().equalsIgnoreCase(name) || p.getLastName().equalsIgnoreCase(name)){
                p.displayInfo();
            }
        }
    }


    public static void displayPatients(){
        if (HelperUtils.isNull(patients)) { System.out.println("No patients registered."); return; }
        for(Patient p : patients){
            p.displayInfo();
        }
    }

    public void displayPatients(String filter){
        for(Patient p : patients) {
            System.out.println("Filtered By "+ filter);
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

    public void displayPatients(int limit){
        while (limit!=0){
            for(Patient p : patients){
                p.displayInfo();
                limit--;
            }
        }
    }



    public void addPatient(String firstName, String lastName, String phone){

        Patient patient = new Patient();

        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setPhoneNumber(phone);

        patients.add(patient);

    }

    public void addPatient(String firstName, String lastName, String phone , String bloodGroup, String email){
        Patient patient = new Patient();

        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setPhoneNumber(phone);
        patient.setPhoneNumber(bloodGroup);
        patient.setPhoneNumber(email);

        patients.add(patient);

    }
    public static void searchPatients(String keyword) {
        if (HelperUtils.isNull(patients)) {
            System.out.println("No patients registered.");
            return;}
        for (Patient patient : patients) {

            if (patient.getFirstName().equalsIgnoreCase(keyword)
                    || patient.getLastName().equalsIgnoreCase(keyword)
                    || patient.getPhoneNumber().equalsIgnoreCase(keyword)
                    || patient.getBloodGroup().equalsIgnoreCase(keyword)
                    || patient.getEmail().equalsIgnoreCase(keyword)
                    || patient.getId().equals(keyword)) {

                patient.displayInfo();
                return;
            }
        }
        System.out.println(Constants.PATIENT_NOT_FOUND);
    }

    public void searchPatients(String firstName, String lastName){
        for(Patient p : patients){
            if(p.getFirstName().equals(firstName) && p.getLastName().equals(lastName)){
                p.displayInfo();
                return;
            }
        }
        System.out.println(Constants.PATIENT_NOT_FOUND);

    }

    public void displayPatientHistory(String patientId) {
        Patient p = getPatientById(patientId);
        if (HelperUtils.isNull(p)) { System.out.println(Constants.PATIENT_NOT_FOUND); return; }
        if (p.getMedicalRecords().isEmpty()) {
            System.out.println("No medical records.");
        } else {
            for(MedicalRecord m :p.getMedicalRecords()){
                m.displayInfo();
            }
        }
    }




    @Override
    public void add(Object entity) {

    }
    @Override
    public void remove(String id) {

        Patient p = getPatientById(id);
        if (HelperUtils.isNull(p)) { System.out.println(Constants.PATIENT_NOT_FOUND); return; }
        patients.remove(p);
        System.out.println(Constants.PATIENT_REMOVED_SUCCESSFULLY);


    }

    @Override
    public Void getAll() {
        if (!HelperUtils.isNull(patients)) {
            patients.forEach(p -> p.displayInfo());

        }else {
            System.out.println("No patients");
        }
        return null;
    }

    @Override
    public void search(String keyword) {
        if (HelperUtils.isNull(patients)) {
            System.out.println("No patients registered.");
            return;}
        for (Patient patient : patients) {

            if (patient.getFirstName().equalsIgnoreCase(keyword)
                    || patient.getLastName().equalsIgnoreCase(keyword)
                    || patient.getPhoneNumber().equalsIgnoreCase(keyword)
                    || patient.getBloodGroup().equalsIgnoreCase(keyword)
                    || patient.getEmail().equalsIgnoreCase(keyword)
                    || patient.getId().equals(keyword)) {

                patient.displayInfo();
                return;
            }
        }
        System.out.println(Constants.PATIENT_NOT_FOUND);

    }

    @Override
    public void searchById(String id) {
        if (HelperUtils.isNull(patients)) {
            System.out.println("No patients registered.");
            return;}
        for (Patient patient : patients) {

            if (patient.getId().equals(id)) {
                patient.displayInfo();
                return;
            }
        }
        System.out.println(Constants.PATIENT_NOT_FOUND);




    }


    private static void registerPatient() {
        String id    = HelperUtils.generateId("P",4);
        String firstName    = InputHandler.getStringInput("First Name: ");
        String lastName    = InputHandler.getStringInput("Last Name: ");
        LocalDate DOB = InputHandler.getDateInput("Date of Birth: ");
        String gender = InputHandler.getStringInput("Gender: ");
        String phone  = InputHandler.getStringInput("Phone: ");
        String email  = InputHandler.getStringInput("Email: ");
        String address   = InputHandler.getStringInput("Address: ");
        String bloodGroup  = InputHandler.getStringInput("Blood Group: ");
        String emergencyContact     = InputHandler.getStringInput("Emergency Contact: ");
        String insuranceId    = InputHandler.getStringInput("Insurance ID: ");
        Boolean hasAllergies = InputHandler.getConfirmation("Do have any allergies? ");
        List<String> allergies = new ArrayList<>();
        if(hasAllergies){
            System.out.println("Enter allergies separated by commas:");
            String allergiesInput = scanner.nextLine();
            allergies.add(Arrays.toString(allergiesInput.split(",")));
        }
        Patient p = new Patient(id, firstName, lastName, DOB, gender, phone, email,address,
                bloodGroup, emergencyContact,LocalDate.now(),insuranceId,allergies);
        addPatients(p);
    }

    private static void registerInPatient() {
        String id     = HelperUtils.generateId("InP",4);
        String firstName    = InputHandler.getStringInput("First Name: ");
        String lastName    = InputHandler.getStringInput("Last Name: ");
        LocalDate DOB = InputHandler.getDateInput("Date of Birth: ");
        String gender = InputHandler.getStringInput("Gender: ");
        String phone  = InputHandler.getStringInput("Phone: ");
        String email  = InputHandler.getStringInput("Email: ");
        String address   = InputHandler.getStringInput("Address: ");
        String bloodGroup  = InputHandler.getStringInput("Blood Group: ");
        String emergencyContact     = InputHandler.getStringInput("Emergency Contact: ");
        String insuranceId    = InputHandler.getStringInput("Insurance ID: ");
        Boolean hasAllergies = InputHandler.getConfirmation("Do have any allergies? ");
        List<String> allergies = new ArrayList<>();
        if(hasAllergies){
            System.out.println("Enter allergies separated by commas:");
            String allergiesInput = scanner.nextLine();
            allergies.add(Arrays.toString(allergiesInput.split(",")));
        }
        String room   = InputHandler.getStringInput(" Room Number: ");
        String bed    = InputHandler.getStringInput(" Bed Number: ");
        String drId   = InputHandler.getStringInput("Admitting Doctor ID: ");
        double daily  = InputHandler.getDoubleInput("Daily Charges : ");
        InPatient inPatient  = new InPatient(id, firstName, lastName, DOB, gender, phone, email, address,
                bloodGroup,emergencyContact,LocalDate.now(),insuranceId,allergies,
                LocalDate.now(),null,room, bed, drId, daily);
        addPatients(inPatient);
    }

    private static void registerOutPatient() {
        String id     = HelperUtils.generateId("OutP",4);
        String firstName    = InputHandler.getStringInput("First Name: ");
        String lastName    = InputHandler.getStringInput("Last Name: ");
        LocalDate DOB = InputHandler.getDateInput("Date of Birth: ");
        String gender = InputHandler.getStringInput("Gender: ");
        String phone  = InputHandler.getStringInput("Phone: ");
        String email  = InputHandler.getStringInput("Email: ");
        String address   = InputHandler.getStringInput("Address: ");
        String bloodGroup  = InputHandler.getStringInput("Blood Group: ");
        String emergencyContact     = InputHandler.getStringInput("Emergency Contact: ");
        String insuranceId    = InputHandler.getStringInput("Insurance ID: ");
        Boolean hasAllergies = InputHandler.getConfirmation("Do have any allergies? ");
        List<String> allergies = new ArrayList<>();
        if(hasAllergies){
            System.out.println("Enter allergies separated by commas:");
            String allergiesInput = scanner.nextLine();
            allergies.add(Arrays.toString(allergiesInput.split(",")));
        }
        String prefDr = InputHandler.getStringInput(" Preferred Doctor ID: ");
        OutPatient outPatient = new OutPatient(id, firstName, lastName, DOB, gender, phone, email, address,
                bloodGroup,emergencyContact,LocalDate.now(),insuranceId,allergies,null, null,
                prefDr);
        addPatients(outPatient);
    }

    private static void registerEmergencyPatient() {

        String id = HelperUtils.generateId("EmergP");

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
            String allergiesInput = scanner.nextLine();

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
                id,
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

    private static void updatePatient() {
        String id = InputHandler.getStringInput("Patient ID to update: ");
        Patient existing = getPatientById(id);
        if (HelperUtils.isNull(existing)) { System.out.println(Constants.PATIENT_NOT_FOUND); return; }
        updatePatient(existing);
    }


    public void handlePatientMenu(){
        Boolean patientExit = true;
        while (patientExit) {
            System.out.println(MenuMessages.PATIENT_MENU_MESSAGE);
            int option = InputHandler.getIntInput(Constants.ENTER_OPTION,0,9);
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
                case 4->{
                    registerEmergencyPatient();
                }
                case 5->{
                    getAll();
                }
                case 6->{
                    String key = InputHandler.getStringInput("Search keyword: ");
                    search(key);
                }
                case 7->{
                    updatePatient();
                }
                case 8->{
                    String patientId = InputHandler.getStringInput("Enter patient Id: ");
                    remove(patientId);
                }
                case 9->{
                    String patientId = InputHandler.getStringInput("Enter patient Id: ");
                    displayPatientHistory(patientId);
                }
                case 0 ->{
                    patientExit = false;
                }

            }

        }

    }


    @Override
    public void edit(Object updatedData) {


    }

    @Override
    public void validate() {

    }
}