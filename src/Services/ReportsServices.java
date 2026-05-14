package Services;

import Entities.Patient;
import Utils.MenuMessages;

import java.util.Scanner;

public class ReportsServices {
    static MenuMessages menuMessages = new MenuMessages();
    static Scanner scanner = new Scanner(System.in);
    static PatientService patientService = new PatientService();

    public boolean HandleReportsMenu(){
        System.out.println(menuMessages.ReportsMenu);
        System.out.println("Please enter number");
        String reportOption = scanner.nextLine();
        switch (reportOption) {
            case  "7.1" -> {
                System.out.println("DAILY APPOINTMENTS REPORT");
                System.out.println("---------------------------------");
                System.out.println("Please enter the report: ");
                String report = scanner.nextLine();
                System.out.println(report);
            }
            case "7.2" -> {
                System.out.println("DOCTOR PERFORMANCE REPORT");
                System.out.println("---------------------------------");
                System.out.println("Please enter the report: ");
                String report = scanner.nextLine();
                System.out.println(report);
            }
            case "7.3" -> {
                System.out.println("DEPARTMENT OCCUPANCY REPORT");
                System.out.println("---------------------------------");
                System.out.println("Please enter the report: ");
                String report = scanner.nextLine();
                System.out.println(report);
            }

            case  "7.4" -> {
                System.out.println("PATIENT STATISTIC");
                patientService.displayPatients();
            }
            case "7.5" -> {
                System.out.println("EMERGENCY CASE REPORT");
                System.out.println("---------------------------------");
                System.out.println("Please enter the report: ");
                String report = scanner.nextLine();
                System.out.println(report);
            }
            case "7.6" -> {
                return false;
            }
        }
        return true;
    }
}