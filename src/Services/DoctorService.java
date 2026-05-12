package Services;

import Entities.Doctor;
import Utils.Constants;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DoctorService {
    static Scanner scanner = new Scanner(System.in);
    private List<Doctor> doctors = new ArrayList<>();

    // ADD DOCTOR
    public void addDoctor(Doctor doctor) {

        doctors.add(doctor);
        System.out.println(Constants.DOCTOR_ADDED_SUCCESSFULLY);
    }

    // CREATE DOCTOR OBJECT
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

        double consultationFee = Double.parseDouble(scanner.nextLine());
        List<String> availableSlots = new ArrayList<>();

        System.out.println("Do you want to add available slots? (yes/no)");
        String addSlots = scanner.nextLine();
        if (addSlots.equalsIgnoreCase("yes")) {

            System.out.println("Enter slots separated by commas:");
            String slotsInput = scanner.nextLine();
            availableSlots = Arrays.asList(slotsInput.split(","));
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
                doctorId,
                specialization,
                qualification,
                experienceYears,
                departmentId,
                consultationFee,
                availableSlots,
                new ArrayList<>()
        );

        return doctor;
    }

    // EDIT DOCTOR
    public void editDoctor(String doctorId,
                           Doctor updatedDoctor) {

        for (Doctor d : doctors) {

            if (d.getId().equals(doctorId)) {
                d.setPhoneNumber(updatedDoctor.getPhoneNumber());
                d.setEmail(updatedDoctor.getEmail());
                d.setAddress(updatedDoctor.getAddress());

                System.out.println(Constants.DOCTOR_UPDATED_SUCCESSFULLY);

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
                System.out.println(Constants.DOCTOR_REMOVED_SUCCESSFULLY);

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
    public void displayAllDoctors() {

        for (Doctor d : doctors) {

            d.displayInfo();
        }
    }


    // GET DOCTORS BY SPECIALIZATION
    public void getDoctorsBySpecialization(String specialization) {

        for (Doctor d : doctors) {
            if (d.getSpecialization().equalsIgnoreCase(specialization)) {

                d.displayInfo();
            }
        }
    }


    // GET AVAILABLE DOCTORS
    public void getAvailableDoctors() {

        for (Doctor d : doctors) {
            if (!d.getAvailableSlots().isEmpty()) {
                d.displayInfo();
            }
        }
    }


    // HANDLE DOCTOR MENU

    public Boolean handleDoctorMenu(
            Integer doctorOption
    ) {

        switch (doctorOption) {

            case 1 -> {

                Doctor doctor = addDoctor();

                addDoctor(doctor);
            }

            case 2 -> {

                System.out.print(
                        "Enter Doctor ID to edit: "
                );

                String id =
                        scanner.nextLine().trim();

                Doctor updatedDoctor =
                        addDoctor();

                editDoctor(id, updatedDoctor);
            }

            case 3 -> {

                System.out.print(
                        "Enter Doctor ID to remove: "
                );

                String id =
                        scanner.nextLine().trim();

                removeDoctor(id);
            }

            case 4 -> {

                System.out.print(
                        "Enter Doctor ID to search: "
                );

                String id =
                        scanner.nextLine().trim();

                Doctor d =
                        getDoctorById(id);

                if (d != null) {

                    d.displayInfo();
                }

                else {

                    System.out.println(
                            "Doctor not found."
                    );
                }
            }

            case 5 -> {

                System.out.print(
                        "Enter specialization to search: "
                );

                String spec =
                        scanner.nextLine().trim();

                getDoctorsBySpecialization(spec);
            }

            case 6 -> {

                displayAllDoctors();
            }

            case 7 -> {

                return false;
            }

            default -> {

                System.out.println(
                        "Invalid option. Please choose 1-7."
                );
            }
        }

        return true;
    }
}