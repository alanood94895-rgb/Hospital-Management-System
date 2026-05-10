package Services;

import Entities.Nurse;

import java.util.ArrayList;
import java.util.List;

public class NurseService {

    private List<Nurse> nurses = new ArrayList<>();

    // Add Nurse

    public void addNurse(Nurse nurse) {
        nurses.add(nurse);
    }

    // Edit Nurse

    public void editNurse(String nurseId, Nurse updatedNurse) {

        for (int i = 0; i < nurses.size(); i++) {

            if (nurses.get(i).getId().equals(nurseId)) {
                nurses.set(i, updatedNurse);
                return;
            }
        }
    }

    // Remove Nurse

    public void removeNurse(String nurseId) {

        nurses.removeIf(
                nurse -> nurse.getId().equals(nurseId)
        );
    }

    // Get Nurse By ID

    public Nurse getNurseById(String nurseId) {

        for (Nurse nurse : nurses) {

            if (nurse.getId().equals(nurseId)) {
                return nurse;
            }
        }

        return null;
    }

    // Display All Nurses

    public void displayAllNurses() {

        for (Nurse nurse : nurses) {
            nurse.displayInfo();
        }
    }

    // Get Nurses By Department

    public List<Nurse> getNursesByDepartment(String departmentId) {

        List<Nurse> result = new ArrayList<>();

        for (Nurse nurse : nurses) {

            if (nurse.getDepartmentId().equalsIgnoreCase(departmentId)) {

                result.add(nurse);
            }
        }

        return result;
    }

    // Get Nurses By Shift

    public List<Nurse> getNursesByShift(String shift) {

        List<Nurse> result = new ArrayList<>();

        for (Nurse nurse : nurses) {

            if (nurse.getShift().equalsIgnoreCase(shift)) {

                result.add(nurse);
            }
        }

        return result;
    }
}
