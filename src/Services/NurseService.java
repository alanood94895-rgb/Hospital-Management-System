package Services;

import Entities.Nurse;

import java.util.ArrayList;
import java.util.List;

public class NurseService {

    // List To Store Nurses
    private List<Nurse> nurses = new ArrayList<>();

    // Add Nurse
    public void addNurse(Nurse nurse) {

        nurses.add(nurse);

        System.out.println("Nurse Added Successfully");
    }

    // Edit Nurse
    public void editNurse(String nurseId, Nurse updatedNurse) {

        for (int i = 0; i < nurses.size(); i++) {

            if (nurses.get(i).getNurseId().equals(nurseId)) {

                nurses.set(i, updatedNurse);

                System.out.println("Nurse Updated Successfully");
                return;
            }
        }

        System.out.println("Nurse Not Found");
    }

    // Remove Nurse
    public void removeNurse(String nurseId) {

        boolean removed = nurses.removeIf(nurse -> nurse.getNurseId().equals(nurseId));

        if (removed) {

            System.out.println("Nurse Removed Successfully");

        } else {

            System.out.println("Nurse Not Found");
        }
    }

    // Get Nurse By ID
    public Nurse getNurseById(String nurseId) {

        for (Nurse nurse : nurses) {

            if (nurse.getNurseId().equals(nurseId)) {
                return nurse;
            }
        }
        return null;
    }

    // Display All Nurses
    public void displayAllNurses() {

        if (nurses.isEmpty()) {

            System.out.println("No Nurses Found");

            return;
        }

        System.out.println(" NURSE LIST");

        for (Nurse nurse : nurses) {

            nurse.displayInfo();

            System.out.println("");
        }
    }

    // Get Nurses By Department
    public List<Nurse> getNursesByDepartment(
            String departmentId) {

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