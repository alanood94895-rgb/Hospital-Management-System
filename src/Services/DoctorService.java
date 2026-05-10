package Services;

import Entities.Doctor;

import java.util.ArrayList;
import java.util.List;


public class DoctorService {
    List<Doctor> doctors = new ArrayList<>();

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void displayAllDoctors() {

        for (Doctor doctor : doctors) {
            doctor.displayInfo();
        }
    }
    public List<Doctor> getDoctorsBySpecialization(String specialization) {

        List<Doctor> result = new ArrayList<>();

        for (Doctor doctor : doctors) {

            if (doctor.getSpecialization()
                    .equalsIgnoreCase(specialization)) {

                result.add(doctor);
            }
        }

        return result;
    }
}

