package Services;

import Entities.Doctor;
import Entities.Patient;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorService {

    Scanner scanner = new Scanner(System.in);

    static List<Doctor> doctors = new ArrayList<>();

    // Add Doctor
    public Doctor addDoctor() {

        System.out.println("ADD DOCTOR ");

        System.out.print("Enter Doctor ID: ");
        String doctorId = scanner.nextLine();

        if (getDoctorById(doctorId) != null) {

            System.out.println("Doctor already exists.");
            return null;
        }

        System.out.print("Enter System ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter DOB (YYYY-MM-DD): ");
        LocalDate dob = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter Specialization: ");
        String specialization = scanner.nextLine();

        System.out.print("Enter Qualification: ");
        String qualification = scanner.nextLine();

        System.out.print("Enter Experience Years: ");
        int experienceYears = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Department ID: ");
        String departmentId = scanner.nextLine();

        System.out.print("Enter Consultation Fee: ");
        double consultationFee = scanner.nextDouble();
        scanner.nextLine();

        List<String> availableSlots = new ArrayList<>();
        List<String> assignedPatients = new ArrayList<>();

        Doctor doctor;
        doctor = new Doctor(
                id,
                firstName,
                lastName,
                dob,
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
                assignedPatients,
        );

        return doctor;
    }

    // Add Multiple Doctors
    public List<Doctor> addDoctors() {

        while (true) {

            Doctor doctor = addDoctor();

            if (doctor != null) {

                doctors.add(doctor);

                System.out.println("Doctor added successfully.");
            }

            System.out.println("Enter q to quit or any key to continue");

            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("q")) {
                break;
            }
        }

        return doctors;
    }

    // Edit Doctor
    public void editDoctor(String doctorId) {

        Doctor doctor = getDoctorById(doctorId);

        if (doctor == null) {

            System.out.println("Doctor not found.");
            return;
        }

        System.out.println("UPDATE DOCTOR");

        System.out.print("Enter Updated First Name: ");
        doctor.setFirstName(scanner.nextLine());

        System.out.print("Enter Updated Last Name: ");
        doctor.setLastName(scanner.nextLine());

        System.out.print("Enter Updated DOB: ");
        doctor.setDateOfBirth(
                LocalDate.parse(scanner.nextLine())
        );

        System.out.print("Enter Updated Gender: ");
        doctor.setGender(scanner.nextLine());

        System.out.print("Enter Updated Phone: ");
        doctor.setPhoneNumber(scanner.nextLine());

        System.out.print("Enter Updated Email: ");
        doctor.setEmail(scanner.nextLine());

        System.out.print("Enter Updated Address: ");
        doctor.setAddress(scanner.nextLine());

        System.out.print("Enter Updated Specialization: ");
        doctor.setSpecialization(scanner.nextLine());

        System.out.print("Enter Updated Qualification: ");
        doctor.setQualification(scanner.nextLine());

        System.out.print("Enter Updated Experience Years: ");
        doctor.setExperienceYears(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Enter Updated Department ID: ");
        doctor.setDepartmentId(scanner.nextLine());

        System.out.print("Enter Updated Consultation Fee: ");
        doctor.setConsultationFee(scanner.nextDouble());
        scanner.nextLine();

        System.out.println("Doctor updated successfully.");
    }

    // Remove Doctor
    public void removeDoctor(String doctorId) {

        boolean removed = doctors.removeIf(doctor -> doctor.getDoctorId().equals(doctorId));

        if (removed) {

            System.out.println("Doctor removed successfully.");

        } else {

            System.out.println("Doctor not found.");
        }
    }

    // Get Doctor By ID
    public Doctor getDoctorById(String doctorId) {

        for (Doctor doctor : doctors) {

            if (doctor.getDoctorId().equals(doctorId)) {

                return doctor;
            }
        }

        return null;
    }

    // Display All Doctors
    public void displayAllDoctors() {

        if (doctors.isEmpty()) {

            System.out.println("No doctors found.");
            return;
        }

        for (Doctor doctor : doctors) {

            doctor.displayInfo();
        }
    }

    // Get Doctors By Specialization
    public List<Doctor> getDoctorsBySpecialization(String specialization) {

        List<Doctor> specializationDoctors = new ArrayList<>();

        for (Doctor doctor : doctors) {
            if (doctor.getSpecialization().equalsIgnoreCase(specialization)) {
                specializationDoctors.add(doctor);
            }
        }

        return specializationDoctors;
    }

    // Get Available Doctors
    public List<Doctor> getAvailableDoctors() {

        List<Doctor> availableDoctors = new ArrayList<>();

        for (Doctor doctor : doctors) {

            if (!doctor.getAvailableSlots().isEmpty()) {

                availableDoctors.add(doctor);
            }
        }

        return availableDoctors;
    }
}