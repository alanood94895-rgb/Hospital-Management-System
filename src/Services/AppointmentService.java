package Services;

import Behaviour.Appointable;
import Behaviour.Manageable;
import Behaviour.Searchable;
import Entities.Appointment;
import Utils.Constants;
import Utils.HelperUtils;
import Utils.InputHandler;
import Utils.MenuMessages;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppointmentService implements Manageable , Searchable , Appointable {

    static Scanner scanner = new Scanner(System.in);
    private static List<Appointment> appointmentList = new ArrayList<>();

    public void createAppointment(Appointment appointment){
        // Integrate HelperUtils Throughout the System
        if(HelperUtils.isNotNull(appointment)){
            appointmentList.add(appointment);
            System.out.println(Constants.APPOINTMENT_ADDED_SUCCESSFULLY);}
    }

    public void addNewAppointment(){

        String patientId = InputHandler.getStringInput("Enter Patient Id: ");
        String doctorId = InputHandler.getStringInput("Enter Doctor Id: ");

        LocalDate appointmentDate = InputHandler.getDateInput("Enter Date: ");

        String appointmentTime = String.valueOf(InputHandler.getTimeInput("Enter Appointment Time: "));

        String reason = InputHandler.getStringInput("Enter reason: ");

        String notes = InputHandler.getStringInput("Enter notes: ");

        Appointment appointment = new Appointment(
                // Integrate HelperUtils Throughout the System
                HelperUtils.generateId("A",3),
                patientId,
                doctorId,
                appointmentDate,
                appointmentTime,
                "Scheduled",
                reason,
                notes
        );

        createAppointment(appointment );
    }

    public void editAppointment(String appointmentId, Appointment updatedAppointment){
        for(Appointment a : appointmentList){
            if (HelperUtils.isNotNull(a.getAppointmentId())
                    && a.getAppointmentId().equals(appointmentId)){

                a.setNotes(updatedAppointment.getNotes());
                a.setReason(updatedAppointment.getReason());
                System.out.println(Constants.APPOINTMENT_UPDATED_SUCCESSFULLY);
                return;
            }
        }
        System.out.println(Constants.APPOINTMENT_NOT_FOUND);
    }
    public void rescheduleAppointment(String appointmentId, LocalDate newDate, String newTime){

        for(Appointment a : appointmentList){
            if (HelperUtils.isNotNull(a.getAppointmentId())
                    && a.getAppointmentId().equals(appointmentId) ){
                if (HelperUtils.isPastDate(a.getAppointmentDate(),newDate)){
                    System.out.println("Invalid Date");
                    return;
                }
                a.setAppointmentDate(newDate);
                a.setAppointmentTime(newTime);
                a.setStatus("Rescheduled");
                System.out.println(Constants.APPOINTMENT_RESCHEDULED_SUCCESSFULLY);
                return;
            }
        }
        System.out.println(Constants.APPOINTMENT_NOT_FOUND);

    }

    @Override
    public void scheduleAppointment(Appointment appointment) {
        for(Appointment p: appointmentList){
            if(p.getAppointmentId().equals(appointment.getAppointmentId())){
                return;
            }
        }
        appointmentList.add(appointment);

    }

    public void cancelAppointment(String appointmentId){
        for(Appointment a : appointmentList){
            if (HelperUtils.isNotNull(a.getAppointmentId())
                    && a.getAppointmentId().equals(appointmentId)){
                a.setStatus("Cancelled");
                System.out.println(Constants.APPOINTMENT_CANCELLED_SUCCESSFULLY);
                return;
            }
        }
        System.out.println(Constants.APPOINTMENT_NOT_FOUND);
    }

    public void getAppointmentsByPatient(String patientId) {

        if (HelperUtils.isNull(appointmentList)) {
            System.out.println("No Appointments");
            return;
        }

        boolean found = false;

        for (Appointment a : appointmentList) {
            if (a.getPatientId().equals(patientId)) {
                a.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println(Constants.APPOINTMENT_NOT_FOUND);
        }
    }

    public void getAppointmentsByDoctor(String doctorId) {

        if (HelperUtils.isNull(appointmentList)) {
            System.out.println("No Appointments");
            return;
        }

        boolean found = false;

        for (Appointment a : appointmentList) {
            if (a.getDoctorId().equals(doctorId)) {
                a.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println(Constants.APPOINTMENT_NOT_FOUND);
        }
    }

    public void displayAppointments(LocalDate date){
        if (HelperUtils.isNull(appointmentList)) {
            System.out.println("No Appointments");
            return;
        }

        boolean found = false;

        for (Appointment a : appointmentList) {
            if (a.getAppointmentDate().equals(date)) {
                a.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println(Constants.APPOINTMENT_NOT_FOUND);
        }
    }
    public void displayAppointments(){
        if(HelperUtils.isNull(appointmentList)){
            System.out.println("No Appointments");
            return;
        }
        for(Appointment a : appointmentList){
            a.displayInfo();
        }
    }

    public void createAppointment(String patientId, String doctorId, LocalDate date){
        Appointment appointment = new Appointment();

        appointment.setPatientId(patientId);
        appointment.setDoctorId(doctorId);
        appointment.setAppointmentDate(date);

        appointmentList.add(appointment);
    }

    public void createAppointment(String patientId, String doctorId, LocalDate date, String time){
        Appointment appointment = new Appointment();

        appointment.setPatientId(patientId);
        appointment.setDoctorId(doctorId);
        appointment.setAppointmentDate(date);
        appointment.setAppointmentTime(time);

        appointmentList.add(appointment);
    }

    public void rescheduleAppointment(String appointmentId, LocalDate newDate){
        for (Appointment appointment : appointmentList){
            if(appointment.getAppointmentId().equals(appointmentId)){
                if (HelperUtils.isPastDate(appointment.getAppointmentDate(),newDate)){
                    System.out.println(Constants.INVALID_DATE);
                    return;
                }
                appointment.setAppointmentDate(newDate);
                appointment.setStatus("Rescheduled");
                System.out.println(Constants.APPOINTMENT_RESCHEDULED_SUCCESSFULLY);
                return;
            }

        }
        System.out.println(Constants.APPOINTMENT_NOT_FOUND);
    }

    public void rescheduleAppointment(Appointment appointment, LocalDate newDate, String newTime, String reason){
        for (Appointment a : appointmentList){
            if(a.getAppointmentId().equals(appointment.getAppointmentId())){
                a.setAppointmentTime(newTime);
                a.setAppointmentDate(newDate);
                a.setReason(reason);
                a.setStatus("Rescheduled");
                System.out.println(Constants.APPOINTMENT_RESCHEDULED_SUCCESSFULLY);
                return;
            }


        }
        System.out.println(Constants.APPOINTMENT_NOT_FOUND);
    }

    public void displayAppointments(String doctorId, LocalDate startDate, LocalDate endDate){
        for(Appointment a : appointmentList){
            if(a.getDoctorId().equals(doctorId)
                    && !a.getAppointmentDate().isBefore(startDate) && !a.getAppointmentDate().isAfter(endDate)){
                a.displayInfo();
                return;
            }
        }
        System.out.println(Constants.APPOINTMENT_NOT_FOUND);
    }
    public void completeAppointment(String appointmentId){
        for(Appointment a : appointmentList){
            if (HelperUtils.isNotNull(a.getAppointmentId())
                    && a.getAppointmentId().equals(appointmentId)){
                a.setStatus("Completed");
                return;
            }
        }
        System.out.println(Constants.APPOINTMENT_NOT_FOUND);

    }
    public void ViewUpcomingAppointments(){
        if (HelperUtils.isNull(appointmentList)){
            System.out.println(Constants.APPOINTMENT_NOT_FOUND);
            return;
        }
        for(Appointment a : appointmentList){
            if(a.getAppointmentDate().isAfter(LocalDate.now())){
                a.displayInfo();
            }
        }

    }


    public void handleAppointmentMenu(){
        Boolean appointmentContinue = true;
        while (appointmentContinue) {
            System.out.println(MenuMessages.APPOINTMENT_MENU_MESSAGE);
            int option = InputHandler.getIntInput(Constants.ENTER_OPTION,0,9);
            switch (option) {
                case 1-> addNewAppointment();
                case 2-> displayAppointments();
                case 3-> getAppointmentsByPatient(InputHandler.getStringInput("Enter Patient ID: "));
                case 4-> getAppointmentsByDoctor(InputHandler.getStringInput("Enter Doctor ID: "));
                case 5-> displayAppointments(InputHandler.getDateInput("Enter Date: "));
                case 6->{
                    String id = InputHandler.getStringInput("Enter Appointment ID: ");
                    LocalDate newDate = InputHandler.getDateInput("Enter Appointment new Date: ");
                    String newTime = String.valueOf(InputHandler.getTimeInput("Enter Appointment new Time: "));
                    rescheduleAppointment(id,newDate,newTime);
                }
                case 7 -> cancelAppointment(InputHandler.getStringInput("Enter Appointment ID: "));
                case 8 -> completeAppointment(InputHandler.getStringInput("Enter Appointment ID: "));
                case 9 -> ViewUpcomingAppointments();
                case 0 ->{
                    appointmentContinue = false;
                }

            }

        }

    }


    @Override
    public void add(Object entity) {
        Appointment appointment = (Appointment) entity;
        appointmentList.add(appointment);

    }

    @Override
    public void remove(String id) {

        if (HelperUtils.isNull(appointmentList)) {
            System.out.println(Constants.APPOINTMENT_NOT_FOUND);
            return;
        }

        for (Appointment a : appointmentList) {
            if (a.getAppointmentId().equals(id)) {
                appointmentList.remove(a);
                System.out.println(Constants.APPOINTMENT_REMOVED_SUCCESSFULLY);
                return;
            }
        }

        System.out.println(Constants.APPOINTMENT_NOT_FOUND);
    }

    @Override
    public Void getAll() {

        if (HelperUtils.isNull(appointmentList)) {
            System.out.println(Constants.APPOINTMENT_NOT_FOUND);
            return null;
        }

        for (Appointment a : appointmentList) {
            a.displayInfo();
        }
        return null;
    }

    @Override
    public void search(String keyword) {

        if (HelperUtils.isNull(appointmentList)) {
            System.out.println(Constants.APPOINTMENT_NOT_FOUND);
            return;
        }

        boolean found = false;

        for (Appointment a : appointmentList) {

            if (a.getAppointmentId().contains(keyword)
                    || a.getDoctorId().contains(keyword)
                    || a.getPatientId().contains(keyword)) {

                a.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println(Constants.APPOINTMENT_NOT_FOUND);
        }
    }

    @Override
    public void searchById(String id) {
        if (HelperUtils.isNull(appointmentList)) {
            System.out.println(Constants.APPOINTMENT_NOT_FOUND);
            return;
        }
        for (Appointment a : appointmentList) {
            if (a.getAppointmentId().equals(id)) {
                a.displayInfo();
                return;
            }
        }

        System.out.println(Constants.APPOINTMENT_NOT_FOUND);
    }
}