package Services;

import Entities.Doctor;

import java.util.ArrayList;
import java.util.List;


public class DoctorService {
    private List<Doctor> doctors = new ArrayList<>();

    // Add Doctor
    public void addDoctor(Doctor doctor) {

        doctors.add(doctor);
        System.out.println("Doctor Added Successfully");
    }

    // Edit Doctor
    public void editDoctor(String doctorId, Doctor updatedDoctor) {

        for (int i = 0; i < doctors.size(); i++) {

            if (doctors.get(i).getDoctorId().equals(doctorId)) {

                doctors.set(i, updatedDoctor);

                System.out.println("Doctor Updated Successfully");

                return;
            }
        }

        System.out.println("Doctor Not Found");
    }

    // Remove Doctor
    public void removeDoctor(String doctorId) {

        boolean removed = doctors.removeIf(doctor -> doctor.getDoctorId().equals(doctorId));

        if (removed) {

            System.out.println("Doctor Removed Successfully");

        } else {
            System.out.println("Doctor Not Found");
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

            System.out.println("No Doctors Found");

            return;
        }

        System.out.println("DOCTOR LIST");

        for (Doctor doctor : doctors) {

            doctor.displayInfo();

            System.out.println("");
        }
    }

    // Get Doctors By Specialization
    public List<Doctor> getDoctorsBySpecialization(String specialization) {

        List<Doctor> result = new ArrayList<>();

        for (Doctor doctor : doctors) {

            if (doctor.getSpecialization().equalsIgnoreCase(specialization)) {
                result.add(doctor);
            }
        }

        return result;
    }

    // Get Available Doctors
    public List<Doctor> getAvailableDoctors() {

        List<Doctor> availableDoctors =
                new ArrayList<>();

        for (Doctor doctor : doctors) {

            if (!doctor.getAvailableSlots().isEmpty()) {
                availableDoctors.add(doctor);
            }
        }

        return availableDoctors;
    }
}