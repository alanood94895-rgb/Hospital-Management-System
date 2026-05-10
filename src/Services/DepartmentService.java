package Services;

import Entities.Department;
import Entities.Doctor;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService {

    private List<Department> departments =
            new ArrayList<>();

    // Add Department
    public void addDepartment(Department department) {
        departments.add(department);
    }
    // Remove Department
    public void removeDepartment(String departmentId) {

        departments.removeIf(department -> department.getDepartmentId().equals(departmentId));
    }
    // Get Department By ID
    public Department getDepartmentById(
            String departmentId) {

        for (Department department : departments) {

            if (department.getDepartmentId().equals(departmentId)) {

                return department;
            }
        }

        return null;
    }
    // Display All Departments

    public void displayAllDepartments() {

        for (Department department : departments) {
            department.displayInfo();
        }
    }
    // Assign Doctor To Department
    public void assignDoctorToDepartment(
            Doctor doctor,
            String departmentId) {

        Department department = getDepartmentById(departmentId);

        if (department != null) {
            department.assignDoctor(doctor);

            System.out.println("Doctor Assigned Successfully");
        }
    }
}


