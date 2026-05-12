package Services;

import Behaviour.Manageable;
import Behaviour.Searchable;
import Entities.Department;
import Utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartmentService implements Manageable, Searchable {

    static Scanner scanner = new Scanner(System.in);
    List<Department> departments = new ArrayList<>();

    // ADD DEPARTMENT

    public void addDepartment(Department department) {
        departments.add(department);
        System.out.println(Constants.DEPARTMENT_ADDED_SUCCESSFULLY);
    }

    // CREATE DEPARTMENT OBJECT
    public Department addDepartment() {

        System.out.print("Enter Department ID: ");
        String departmentId = scanner.nextLine();

        System.out.print("Enter Department Name: ");
        String departmentName = scanner.nextLine();

        System.out.print("Enter Head Doctor ID: ");
        String headDoctorId = scanner.nextLine();

        System.out.print("Enter Bed Capacity: ");
        int bedCapacity = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Available Beds: ");
        int availableBeds = Integer.parseInt(scanner.nextLine());

        return new Department(
                departmentId,
                departmentName,
                headDoctorId,
                new ArrayList<>(),
                new ArrayList<>(),
                bedCapacity,
                availableBeds
        );
    }

    // EDIT DEPARTMENT
    public void editDepartment(String departmentId, Department updatedDepartment) {
        for (Department d : departments) {
            if (d.getDepartmentId().equals(departmentId)) {
                d.setBedCapacity(updatedDepartment.getBedCapacity());
                d.setAvailableBeds(updatedDepartment.getAvailableBeds());
                return;
            }
        }
        System.out.println(Constants.DEPARTMENT_NOT_FOUND);
    }

    // REMOVE DEPARTMENT
    public void removeDepartment(String departmentId) {
        departments.removeIf(d -> d.getDepartmentId().equals(departmentId));
    }

    // GET DEPARTMENT BY ID
    public Department getDepartmentById(String departmentId) {
        for (Department d : departments) {
            if (d.getDepartmentId().equals(departmentId)) {
                return d;
            }
        }
        System.out.println(Constants.DEPARTMENT_NOT_FOUND);
        return null;
    }

    // DISPLAY ALL DEPARTMENTS
    public void displayAllDepartments() {
        for (Department d : departments) {
            d.displayInfo();
        }
    }

    // ASSIGN DOCTOR TO DEPARTMENT
    public void assignDoctorToDepartment(String doctorId, String departmentId) {
        for (Department d : departments) {
            if (d.getDepartmentId().equals(departmentId)) {
                d.setHeadDoctorId(doctorId);
                return;
            }
        }
        System.out.println(Constants.DEPARTMENT_NOT_FOUND);
    }


    @Override
    public void add(Object entity) {}

    @Override
    public void remove(String id) {}

    @Override
    public Void getAll() { return null; }

    @Override
    public void search(String keyword) {}

    @Override
    public void searchById(String id) {}


    // HANDLE DEPARTMENT MENU
    public Boolean handleDepartmentMenu(Integer option) {

        switch (option) {

            case 1 -> {
                Department department = addDepartment();
                addDepartment(department);
            }

            case 2 -> {
                System.out.print("Enter ID to edit: ");
                String id = scanner.nextLine().trim();

                Department updated = addDepartment();
                editDepartment(id, updated);
            }

            case 3 -> {
                System.out.print("Enter ID to remove: ");
                removeDepartment(scanner.nextLine().trim());
            }

            case 4 -> displayAllDepartments();

            case 5 -> {
                System.out.print("Enter Department ID: ");
                Department d = getDepartmentById(scanner.nextLine().trim());

                if (d != null) {
                    d.displayInfo();
                }
            }

            case 6 -> {
                return false;
            }

            default -> System.out.println("Invalid option.");
        }

        return true;
    }
}