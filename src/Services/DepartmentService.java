package Services;

import Behaviour.Editable;
import Behaviour.Manageable;
import Behaviour.Searchable;
import Entities.Department;
import Entities.Doctor;
import Entities.Nurse;
import Utils.Constants;
import Utils.HelperUtils;
import Utils.InputHandler;
import Utils.MenuMessages;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService implements Manageable, Searchable , Editable {
    private static List<Department> departments = new ArrayList<>();
    NurseService nurseService = new NurseService();
    DoctorService doctorService = new DoctorService();

    public void addDepartment(Department department){
        departments.add(department);
        System.out.println(Constants.DEPARTMENT_ADDED_SUCCESSFULLY);
    }

    public Department addDepartment(){

        String departmentName = InputHandler.getStringInput("Enter Department Name: ");

        String headDoctorId = InputHandler.getStringInput("Enter Head Doctor ID: ");

        System.out.print("Enter Bed Capacity: ");
        int bedCapacity = InputHandler.getIntInput("Enter Bed Capacity: ");

        List<String> doctors = new ArrayList<>();
        List<String> nurses = new ArrayList<>();

        System.out.print("Enter Available Beds: ");
        int availableBeds = InputHandler.getIntInput("Enter Available Beds: ");
        Department department = new Department(
                HelperUtils.generateId("DEP",2),
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
    public void getDepartments() {
        if (departments.isEmpty()) {
            System.out.println(Constants.DEPARTMENT_NOT_FOUND);
            return;
        }
        for (Department d : departments) {
            d.displayInfo();
        }
    }

    public Department getDepartmentById(String departmentId) {
        for (Department d : departments) {
            if (d.getDepartmentId().equals(departmentId)) {
                return d;
            }
        }
        System.out.println(Constants.DEPARTMENT_NOT_FOUND);
        return null;
    }

    public void displayAllDepartments(){
        for(Department d : departments){
            d.displayInfo();
        }
    }


    public void assignDoctorToDepartment(String doctorId, String departmentId){
        Department department = getDepartmentById(departmentId);
        Doctor doctor = doctorService.getDoctorById(doctorId);
        if (HelperUtils.isNull(department)) {
            return;
        }
        if (HelperUtils.isNull(doctor)) {
            return;
        }
        department.assignDoctor(doctorId);
        System.out.println(Constants.DOCTOR_ASSIGNED_SUCCESSFULLY);

    }

    public void assignNurseToDepartment(String nurseId, String departmentId){
        Department department = getDepartmentById(departmentId);
        Nurse nurse = nurseService.getNurseById(nurseId);

        if (HelperUtils.isNull(department)) {
            System.out.println(Constants.DEPARTMENT_NOT_FOUND);
            return;
        }
        if (HelperUtils.isNull(nurse)) {
            return;
        }

        department.assignNurse(nurseId);
        System.out.println(Constants.NURSE_ASSIGNED_SUCCESSFULLY);
    }


    @Override
    public void add(Object entity) {
        Department department = (Department) entity;
        for(Department d : departments){
            if (d.getDepartmentId().equals(department.getDepartmentId())) {
                return;
            }
        }
        departments.add(department);

    }

    @Override
    public void remove(String id) {
        Department department = getDepartmentById(id);
        if (HelperUtils.isNotNull(department)) {
            departments.remove(department);
        }

    }

    @Override
    public void getAll() {
        departments.forEach(d -> d.displayInfo());

    }

    @Override
    public void search(String keyword) {
        boolean found = false;
        for (Department d : departments) {
            if (d.getDepartmentName().equalsIgnoreCase(keyword) ||
                    d.getDepartmentId().equalsIgnoreCase(keyword)   ||
                    d.getHeadDoctorId().equalsIgnoreCase(keyword)) {
                d.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println(Constants.DEPARTMENT_NOT_FOUND);
        }

    }

    @Override
    public void searchById(String id) {
        for (Department d : departments) {
            if (d.getDepartmentId().equals(id)) {
                d.displayInfo();
                return;
            }
        }
        System.out.println(Constants.DEPARTMENT_NOT_FOUND);

    }

    public void viewDepartmentDetails(){

        String id = InputHandler.getStringInput("Enter Department ID: ");

        for(Department d : departments){

            if(d.getDepartmentId().equals(id)){
                d.displayInfo();
                return;
            }
        }

        System.out.println(Constants.DEPARTMENT_NOT_FOUND);
    }
    public void updateDepartment() {
        String departmentId = InputHandler.getStringInput("Enter department ID: ");
        Department existingDepartment = getDepartmentById(departmentId);
        if (HelperUtils.isNull(existingDepartment)) {
            return;
        }

        String departmentName = InputHandler.getStringInput("Enter new department name: ");
        String headDoctorId   = InputHandler.getStringInput("Enter new head doctor ID: ");
        int bedCapacity   = InputHandler.getIntInput("Enter new bed capacity: ");
        int availableBeds   = InputHandler.getIntInput("Enter new available beds: ");

        Department updatedDepartment = new Department();
        updatedDepartment.setDepartmentId(departmentId);
        updatedDepartment.setDepartmentName(departmentName);
        updatedDepartment.setHeadDoctorId(headDoctorId);
        updatedDepartment.setBedCapacity(bedCapacity);
        updatedDepartment.setAvailableBeds(availableBeds);

        edit(updatedDepartment);
    }

    public void viewDepartmentStatistics() {
        if (HelperUtils.isNull(departments)) {
            System.out.println(Constants.DEPARTMENT_NOT_FOUND);
            return;
        }
        System.out.println("Department Statistics ");
        for (Department d : departments) {
            System.out.println("Department : " + d.getDepartmentName());
            System.out.println("Doctors   : " + d.getDoctors().size());
            System.out.println("Nurses   : " + d.getNurses().size());
            System.out.println("Bed Capacity: " + d.getBedCapacity());
            System.out.println("Available Beds : " + d.getAvailableBeds());

            System.out.println();
        }
    }



    public void handleDepartmentMenu() {
        boolean departmentExit = true;
        while (departmentExit) {
            System.out.println(MenuMessages.DEPARTMENT_MENU_MESSAGE);

            int option = InputHandler.getIntInput(Constants.ENTER_OPTION, 0, 7);
            switch (option) {
                case 1 ->
                        addDepartment();
                case 2 ->
                        getDepartments();
                case 3 ->
                        viewDepartmentDetails();

                case 4-> {
                    String doctorId     = InputHandler.getStringInput("Enter doctor ID: ");
                    String departmentId = InputHandler.getStringInput("Enter department ID: ");
                    assignDoctorToDepartment(doctorId,departmentId);
                }
                case 5-> {
                    String nurseId     = InputHandler.getStringInput("Enter Nurse ID: ");
                    String departmentId = InputHandler.getStringInput("Enter department ID: ");
                    assignNurseToDepartment(nurseId,departmentId);
                }
                case 6 ->
                        updateDepartment();
                case 7->
                        viewDepartmentStatistics();
                case 0->
                        departmentExit = false;

            }
        }
    }

    @Override
    public void edit(Object updatedData) {
        Department updatedDepartment = (Department) updatedData;
        for (Department d : departments) {
            if (d.getDepartmentId().equals(updatedDepartment.getDepartmentId())) {
                d.setDepartmentName(updatedDepartment.getDepartmentName());
                d.setHeadDoctorId(updatedDepartment.getHeadDoctorId());
                d.setBedCapacity(updatedDepartment.getBedCapacity());
                d.setAvailableBeds(updatedDepartment.getAvailableBeds());
                System.out.println(Constants.DEPARTMENT_UPDATED_SUCCESSFULLY);
                return;
            }
        }
        System.out.println(Constants.DEPARTMENT_NOT_FOUND);

    }

    @Override
    public void validate() {

    }

    public void departmentOccupancyReport() {
        System.out.println(" Department Occupancy Report");
        if (HelperUtils.isNull(departments)) {
            System.out.println("No departments found");
            return;
        }

        for (Department department : departments) {
            int occupiedBeds = department.getBedCapacity() - department.getAvailableBeds();
            System.out.println("Department: " + department.getDepartmentName() );
            department.displaySummary();
            System.out.println("Bed Capacity: " + department.getBedCapacity());
            System.out.println("Available Beds: " + department.getAvailableBeds());
            System.out.println("Occupied Beds: " + occupiedBeds);
            System.out.println("");
        }
    }
}