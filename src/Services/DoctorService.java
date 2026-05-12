package Services;

import Behaviour.Manageable;
import Behaviour.Searchable;
import Entities.Doctor;
import Entities.Patient;
import Utils.Constants;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DoctorService implements Manageable, Searchable {

    static Scanner scanner = new Scanner(System.in);

    private List<Doctor> doctors = new ArrayList<>();

    PatientService patientService = new PatientService();

    // ADD DOCTOR OBJECT
    public void addDoctor(Doctor doctor) {

        doctors.add(doctor);

        System.out.println(Constants.DOCTOR_ADDED_SUCCESSFULLY);
    }

    // CREATE NEW DOCTOR
    public Doctor addDoctor() {

        System.out.println("Enter doctor id:");
        String doctorId = scanner.nextLine();

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
        double consultationFee =
                Double.parseDouble(scanner.nextLine());

        List<String> availableSlots = new ArrayList<>();

        System.out.println("Do you want to add available slots? (yes/no)");

        String addSlots = scanner.nextLine();

        if (addSlots.equalsIgnoreCase("yes")) {

            System.out.println("Enter slots separated by commas:");

            String slotsInput = scanner.nextLine();

            availableSlots =
                    Arrays.asList(slotsInput.split(","));
        }

        Doctor doctor = new Doctor(
                doctorId,
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

        doctor.setAvailableSlots(availableSlots);

        return doctor;
    }

    // OVERLOADING 1
    public void addDoctor(String name,
                          String specialization,
                          String phone) {

        Doctor doctor = new Doctor();

        doctor.setFirstName(name);
        doctor.setSpecialization(specialization);
        doctor.setPhoneNumber(phone);

        doctors.add(doctor);
    }

    // OVERLOADING 2
    public void addDoctor(String name,
                          String specialization,
                          String phone,
                          double consultationFee) {

        Doctor doctor = new Doctor();

        doctor.setFirstName(name);
        doctor.setSpecialization(specialization);
        doctor.setPhoneNumber(phone);
        doctor.setConsultationFee(consultationFee);

        doctors.add(doctor);
    }

    // EDIT DOCTOR
    public void editDoctor(String doctorId,
                           Doctor updatedDoctor) {

        for (Doctor d : doctors) {

            if (d.getId().equals(doctorId)) {

                d.setPhoneNumber(updatedDoctor.getPhoneNumber());
                d.setEmail(updatedDoctor.getEmail());
                d.setAddress(updatedDoctor.getAddress());

                System.out.println(
                        Constants.DOCTOR_UPDATED_SUCCESSFULLY);

                return;
            }
        }

        System.out.println(Constants.DOCTOR_NOT_FOUND);
    }

    // REMOVE DOCTOR
    public void removeDoctor(String doctorId) {

        for (Doctor d : doctors) {

            if (d.getId().equals(doctorId)) {

                doctors.remove(d);

                System.out.println(
                        Constants.DOCTOR_REMOVED_SUCCESSFULLY);

                return;
            }
        }

        System.out.println(Constants.DOCTOR_NOT_FOUND);
    }

    // GET DOCTOR BY ID
    public Doctor getDoctorById(String doctorId) {

        for (Doctor d : doctors) {

            if (d.getId().equals(doctorId)) {

                return d;
            }
        }

        return null;
    }

    // DISPLAY ALL DOCTORS
    public void displayDoctors() {

        for (Doctor d : doctors) {

            d.displayInfo();
        }
    }

    // DISPLAY DOCTORS BY SPECIALIZATION
    public void displayDoctors(String specialization) {

        for (Doctor d : doctors) {

            if (d.getSpecialization()
                    .equalsIgnoreCase(specialization)) {

                d.displayInfo();
            }
        }
    }

    // DISPLAY AVAILABLE DOCTORS
    public void displayDoctors(String departmentId,
                               boolean showAvailableOnly) {

        for (Doctor d : doctors) {

            if (d.getDepartmentId()
                    .equalsIgnoreCase(departmentId)
                    &&
                    !d.getAvailableSlots().isEmpty()) {

                d.displayInfo();
            }
        }
    }

    // AVAILABLE DOCTORS
    public void getAvailableDoctors() {

        for (Doctor d : doctors) {

            if (!d.getAvailableSlots().isEmpty()) {

                d.displayInfo();
            }
        }
    }

    // ASSIGN PATIENT
    public void assignPatient(String doctorId,
                              String patientId) {

        for (Doctor doctor : doctors) {

            if (doctor.getId().equals(doctorId)) {

                for (Patient p : patientService.getPatients()) {

                    if (p.getId().equals(patientId)) {

                        doctor.getAssignedPatients().add(p);

                        System.out.println(
                                Constants.PATIENT_ASSIGNED_SUCCESSFULLY
                        );

                        return;
                    }
                }

                System.out.println(Constants.PATIENT_NOT_FOUND);

                return;
            }
        }

        System.out.println(Constants.DOCTOR_NOT_FOUND);
    }

    // OVERLOADING
    public void assignPatient(Doctor doctor,
                              Patient patient) {

        doctor.getAssignedPatients().add(patient);
    }

    // OVERLOADING
    public void assignPatient(String doctorId,
                              List<String> patientIds) {

        for (Doctor doctor : doctors) {

            if (doctor.getId().equals(doctorId)) {

                for (Patient p : patientService.getPatients()) {

                    for (String x : patientIds) {

                        if (p.getId().equals(x)) {

                            doctor.getAssignedPatients().add(p);
                        }
                    }
                }

                System.out.println(
                        Constants.PATIENT_ASSIGNED_SUCCESSFULLY
                );

                return;
            }
        }

        System.out.println(Constants.DOCTOR_NOT_FOUND);
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

                System.out.print(
                        "Enter specialization to search: ");

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

                System.out.println(
                        "Invalid option. Please choose 1-7.");
            }
        }

        return true;
    }
}