import Menu.Menu;
import Services.*;
import Utils.Constants;
import Utils.InputHandler;
import Utils.MenuMessages;
import Utils.SampleData;

import java.util.Scanner;

public class MainApp{

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        PatientService patientService = new PatientService();
        DoctorService doctorService = new DoctorService();
        NurseService nurseService = new NurseService();
        MedicalRecordService medicalRecordService = new MedicalRecordService();
        DepartmentService departmentService = new DepartmentService();
        AppointmentService appointmentService = new AppointmentService();
        ReportsServices reportsServices = new ReportsServices();

        Boolean mainMenuContinue = true;
        while (mainMenuContinue) {
            System.out.println(MenuMessages.MAIN_MENU_MESSAGE);
            int choice = InputHandler.getIntInput(Constants.ENTER_OPTION, 1, 8);


            System.out.println("********** Hospital Management System **********");
            System.out.print(MenuMessages.MAIN_MENU_MESSAGE);
            System.out.print("Select an option: ");

            Integer option = Integer.parseInt(input.nextLine());

            switch (option) {

                case 1 -> {
                    Boolean patientMenuContinue = true;

                    while (patientMenuContinue) {

                        System.out.println("Patient Menu");
                        System.out.print(MenuMessages.PATIENT_MENU_MESSAGE);
                        System.out.print("Enter your choice: ");

                        Integer patientOption =
                                Integer.parseInt(input.nextLine());

                        patientService.handlePatientMenu();
                    }
                }
                case 2 -> {
                    Boolean deptMenuContinue = true;

                    while (deptMenuContinue) {

                        System.out.println("Department Menu");
                        System.out.print(MenuMessages.DEPARTMENT_MENU_MESSAGE);

                        Integer deptOption =
                                Integer.parseInt(input.nextLine());

                        departmentService.handleDepartmentMenu();
                    }
                }


                case 3 -> {
                    Boolean doctorMenuContinue = true;

                    while (doctorMenuContinue) {

                        System.out.println("Doctor Menu");
                        System.out.print(MenuMessages.DOCTOR_MENU_MESSAGE);

                        Integer doctorOption =
                                Integer.parseInt(input.nextLine());

                        doctorService.handleDoctorMenu();
                    }
                }

                case 4 -> {
                    Boolean nurseMenuContinue = true;

                    while (nurseMenuContinue) {

                        System.out.println("Nurse Menu");
                        System.out.print(MenuMessages.NURSE_MENU_MESSAGE);

                        Integer nurseOption =
                                Integer.parseInt(input.nextLine());

                        nurseService.handleNurseMenu();
                    }
                }

                case 5 -> {
                    Boolean recordMenuContinue = true;

                    while (recordMenuContinue) {

                        System.out.println("Medical Record Menu");
                        System.out.print(MenuMessages.MEDICAL_RECORD_MENU_MESSAGE);

                        Integer recordOption =
                                Integer.parseInt(input.nextLine());

                        medicalRecordService.handleMedicalRecordMenu();
                    }
                }

                case 6 -> {
                    Boolean appointmentMenuContinue = true;

                    while (appointmentMenuContinue) {

                        System.out.println("Appointment Menu");
                        System.out.print(MenuMessages.APPOINTMENT_MENU_MESSAGE);

                        Integer appointmentOption =
                                Integer.parseInt(input.nextLine());

                        appointmentService.handleAppointmentMenu();
                    }
                }

                case 7 -> {
                    ;
                    boolean exit = true;
                    while (exit) {
                        System.out.println(MenuMessages.ReportsMenu);
                        switch (InputHandler.getIntInput(Constants.ENTER_OPTION, 0, 5)) {
                            case 1 -> appointmentService.ViewUpcomingAppointments();
                            case 2-> {;
                            }
                            case 3 -> departmentService.departmentOccupancyReport();
                            case 4 -> patientService.patientStatisticsReport();
                            case 5 -> patientService.emergencyCasesReport();
                            case 0 -> exit = false;
                        }

                }
                }



                case 8 -> {
                    System.out.println("Exiting System...");
                    mainMenuContinue = false;
                }

                default -> {
                    System.out.println("Select a valid option.");
                }
            }
        }
    }
}