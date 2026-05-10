package Services;

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

}
