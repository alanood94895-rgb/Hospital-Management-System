package Services;

import Behaviour.Manageable;
import Behaviour.Searchable;
import Entities.Consultant;
import Entities.Doctor;
import Entities.GeneralPractitioner;
import Entities.Surgeon;
import Entities.Patient;
import Utils.Constants;
import Utils.HelperUtils;
import Utils.InputHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorService implements Manageable, Searchable {
    static Scanner scanner = new Scanner(System.in);
    private List<Doctor> doctors = new ArrayList<>();


    public void addDoctor(Doctor doctor) {
        if (HelperUtils.isNull(doctor)) { System.out.println("  [!] Cannot add null doctor."); return; }
        if (HelperUtils.isNotNull(getDoctorById(doctor.getId()))){
            System.out.println("Doctor with ID " + doctor.getId() + " already exists."); return;
        }
        doctors.add(doctor);
        System.out.println(Constants.DOCTOR_ADDED_SUCCESSFULLY);

    }

    private Doctor addDoctor() {

        String id    = HelperUtils.generateId("DOC-",4);
        String firstName    = InputHandler.getStringInput("First Name: ");
        String lastName    = InputHandler.getStringInput("Last Name: ");
        LocalDate dob = InputHandler.getDateInput("Date of Birth");
        String gender = InputHandler.getStringInput("Gender: ");
        String phone  = InputHandler.getStringInput("Phone: ");
        String email  = InputHandler.getStringInput("Email: ");
        String address  = InputHandler.getStringInput("Address: ");
        String specialization   = InputHandler.getStringInput("Specialization: ");
        String qualification   = InputHandler.getStringInput("Qualification: ");
        int    experience    = InputHandler.getIntInput("Experience (years): ", 0, 60);
        String deptId   = InputHandler.getStringInput("Department ID: ");
        double fee    = InputHandler.getDoubleInput("Consultation Fee: ");
        Doctor d = new Doctor(id, firstName, lastName, dob, gender, phone, email, address,
                specialization, qualification, experience, deptId, fee);
        add(d);
        return d;
    }

    private void addSurgeon() {
        String id    = HelperUtils.generateId("Surg-",4);
        String firstName    = InputHandler.getStringInput("First Name: ");
        String lastName    = InputHandler.getStringInput("Last Name: ");
        LocalDate dob = InputHandler.getDateInput("Date of Birth");
        String gender = InputHandler.getStringInput("Gender: ");
        String phone  = InputHandler.getStringInput("Phone: ");
        String email  = InputHandler.getStringInput("Email: ");
        String address  = InputHandler.getStringInput("Address: ");
        String specialization   = InputHandler.getStringInput("Specialization: ");
        String qualification   = InputHandler.getStringInput("Qualification: ");
        int    experience    = InputHandler.getIntInput("Experience (years): ", 0, 60);
        String deptId   = InputHandler.getStringInput("Department ID: ");
        double fee    = InputHandler.getDoubleInput("Consultation Fee: ");
        boolean  operationTheatreAccess   = InputHandler.getConfirmation("Operation Theatre Access ?");
        Surgeon s = new Surgeon(id, firstName, lastName, dob, gender, phone, email, address,
                specialization, qualification, experience, deptId, fee, null, operationTheatreAccess);
        add(s);
    }


    private void addConsultant() {
        String id    = HelperUtils.generateId("Cons-",4);
        String firstName    = InputHandler.getStringInput("First Name: ");
        String lastName    = InputHandler.getStringInput("Last Name: ");
        LocalDate dob = InputHandler.getDateInput("Date of Birth");
        String gender = InputHandler.getStringInput("Gender: ");
        String phone  = InputHandler.getStringInput("Phone: ");
        String email  = InputHandler.getStringInput("Email: ");
        String address  = InputHandler.getStringInput("Address: ");
        String specialization   = InputHandler.getStringInput("Specialization: ");
        String qualification   = InputHandler.getStringInput("Qualification: ");
        int    experience    = InputHandler.getIntInput("Experience (years): ", 0, 60);
        String deptId   = InputHandler.getStringInput("Department ID: ");
        double fee    = InputHandler.getDoubleInput("Consultation Fee: ");
        boolean online = InputHandler.getConfirmation(" Online consultations?");
        int dur        = InputHandler.getIntInput(" Duration (minutes): ", 15, 120);
        Consultant c = new Consultant(id, firstName, lastName, dob, gender, phone, email, address,
                specialization, qualification, experience, deptId, fee, new ArrayList<>(), online, dur);
        add(c);
    }


    private void addGeneralPractitioner() {
        String id    = HelperUtils.generateId("GP-",4);
        String firstName    = InputHandler.getStringInput("First Name: ");
        String lastName    = InputHandler.getStringInput("Last Name: ");
        LocalDate dob = InputHandler.getDateInput("Date of Birth");
        String gender = InputHandler.getStringInput("Gender: ");
        String phone  = InputHandler.getStringInput("Phone: ");
        String email  = InputHandler.getStringInput("Email: ");
        String address  = InputHandler.getStringInput("Address: ");
        String specialization   = InputHandler.getStringInput("Specialization: ");
        String qualification   = InputHandler.getStringInput("Qualification: ");
        int    experience    = InputHandler.getIntInput("Experience (years): ", 0, 60);
        String deptId   = InputHandler.getStringInput("Department ID: ");
        double fee    = InputHandler.getDoubleInput("Consultation Fee: ");
        boolean walkin = InputHandler.getConfirmation("Walk-in available?");
        boolean home   = InputHandler.getConfirmation("Home visits available?");
        boolean vacc   = InputHandler.getConfirmation("Vaccination certified?");
        GeneralPractitioner gp = new GeneralPractitioner(id, firstName, lastName, dob, gender, phone, email, address,
                specialization, qualification, experience, deptId, fee, walkin, home, vacc);
        add(gp);
    }

    public void addDoctor(String name, String specialization, String phone){
        Doctor doctor = new Doctor();
        doctor.setId(HelperUtils.generateId("DOC",4));
        doctor.setFirstName(name);
        doctor.setSpecialization(specialization);
        doctor.setPhoneNumber(phone);

        doctors.add(doctor);
    }

    public void addDoctor(String name, String specialization, String phone, double consultationFee){
        Doctor doctor = new Doctor();
        doctor.setId(HelperUtils.generateId("DOC",4));
        doctor.setFirstName(name);
        doctor.setSpecialization(specialization);
        doctor.setPhoneNumber(phone);
        doctor.setConsultationFee(consultationFee);

        doctors.add(doctor);
    }
    public static Doctor updatePatient( ){
        Doctor doctor = new Doctor();

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        doctor.setFirstName(firstName);

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        doctor.setLastName(lastName);

        System.out.print("Enter Specialization: ");
        String specialization = scanner.nextLine();
        doctor.setSpecialization(specialization);

        System.out.print("Enter Qualification: ");
        String qualification = scanner.nextLine();
        doctor.setQualification(qualification);

        System.out.print("Enter Experience Years: ");
        int experienceYears = scanner.nextInt();
        doctor.setExperienceYears(experienceYears);


        return doctor;

    }


    public void editDoctor(String doctorId, Doctor updatedDoctor){
        Doctor existing = getDoctorById(doctorId);
        if (HelperUtils.isNull(existing)) { System.out.println(Constants.DOCTOR_NOT_FOUND);
            return;
        }

        existing.setFirstName(updatedDoctor.getFirstName());
        existing.setLastName(updatedDoctor.getLastName());
        existing.setSpecialization(updatedDoctor.getSpecialization());
        existing.setQualification(updatedDoctor.getQualification());
        existing.setExperienceYears(updatedDoctor.getExperienceYears());
        existing.updateFee(updatedDoctor.getConsultationFee());
        System.out.println(Constants.DOCTOR_UPDATED_SUCCESSFULLY);
    }

    public void removeDoctor(String doctorId){
        for(Doctor d : doctors) {
            if (d.getId().equals(doctorId)) {
                doctors.remove(d);
                System.out.println(Constants.DOCTOR_REMOVED_SUCCESSFULLY);
                return;
            }
        }
        System.out.println(Constants.DOCTOR_NOT_FOUND);
    }

    public Doctor  getDoctorById(String doctorId){
        Doctor doctor = new Doctor();
        for(Doctor d : doctors){
            if(d.getId().equals(doctorId)){
                doctor =  d;
            }else{
                System.out.println(Constants.DOCTOR_NOT_FOUND);
                break;

            }
        }
        return doctor;

    }

    public void displayDoctors(){
        for(Doctor d : doctors){
            d.displayInfo();
        }
    }

    public void displayDoctors(String specialization){
        for(Doctor d : doctors){
            if(d.getSpecialization().equalsIgnoreCase(specialization)){
                d.displayInfo();
            }
        }
    }
    public void displayDoctors(String departmentId, boolean showAvailableOnly) {
        for(Doctor d : doctors){
            if(d.getDepartmentId().equalsIgnoreCase(departmentId) && !d.getAvailableSlots().isEmpty()){
                d.displayInfo();
            }
        }
    }

    public void getAvailableDoctors(){
        for(Doctor d : doctors){
            if(!d.getAvailableSlots().isEmpty()){
                d.displayInfo();
            }
        }
    }

    public void assignPatient(String doctorId, String patientId) {
        Doctor d = getDoctorById(doctorId);
        if (HelperUtils.isNull(d)) { System.out.println(Constants.DOCTOR_NOT_FOUND); return; }
        d.assignPatient(patientId);
        System.out.println(Constants.PATIENT_ASSIGNED_SUCCESSFULLY);
    }



    public void  assignPatient(Doctor doctor, Patient patient){
        if (HelperUtils.isNull(doctor) || HelperUtils.isNull(patient)) return;
        doctor.assignPatient(patient.getId());
        System.out.println(Constants.PATIENT_ASSIGNED_SUCCESSFULLY);
    }

    public void assignPatient(String doctorId, List<String> patientIds) {
        Doctor d = getDoctorById(doctorId);
        if (HelperUtils.isNull(d)) { System.out.println(Constants.DOCTOR_NOT_FOUND); return; }
        if (HelperUtils.isNull(patientIds)) return;
        patientIds.forEach(d::assignPatient);
        System.out.println(Constants.PATIENT_ASSIGNED_SUCCESSFULLY);
    }



    @Override
    public void add(Object entity) {
        Doctor doctor = (Doctor) entity;
        addDoctor(doctor);
    }

    @Override
    public void remove(String id) {
        Doctor doctor = getDoctorById(id);
        if (HelperUtils.isNull(doctor)) { System.out.println(Constants.DOCTOR_NOT_FOUND); return; }
        doctors.remove(doctor);
        System.out.println(Constants.DOCTOR_REMOVED_SUCCESSFULLY);


    }

    @Override
    public Void getAll() {
        return null ;
    }

    @Override
    public void search(String keyword) {
        if (HelperUtils.isNull(doctors)) {
            System.out.println("No Doctors registered.");
            return;}
        for (Doctor doctor : doctors) {

            if (doctor.getFirstName().equalsIgnoreCase(keyword)
                    || doctor.getLastName().equalsIgnoreCase(keyword)
                    || doctor.getPhoneNumber().equalsIgnoreCase(keyword)
                    || doctor.getEmail().equalsIgnoreCase(keyword)
                    || doctor.getId().equalsIgnoreCase(keyword)) {

                doctor.displayInfo();
                return;
            }
        }
        System.out.println(Constants.DOCTOR_NOT_FOUND);



    }

    @Override
    public void searchById(String id) {
        for(Doctor doctor : doctors){
            if(doctor.getId().equals(id)){
                doctor.displayInfo();
            }
        }

    }
    // HANDLE DOCTOR MENU
    public Boolean handleDoctorMenu(Integer doctorOption) {

        switch (doctorOption) {

            case 1 -> {

                Doctor doctor = addDoctor();

                addDoctor(doctor);
            }

            case 2 -> {

                System.out.print("Enter Doctor ID to edit: ");
                String id = scanner.nextLine().trim();
                Doctor updatedDoctor = addDoctor();
                editDoctor(id, updatedDoctor);
            }

            case 3 -> {

                System.out.print("Enter Doctor ID to remove: ");
                String id = scanner.nextLine().trim();
                removeDoctor(id);
            }

            case 4 -> {

                System.out.print("Enter Doctor ID to search: ");
                String id = scanner.nextLine().trim();
                Doctor d = getDoctorById(id);

                if (d != null) {

                    d.displayInfo();

                } else {

                    System.out.println("Doctor not found.");
                }
            }

            case 5 -> {

                System.out.print("Enter specialization to search: ");
                String spec = scanner.nextLine().trim();
                displayDoctors(spec);
            }

            case 6 -> {

                displayDoctors();
            }

            case 7 -> {

                return false;
            }

            default -> {

                System.out.println("Invalid option. Please choose 1-7.");
            }
        }

        return true;
    }
}
