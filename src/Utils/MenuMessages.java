package Utils;

public class MenuMessages {

    public static String MAIN_MENU_MESSAGE = """
            1. Patient Menu
            2. Department Menu
            3. Doctor Menu
            4. Nurse Menu
            5. Medical Record Menu
            6. Appointment Menu
            7. Reports and Statistics
            0. Exit
            """;
    public static String PATIENT_MENU_MESSAGE = """
            1.1 Register New Patient
            1.2 Register InPatient
            1.3 Register OutPatient
            1.4 Register Emergency Patient
            1.5 View All Patients
            1.6 Search Patient
            1.7 Update Patient Information
            1.8 Remove Patient
            1.9 View Patient Medical History
            0. Exit
            """;

    public static String DEPARTMENT_MENU_MESSAGE = """
           2.1 Add Department
           2.2 View All Departments
           2.3 View Department Details
           2.4 Assign Doctor to Department
           2.5 Assign Nurse to Department
           2.6 Update Department Information
           2.7 View Department Statistics
           0.Exit
            """;
    public static String DOCTOR_MENU_MESSAGE = """
            3.1 Add Doctor
            3.2 Add Surgeon
            3.3 Add Consultant
            3.4 Add General Practitioner
            3.5 View All Doctors
            3.6 Search Doctor by Specialization
            3.7 View Available Doctors
            3.8 Assign Patient to Doctor
            3.9 Update Doctor Information
            3.10 Remove Doctor
            0.Exit
            """;
    public static String NURSE_MENU_MESSAGE = """
            1. Add Nurse
            2. View All Nurses
            3. View Nurses by Department
            4. View Nurses by Shift
            5. Assign Nurse to Patient
            6. Update Nurse Information
            7. Remove Nurse
            0.Exit
            """;
    public static String MEDICAL_RECORD_MENU_MESSAGE = """
            1. Create Medical Record
            2. View All Records
            3. View Records by Patient
            4. View Records by Doctor
            5. Update Medical Record
            6. Delete Medical Record
            7. Generate Patient History Report
            0.Exit
            """;
    public static String APPOINTMENT_MENU_MESSAGE = """
            1. Schedule New Appointment
            2. View All Appointments
            3. View Appointments by Patient
            4. View Appointments by Doctor
            5. View Appointments by Date
            6. Reschedule Appointment
            7. Cancel Appointment
            8. Complete Appointment
            9. View Upcoming Appointments
            0.Exit
            """;

    static public String ReportsMenu ="""
                1. Daily Appointments Report
                2. Doctor Performance Report
                3. Department Occupancy Report
                4. Patient Statistics
                5. Emergency Cases Report
                0.Exit
                """;
}