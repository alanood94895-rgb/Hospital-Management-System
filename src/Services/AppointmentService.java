package Services;

import Entities.Appointment;
import Utils.Constants;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppointmentService {
    static Scanner scanner = new Scanner(System.in);
    List<Appointment> appointmentList = new ArrayList<>();


    // ADD APPOINTMENT
    public void addAppointment(Appointment appointment) {

        appointmentList.add(appointment);
        System.out.println(Constants.APPOINTMENT_ADDED_SUCCESSFULLY);
    }


    // CREATE APPOINTMENT OBJECT

    public Appointment addNewAppointment() {

        System.out.println("Enter appointment Id:");
        String appointmentId = scanner.nextLine();

        System.out.println("Enter patient Id:");
        String patientId = scanner.nextLine();

        System.out.println("Enter Doctor Id:");
        String doctorId = scanner.nextLine();

        LocalDate appointmentDate = LocalDate.now();

        System.out.println("Enter Appointment Time:");
        String appointmentTime = scanner.nextLine();

        System.out.println("Enter status (Scheduled/Completed/Cancelled/Rescheduled):");
        String status = scanner.nextLine();

        System.out.println("Enter reason:");
        String reason = scanner.nextLine();

        System.out.println("Enter notes:");
        String notes = scanner.nextLine();

        Appointment appointment = new Appointment(
                        appointmentId,
                        patientId,
                        doctorId,
                        appointmentTime,
                        appointmentDate,
                        status,
                        reason,
                        notes
                );

        return appointment;
    }


    // EDIT APPOINTMENT
    public void editAppointment(String appointmentId, Appointment updatedAppointment) {
        for (Appointment a : appointmentList) {
            if (a.getAppointmentId().equals(appointmentId)) {
                a.setNotes(updatedAppointment.getNotes());
                a.setReason(updatedAppointment.getReason());
                System.out.println(Constants.APPOINTMENT_UPDATED_SUCCESSFULLY);

                return;
            }
        }

        System.out.println(Constants.APPOINTMENT_NOT_FOUND);
    }


    // RESCHEDULE APPOINTMENT
    public void rescheduleAppointment(String appointmentId, LocalDate newDate, String newTime) {

        for (Appointment a : appointmentList) {
            if (a.getAppointmentId().equals(appointmentId)) {
                a.setAppointmentDate(newDate);
                a.setAppointmentTime(newTime);
                a.setStatus("Rescheduled");
                System.out.println(Constants.APPOINTMENT_RESCHEDULED_SUCCESSFULLY);

                return;
            }
        }
        System.out.println(Constants.APPOINTMENT_NOT_FOUND);
    }

    // ==================================================
    // CANCEL APPOINTMENT
    // ==================================================

    public void cancelAppointment(String appointmentId) {

        for (Appointment a : appointmentList) {

            if (
                    a.getAppointmentId()
                            .equals(appointmentId)
            ) {

                a.setStatus("Cancelled");

                System.out.println(
                        Constants.APPOINTMENT_CANCELLED_SUCCESSFULLY
                );

                return;
            }
        }

        System.out.println(
                Constants.APPOINTMENT_NOT_FOUND
        );
    }

    // ==================================================
    // GET BY PATIENT ID
    // ==================================================

    public void getAppointmentsByPatient(String patientId) {

        for (Appointment a : appointmentList) {

            if (
                    a.getPatientId()
                            .equals(patientId)
            ) {

                a.displayInfo();
            }
        }
    }

    // FIXED NAME (was wrong in your code)
    public void getAppointmentsByPatientId(String patientId) {

        getAppointmentsByPatient(patientId);
    }

    // ==================================================
    // GET BY DOCTOR ID
    // ==================================================

    public void getAppointmentsByDoctor(String doctorId) {

        for (Appointment a : appointmentList) {

            if (
                    a.getDoctorId()
                            .equals(doctorId)
            ) {

                a.displayInfo();
            }
        }
    }

    // ==================================================
    // GET BY DATE
    // ==================================================

    public void getAppointmentsByDate(LocalDate date) {

        for (Appointment a : appointmentList) {

            if (
                    a.getAppointmentDate()
                            .equals(date)
            ) {

                a.displayInfo();
            }
        }
    }

    // ==================================================
    // DISPLAY ALL
    // ==================================================

    public void displayAllAppointments() {

        for (Appointment a : appointmentList) {

            a.displayInfo();
        }
    }

    // ==================================================
    // HANDLE MENU
    // ==================================================

    public Boolean handleAppointmentMenu(Integer option) {

        switch (option) {

            case 1 -> {

                Appointment appointment =
                        addNewAppointment();

                addAppointment(appointment);
            }

            case 2 -> {

                System.out.print(
                        "Enter ID to reschedule: "
                );

                String id =
                        scanner.nextLine().trim();

                System.out.print(
                        "Enter New Date (YYYY-MM-DD): "
                );

                String dateStr =
                        scanner.nextLine().trim();

                LocalDate date =
                        LocalDate.parse(dateStr);

                System.out.print(
                        "Enter New Time: "
                );

                String time =
                        scanner.nextLine().trim();

                rescheduleAppointment(id, date, time);
            }

            case 3 -> {

                System.out.print(
                        "Enter ID to cancel: "
                );

                cancelAppointment(
                        scanner.nextLine().trim()
                );
            }

            case 4 -> {

                System.out.print(
                        "Enter Patient ID: "
                );

                getAppointmentsByPatientId(
                        scanner.nextLine().trim()
                );
            }

            case 5 -> {

                System.out.print(
                        "Enter Doctor ID: "
                );

                getAppointmentsByDoctor(
                        scanner.nextLine().trim()
                );
            }

            case 6 -> {

                System.out.print(
                        "Enter Date (YYYY-MM-DD): "
                );

                getAppointmentsByDate(
                        LocalDate.parse(
                                scanner.nextLine().trim()
                        )
                );
            }

            case 7 -> {

                displayAllAppointments();
            }

            case 8 -> {

                return false;
            }

            default -> {

                System.out.println("Invalid option.");
            }
        }

        return true;
    }
}