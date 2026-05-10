package Services;

import Entities.Appointment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AppointmentService {

    private List<Appointment> appointments =
            new ArrayList<>();

    // CREATE - Add Appointment
    public void addAppointment(Appointment appointment) {

        appointments.add(appointment);

        System.out.println(
                "Appointment Added Successfully"
        );
    }

    // UPDATE - Edit Appointment
    public void editAppointment(String appointmentId,
                                Appointment updatedAppointment) {

        for (int i = 0; i < appointments.size(); i++) {

            if (appointments.get(i)
                    .getAppointmentId()
                    .equals(appointmentId)) {

                appointments.set(i, updatedAppointment);

                System.out.println(
                        "Appointment Updated Successfully"
                );

                return;
            }
        }

        System.out.println("Appointment Not Found");
    }

    // DELETE - Remove Appointment
    public void removeAppointment(String appointmentId) {

        boolean removed = appointments.removeIf(
                appointment ->
                        appointment.getAppointmentId()
                                .equals(appointmentId)
        );

        if (removed) {

            System.out.println(
                    "Appointment Removed Successfully"
            );

        } else {

            System.out.println("Appointment Not Found");
        }
    }

    // READ - Get By ID
    public Appointment getAppointmentById(String appointmentId) {

        for (Appointment appointment : appointments) {

            if (appointment.getAppointmentId()
                    .equals(appointmentId)) {

                return appointment;
            }
        }

        return null;
    }

    // Get Appointments By Patient
    public List<Appointment> getAppointmentsByPatient(
            String patientId) {

        List<Appointment> result =
                new ArrayList<>();

        for (Appointment appointment : appointments) {

            if (appointment.getPatientId()
                    .equalsIgnoreCase(patientId)) {

                result.add(appointment);
            }
        }

        return result;
    }

    // Get Appointments By Doctor
    public List<Appointment> getAppointmentsByDoctor(
            String doctorId) {

        List<Appointment> result =
                new ArrayList<>();

        for (Appointment appointment : appointments) {

            if (appointment.getDoctorId()
                    .equalsIgnoreCase(doctorId)) {

                result.add(appointment);
            }
        }

        return result;
    }

    // Get Appointments By Date
    public List<Appointment> getAppointmentsByDate(
            LocalDate date) {

        List<Appointment> result =
                new ArrayList<>();

        for (Appointment appointment : appointments) {

            if (appointment.getAppointmentDate()
                    .equals(date)) {

                result.add(appointment);
            }
        }

        return result;
    }

    // Reschedule Appointment
    public void rescheduleAppointment(
            String appointmentId,
            LocalDate newDate,
            String newTime) {

        for (Appointment appointment : appointments) {

            if (appointment.getAppointmentId()
                    .equals(appointmentId)) {

                appointment.reschedule(newDate, newTime);

                System.out.println(
                        "Appointment Rescheduled Successfully"
                );

                return;
            }
        }

        System.out.println("Appointment Not Found");
    }

    // Cancel Appointment
    public void cancelAppointment(String appointmentId) {

        for (Appointment appointment : appointments) {

            if (appointment.getAppointmentId()
                    .equals(appointmentId)) {

                appointment.cancel();

                System.out.println(
                        "Appointment Cancelled Successfully"
                );

                return;
            }
        }

        System.out.println("Appointment Not Found");
    }
}