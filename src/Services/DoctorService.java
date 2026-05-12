package Services;

import Behaviour.Manageable;
import Behaviour.Searchable;
import Entities.Doctor;
import Entities.Patient;
import Utils.Constants;
import Utils.HelperUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static Services.PatientService.getPatients;

public class DoctorService implements Manageable, Searchable {
    static Scanner scanner = new Scanner(System.in);
    private List<Doctor> doctors = new ArrayList<>();

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        System.out.println(Constants.DOCTOR_ADDED_SUCCESSFULLY);
    }

    public Doctor addDoctor() {

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

        System.out.println("Enter specialization:");
        String specialization = scanner.nextLine();

        System.out.println("Enter qualification:");
        String qualification = scanner.nextLine();

        System.out.println("Enter years of experience:");
        int experienceYears = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter department id:");
        String departmentId = scanner.nextLine();

        System.out.println("Enter consultation fee:");
        double consultationFee = Double.parseDouble(scanner.nextLine());

        List<String> availableSlots = new ArrayList<>();

        System.out.println("Do you want to add available slots? (yes/no)");
        String addSlots = scanner.nextLine();

        if (addSlots.equalsIgnoreCase("yes")) {

            System.out.println("Enter slots separated by commas:");
            String slotsInput = scanner.nextLine();

            availableSlots = Arrays.asList(slotsInput.split(","));
        }

        List<String> assignedPatients = new ArrayList<>();

        Doctor doctor = new Doctor(
                HelperUtils.generateId("Dc."),
                firstName,
                lastName,
                dateOfBirth,
                gender,
                phone,
                email,
                address,
                specialization,
                qualification,
                experienceYears,
                departmentId,
                consultationFee

        );

        return doctor;
    }

    public void addDoctor(String name, String specialization, String phone){
        Doctor doctor = new Doctor();

        doctor.setFirstName(name);
        doctor.setSpecialization(specialization);
        doctor.setPhoneNumber(phone);

        doctors.add(doctor);
    }

    public void addDoctor(String name, String specialization, String phone, double consultationFee){
        Doctor doctor = new Doctor();

        doctor.setFirstName(name);
        doctor.setSpecialization(specialization);
        doctor.setPhoneNumber(phone);
        doctor.setConsultationFee(consultationFee);

        doctors.add(doctor);
    }


    public void editDoctor(String doctorId, Doctor updatedDoctor){
        for(Doctor d : doctors){
            if(d.getId().equals(doctorId)){
                d.setPhoneNumber(updatedDoctor.getPhoneNumber());
                d.setEmail(updatedDoctor.getEmail());
                d.setAddress(updatedDoctor.getAddress());

                System.out.println(Constants.DOCTOR_UPDATED_SUCCESSFULLY);
                return;
            }
        }
        System.out.println(Constants.DOCTOR_NOT_FOUND);
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

    public Doctor getDoctorById(String doctorId){
        for(Doctor d : doctors){
            if(d.getId().equals(doctorId)){
                d.displayInfo();
                return d;
            }
        }
        System.out.println(Constants.DOCTOR_NOT_FOUND);
        return null;
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

    public void assignPatient(String doctorId, String patientId){
        for (Doctor doctor : doctors){

            for(Patient p : getPatients()){
                if(doctor.getId().equals(doctorId)){
                    if(p.getId().equals(patientId)){
                        doctor.getAssignedPatients().add(p);
                        System.out.println(Constants.PATIENT_ASSIGNED_SUCCESSFULLY);
                        return;
                    }
                    System.out.println(Constants.PATIENT_NOT_FOUND);


                }
                System.out.println(Constants.DOCTOR_NOT_FOUND);
            }

        }


    }

    public void  assignPatient(Doctor doctor, Patient patient){
        doctor.getAssignedPatients().add(patient);
    }

    public void  assignPatient(String doctorId, List<String> patientIds) {
        for (Doctor doctor : doctors){
            if(doctor.getId().equals(doctorId)){
                for(Patient p : getPatients()){
                    for(String x : patientIds){
                        if(p.getId().equals(x)){
                            doctor.getAssignedPatients().add(p);
                            System.out.println(Constants.PATIENT_ASSIGNED_SUCCESSFULLY);
                        }else{
                            System.out.println(Constants.PATIENT_NOT_FOUND);
                        }

                    }

                }

            }else{
                System.out.println(Constants.DOCTOR_NOT_FOUND);
            }


        }

    }


    // INTERFACE METHODS
    @Override
    public void add(Object entity) {

    }

    @Override
    public void remove(String id) {

    }

    @Override
    public Void getAll() {
        return null;
    }

    @Override
    public void search(String keyword) {

    }

    @Override
    public void searchById(String id) {

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