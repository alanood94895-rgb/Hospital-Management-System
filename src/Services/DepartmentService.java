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
    List<Doctor> doctors = new ArrayList<>();
    List<Nurse> nurses = new ArrayList<>();


    // Add Department
    public void addDepartment(Department department) {

        departments.add(department);

        System.out.println("Department Added Successfully");
    }

    //  Edit Department
    public void editDepartment(String departmentId, Department updatedDepartment) {

        for (int i = 0; i < departments.size(); i++) {

            if (departments.get(i).getDepartmentId().equals(departmentId)) {

                departments.set(i, updatedDepartment);

                System.out.println("Department Updated Successfully");
                return;
            }
        }

        System.out.println("Department Not Found");
    }

    //  Remove Department
    public void removeDepartment(String departmentId) {

        boolean removed = departments.removeIf(department -> department.getDepartmentId().equals(departmentId));

        if (removed) {

            System.out.println("Department Removed Successfully");
        } else {

            System.out.println("Department Not Found");
        }
    }

    //  Get Department By ID
    public Department getDepartmentById(String departmentId) {

        for (Department department : departments) {

            if (department.getDepartmentId().equals(departmentId)) {
                return department;
            }
        }

        return null;
    }

    // Display All Departments
    public void displayAllDepartments() {

        if (departments.isEmpty()) {

            System.out.println("No Departments Found");

            return;
        }

        System.out.println(" DEPARTMENT LIST");

        for (Department department : departments) {

            department.displayInfo();

            System.out.println("");
        }
    }

    // Assign Doctor To Department
    public void assignDoctorToDepartment(Doctor doctor, String departmentId) {

        for (Department department : departments) {

            if (department.getDepartmentId().equals(departmentId)) {

                // Add doctor to department
                department.assignDoctor(doctor);

                // Update doctor departmentId
                doctor.setDepartmentId(departmentId);

                System.out.println("Doctor Assigned Successfully");

                return;
            }
        }

        System.out.println("Department Not Found");
    }
}