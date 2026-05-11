package Services;

import Entities.Department;
import Utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartmentService {
    static Scanner scanner = new Scanner(System.in);
    List<Department> departments = new ArrayList<>();

    public void addDepartment(Department department){
        departments.add(department);
        System.out.println(Constants.DEPARTMENT_ADDED_SUCCESSFULLY);
    }

    public Department addDepartment(){
        System.out.print("Enter Department ID: ");
        String departmentId = scanner.nextLine();

        System.out.print("Enter Department Name: ");
        String departmentName = scanner.nextLine();

        System.out.print("Enter Head Doctor ID: ");
        String headDoctorId = scanner.nextLine();

        System.out.print("Enter Bed Capacity: ");
        int bedCapacity = scanner.nextInt();

        List<String> doctors = new ArrayList<>();
        List<String> nurses = new ArrayList<>();

        System.out.print("Enter Available Beds: ");
        int availableBeds = scanner.nextInt();
        Department department = new Department(
                departmentId,
                departmentName,
                headDoctorId,
                bedCapacity

        );

        return department;

    }

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

    public void removeDepartment(String departmentId) {
        for (Department d : departments) {
            if (d.getDepartmentId().equals(departmentId)) {
                departments.remove(d);
                return;
            }
        }
        System.out.println(Constants.DEPARTMENT_NOT_FOUND);
    }

    public void getDepartmentById(String departmentId){
        for(Department d : departments){
            if(d.getDepartmentId().equals(departmentId)){
                d.displayInfo();
                return;
            }
        }
        System.out.println(Constants.DEPARTMENT_NOT_FOUND);
    }

    public void displayAllDepartments(){
        for(Department d : departments){
            d.displayInfo();
        }
    }


    public void assignDoctorToDepartment(String doctorId, String departmentId){
        for(Department d : departments){
            if(d.getDepartmentId().equals(departmentId)){
                d.setHeadDoctorId(doctorId);
                return;
            }
        }
        System.out.println(Constants.DEPARTMENT_NOT_FOUND);
    }









}