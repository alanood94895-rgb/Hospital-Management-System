package Services;

import Entities.Nurse;
import Utils.Constants;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NurseService {

    static Scanner scanner = new Scanner(System.in);

    List<Nurse> nurses = new ArrayList<>();


    // Add Nurse
    public void addNurse(Nurse nurse) {

        nurses.add(nurse);

        System.out.println(Constants.NURSE_ADDED_SUCCESSFULLY);
    }


    // Crate Nurse Object
    public Nurse addNurses() {

        System.out.println("Enter Nurse id:");
        String nurseId = scanner.nextLine();

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

        System.out.println("Enter department id:");
        String departmentId = scanner.nextLine();

        System.out.println("Enter shift:");
        String shift = scanner.nextLine();

        System.out.println("Enter qualification:");
        String qualification = scanner.nextLine();

        Nurse nurse = new Nurse(
                nurseId,
                firstName,
                lastName,
                dateOfBirth,
                gender,
                phone,
                email,
                address,
                nurseId,
                departmentId,
                shift,
                qualification,
                new ArrayList<>()
        );

        return nurse;
    }


    // Edit Nurse
    public void editNurse(String nurseId, Nurse updatedNurse) {

        for (Nurse n : nurses) {

            if (n.getId().equals(nurseId)) {
                n.setPhoneNumber(updatedNurse.getPhoneNumber());

                n.setEmail(updatedNurse.getEmail());

                n.setAddress(updatedNurse.getAddress());

                System.out.println(Constants.NURSE_UPDATED_SUCCESSFULLY);

                return;
            }
        }

        System.out.println(Constants.NURSE_NOT_FOUND);
    }

    // Remove Nurse
    public void removeNurse(String nurseId) {

        for (Nurse n : nurses) {
            if (n.getId().equals(nurseId)) {
                nurses.remove(n);
                System.out.println(Constants.NURSE_REMOVED_SUCCESSFULLY);
                return;
            }
        }

        System.out.println(Constants.NURSE_NOT_FOUND);
    }

    // Get Nurse By ID
    public void getNurseById(String nurseId) {

        for (Nurse n : nurses) {
            if (n.getId().equals(nurseId)) {

                n.displayInfo();

                return;
            }
        }

        System.out.println(Constants.NURSE_NOT_FOUND);
    }

    // Get Nurse By Department
    public void getNursesByDepartment(String departmentId) {
        for (Nurse n : nurses) {
            if (n.getDepartmentId().equals(departmentId)) {
                n.displayInfo();
            }
        }
    }


    // Get Nurse By Shift
    public void getNursesByShift(String shift) {

        for (Nurse n : nurses) {

            if (n.getShift().equalsIgnoreCase(shift)) {

                n.displayInfo();
            }
        }
    }

    // Display all Nurse
    public void displayAllNurses() {

        for (Nurse n : nurses) {
            n.displayInfo();
        }
    }


    // HANDLE NURSE MENU
    public Boolean handleNurseMenu(Integer option) {

        switch (option) {

            case 1 -> {

                Nurse nurse = addNurses();

                addNurse(nurse);
            }

            case 2 -> {

                System.out.print("Enter Nurse ID to edit: ");
                String nurseId = scanner.nextLine().trim();
                Nurse updatedNurse = addNurses();
                editNurse(nurseId, updatedNurse);
            }

            case 3 -> {

                System.out.print("Enter Nurse ID to remove: ");
                removeNurse(scanner.nextLine().trim());
            }

            case 4 -> {
                System.out.print("Enter Department ID to filter: ");
                getNursesByDepartment(scanner.nextLine().trim());
            }

            case 5 -> {

                System.out.print("Enter Shift to filter: ");

                getNursesByShift(scanner.nextLine().trim());
            }

            case 6 -> {
                displayAllNurses();
            }

            case 7 -> {

                return false;
            }

            default -> {

                System.out.println("Invalid option.");
            }
        }

        return true;
    }
}