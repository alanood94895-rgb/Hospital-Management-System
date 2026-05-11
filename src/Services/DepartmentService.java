package Services;

import Entities.Department;
import Entities.Doctor;
import Entities.Nurse;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DepartmentService {

    Scanner scanner = new Scanner(System.in);

    static List<Department> departmentList = new ArrayList<>();


    // CREATE DEPARTMENT

    public Department createDepartment() {

        System.out.println("Enter Department ID: ");
        String departmentId = scanner.nextLine();

        if (getDepartmentById(departmentId) != null) {
            System.out.println("Department already exists!");
            return null;
        }

        System.out.println("Enter Department Name: ");
        String departmentName = scanner.nextLine();

        Department department = new Department(
                departmentId,
                departmentName,
                new ArrayList<>()
        );

        return department;
    }

    // =========================================
    // ADD DEPARTMENT
    // =========================================
    public void addDepartment() {

        Department department = createDepartment();

        if (department != null) {
            departments.add(department);
            System.out.println("Department added successfully.");
        }
    }

    // =========================================
    // UPDATE DEPARTMENT
    // =========================================
    public void updateDepartment(String departmentId) {

        Department department = getDepartmentById(departmentId);

        if (department == null) {
            System.out.println("Department not found.");
            return;
        }

        System.out.println("Enter new Department Name: ");
        department.setDepartmentName(scanner.nextLine());

        System.out.println("Department updated successfully.");
    }

    // =========================================
    // DELETE DEPARTMENT
    // =========================================
    public void deleteDepartment(String departmentId) {

        boolean removed = departments.removeIf(
                d -> d.getDepartmentId().equals(departmentId)
        );

        if (removed) {
            System.out.println("Department removed successfully.");
        } else {
            System.out.println("Department not found.");
        }
    }

    // =========================================
    // GET DEPARTMENT BY ID
    // =========================================
    public Department getDepartmentById(String departmentId) {

        for (Department department : departments) {

            if (department.getDepartmentId().equals(departmentId)) {
                return department;
            }
        }

        return null;
    }

    // =========================================
    // DISPLAY ALL DEPARTMENTS
    // =========================================
    public void displayAllDepartments() {

        if (departments.isEmpty()) {
            System.out.println("No departments found.");
            return;
        }

        for (Department department : departments) {
            System.out.println("Department ID: " + department.getDepartmentId());
            System.out.println("Department Name: " + department.getDepartmentName());
            System.out.println("Doctors: " + department.getDoctorIds());
            System.out.println("-----------------------------------");
        }
    }

    // =========================================
    // ASSIGN DOCTOR TO DEPARTMENT
    // =========================================
    public void assignDoctorToDepartment(String doctorId, String departmentId) {

        Department department = getDepartmentById(departmentId);

        if (department == null) {
            System.out.println("Department not found.");
            return;
        }

        if (!department.getDoctorIds().contains(doctorId)) {

            department.getDoctorIds().add(doctorId);

            System.out.println("Doctor " + doctorId +
                    " assigned to Department " + departmentId);

        } else {

            System.out.println("Doctor already assigned to this department.");
        }
    }
}

}