package Utils;

import Entities.Appointment;
import Entities.Department;
import Entities.Consultant;
import Entities.GeneralPractitioner;
import Entities.Surgeon;
import Entities.MedicalRecord;
import Entities.Nurse;
import Entities.EmergencyPatient;
import Entities.InPatient;
import Entities.OutPatient;
import Entities.Patient;
import Services.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class SampleData {

    public static void loadPatients() {
        DoctorService doctorService = new DoctorService();
        DepartmentService departmentService = new DepartmentService();
        PatientService patientService = new PatientService();
        MedicalRecordService medicalRecordService = new MedicalRecordService();
        AppointmentService appointmentService = new AppointmentService();


        departmentService.add(new Department("DEP-001", "Cardiology",     "DOC-001", 40));
        departmentService.add(new Department("DEP-002", "Neurology",      "DOC-002", 30));
        departmentService.add(new Department("DEP-003", "Pediatrics",     "DOC-003", 25));
        departmentService.add(new Department("DEP-004", "Emergency",      "DOC-004", 20));
        departmentService.add(new Department("DEP-005", "General Medicine","DOC-005", 50));


        Patient p1 = new Patient(
                "P001",
                "Adam",
                "Yusuf",
                LocalDate.of(1988,2,10),
                "Male",
                "91238976",
                "Adam@gmail.com",
                "Matrah",
                "O+",
                "90000111",
                LocalDate.now(),
                "INS001",
                new ArrayList<>(Arrays.asList("Cheeses"))
        );

        Patient p2 = new Patient(
                "P002",
                "Laila",
                "Hassan",
                LocalDate.of(1998,7,8),
                "Female",
                "92220000",
                "laila@gmail.com",
                "Nizwa",
                "AB",
                "90000222",
                LocalDate.now(),
                "INS102",
                new ArrayList<>(Arrays.asList("Milk"))
        );

        Patient p3 = new Patient(
                "P003",
                "Khalfan",
                "Ali",
                LocalDate.of(1997,10,12),
                "Male",
                "93330000",
                "khalfan@gmail.com",
                "Izki",
                "A+",
                "90000333",
                LocalDate.now(),
                "INS103",
                new ArrayList<>(Arrays.asList("Peanuts"))
        );

        InPatient p4 = new InPatient(
                "P004",
                "Mariam",
                "Salem",
                LocalDate.of(2010,5,25),
                "Female",
                "94440000",
                "mariam@gmail.com",
                "Sohar",
                "AB+",
                "90000444",
                LocalDate.now(),
                "INS104",
                new ArrayList<>(Arrays.asList()),
                LocalDate.of(2026,3,1),
                LocalDate.of(2026,3,15),
                "Room-08",
                "Bed-2",
                "D301",
                4.0
        );

        OutPatient p5 = new OutPatient(
                "P005",
                "Salim",
                "Rashid",
                LocalDate.of(2000,11,19),
                "Male",
                "95550000",
                "salim@gmail.com",
                "Sur",
                "B+",
                "90000555",
                LocalDate.now(),
                "INS105",
                new ArrayList<>(Arrays.asList("Eggs")),
                4,
                LocalDate.of(2026,4,11),
                "D401"
        );

        OutPatient p6 = new OutPatient(
                "P006",
                "Abdullah",
                "Naser",
                LocalDate.of(2002,10,12),
                "Male",
                "96784321",
                "yousef@gmail.com",
                "Salalah",
                "B-",
                "90000666",
                LocalDate.now(),
                "INS006",
                new ArrayList<>(Arrays.asList()),
                2,
                LocalDate.of(2026,3,1),
                "D101"
        );

        OutPatient p7 = new OutPatient(
                "P007",
                "Noor",
                "Ahmed",
                LocalDate.of(1999,3,12),
                "Female",
                "91234567",
                "Noor@gmail.com",
                "Adam",
                "A+",
                "90000777",
                LocalDate.now(),
                "INS007",
                new ArrayList<>(Arrays.asList("Seafood")),
                4,
                LocalDate.of(2026,4,1),
                "D102"
        );

        InPatient p8 = new InPatient(
                "P008",
                "Hajer",
                "Hamad",
                LocalDate.of(2001,3,22),
                "Female",
                "96578888",
                "Hajer@gmail.com",
                "Salalah",
                "O+",
                "90000888",
                LocalDate.now(),
                "INS008",
                new ArrayList<>(Arrays.asList("Milk")),
                LocalDate.of(2026,8,10),
                LocalDate.of(2026,8,12),
                "Room-8",
                "Bed-6",
                "D103",
                5.0
        );

        InPatient p9 = new InPatient(
                "P009",
                "Hoor",
                "Said",
                LocalDate.of(2003,10,8),
                "Female",
                "92123434",
                "Hoor@gmail.com",
                "Seeb",
                "AB",
                "90000999",
                LocalDate.now(),
                "INS009",
                new ArrayList<>(Arrays.asList("Dust")),
                LocalDate.of(2026,3,23),
                LocalDate.of(2026,3,30),
                "Room-07",
                "Bed-7",
                "D104",
                4.5
        );

        EmergencyPatient p10 = new EmergencyPatient(
                "P010",
                "Saif",
                "Rashid",
                LocalDate.of(1978,4,21),
                "Male",
                "98765432",
                "saif@gmail.com",
                "Saham",
                "B-",
                "90000000",
                LocalDate.now(),
                "INS010",
                new ArrayList<>(Arrays.asList("Milk")),
                LocalDate.of(2026,5,1),
                LocalDate.of(2026,5,5),
                "ER-01",
                "Bed-ER",
                "D105",
                8.0,
                "Accident",
                "Ambulance",
                1,
                true
        );
        patientService.add(p1);
        patientService.add(p2);
        patientService.add(p3);
        patientService.add(p4);
        patientService.add(p5);
        patientService.add(p6);
        patientService.add(p7);
        patientService.add(p8);
        patientService.add(p9);
        patientService.add(p10);


        //Doctors sample data

        Consultant d1 = new Consultant(
                "D001",
                "Said",
                "Abdullah",
                LocalDate.of(2000,6,22),
                "Male",
                "91111111",
                "Said@hospital.com",
                "Muscat",
                "Cardiology",
                "MBBS",
                15,
                "DEP01",
                25.0
        );

        Consultant d2 = new Consultant(
                "D002",
                "Alanoud",
                "Mohammed",
                LocalDate.of(2003,7,2),
                "Female",
                "92222222",
                "Alanoud@hospital.com",
                "Matrah",
                "Dermatology",
                "MD",
                12,
                "DEP02",
                20.0
        );

        GeneralPractitioner d3 = new GeneralPractitioner(
                "D003",
                "Sultan",
                "Khalid",
                LocalDate.of(1999,10,5),
                "Male",
                "93333333",
                "hassan@hospital.com",
                "Sur",
                "General Medicine",
                "MBBS",
                18,
                "DEP03",
                18.5,
                true,
                true,
                true
        );

        GeneralPractitioner d4 = new GeneralPractitioner(
                "D004",
                "Noof",
                "Mohanned",
                LocalDate.of(1990,11,25),
                "Female",
                "94444444",
                "Noof@hospital.com",
                "Muscat",
                "Family Medicine",
                "MBBS",
                8,
                "DEP03",
                15.0,
                true,
                false,
                true
        );

        Surgeon d5 = new Surgeon(
                "D005",
                "Ismail",
                "Bader",
                LocalDate.of(1988,11,3),
                "Male",
                "95555555",
                "Ismail@hospital.com",
                "Muscat",
                "Orthopedic Surgery",
                "PhD",
                20,
                "DEP04",
                40.0,
                350,
                true
        );

        Surgeon d6 = new Surgeon(
                "D006",
                "Safa",
                "Hamed",
                LocalDate.of(1988,7,14),
                "Female",
                "96666666",
                "Safa@hospital.com",
                "seeb",
                "Neurosurgery",
                "MD",
                10,
                "DEP04",
                50.0,
                120,
                true
        );

        Consultant d7 = new Consultant(
                "D007",
                "Alazhar",
                "Zahran",
                LocalDate.of(1980,10,28),
                "Male",
                "97777777",
                "Alazhar@hospital.com",
                "Barka",
                "Pediatrics",
                "MBBS",
                14,
                "DEP05",
                22.0
        );

        GeneralPractitioner d8 = new GeneralPractitioner(
                "D008",
                "Shahad",
                "Mohammed",
                LocalDate.of(2005,12,18),
                "Female",
                "98888888",
                "Shahad@hospital.com",
                "Barka",
                "General Practice",
                "MBBS",
                6,
                "DEP03",
                17.0,
                false,
                true,
                false
        );


        //sample data for databases
        Nurse n1 = new Nurse(
                "N001",
                "Ibtisam",
                "Mansoor",
                LocalDate.of(2002,2,10),
                "Female",
                "91112222",
                "Ibtisam@hospital.com",
                "Muscat",
                "DEP01",
                "Morning",
                "BSc Nursing"
        );

        Nurse n2 = new Nurse(
                "N002",
                "Rashed",
                "Salim",
                LocalDate.of(1990,6,13),
                "Male",
                "92223333",
                "Rashed@hospital.com",
                "Sohar",
                "DEP02",
                "Night",
                "Diploma Nursing"
        );

        Nurse n3 = new Nurse(
                "N003",
                "Muna",
                "Nasser",
                LocalDate.of(1989,11,15),
                "Female",
                "93334444",
                "Muna@hospital.com",
                "Nizwa",
                "DEP03",
                "Evening",
                "BSc Nursing"
        );

        Nurse n4 = new Nurse(
                "N004",
                "Amjad",
                "Ali",
                LocalDate.of(2000,1,13),
                "Male",
                "94445555",
                "Amjad@hospital.com",
                "Nizwa",
                "DEP04",
                "Morning",
                "MSc Nursing"
        );

        Nurse n5 = new Nurse(
                "N005",
                "Muneraa",
                "Mansur",
                LocalDate.of(1990,3,3),
                "Female",
                "95556666",
                "Muneraa@hospital.com",
                "Sur",
                "DEP05",
                "Night",
                "BSc Nursing"
        );

        // Department sample data

        Department dep1 = new Department(
                "DEP01",
                "Cardiology",
                "D001",
                50
        );

        Department dep2 = new Department(
                "DEP02",
                "Dermatology",
                "D002",
                30
        );

        Department dep3 = new Department(
                "DEP03",
                "General Medicine",
                "D003",
                70
        );

        //Appointment sample data

        Appointment a1 = new Appointment(
                "A001",
                "P001",
                "D001",
                LocalDate.of(2026,5,15),
                "07:30 AM",
                "Scheduled",
                "Heart Checkup",
                "Patient experiencing chest pain"
        );

        Appointment a2 = new Appointment(
                "A002",
                "P002",
                "D002",
                LocalDate.of(2026,5,16),
                "10:00 AM",
                "Completed",
                "Skin Allergy",
                "Prescribed allergy medication"
        );

        Appointment a3 = new Appointment(
                "A003",
                "P003",
                "D003",
                LocalDate.of(2026,5,17),
                "01:00 PM",
                "Scheduled",
                "General Fever",
                "Follow-up after medication"
        );

        Appointment a4 = new Appointment(
                "A004",
                "P005",
                "D004",
                LocalDate.of(2026,5,18),
                "09:45 AM",
                "Cancelled",
                "Routine Checkup",
                "Patient cancelled due to travel"
        );

        Appointment a5 = new Appointment(
                "A005",
                "P008",
                "D005",
                LocalDate.of(2026,5,19),
                "03:00 PM",
                "Scheduled",
                "Knee Surgery Consultation",
                "MRI results attached"
        );

        Appointment a6 = new Appointment(
                "A006",
                "P004",
                "D001",
                LocalDate.of(2026,5,20),
                "08:00 AM",
                "Scheduled",
                "Asthma Checkup",
                "Follow-up on inhaler usage"
        );

        Appointment a7 = new Appointment(
                "A007",
                "P006",
                "D002",
                LocalDate.of(2026,5,21),
                "11:30 AM",
                "Completed",
                "Back Pain Review",
                "Improvement observed"
        );

        Appointment a8 = new Appointment(
                "A008",
                "P007",
                "D003",
                LocalDate.of(2026,5,22),
                "12:15 AM",
                "Scheduled",
                "Cold & Fever",
                "Initial consultation"
        );

        Appointment a9 = new Appointment(
                "A009",
                "P008",
                "D004",
                LocalDate.of(2026,5,23),
                "03:00 PM",
                "Scheduled",
                "Injury Follow-up",
                "Check healing progress"
        );

        Appointment a10 = new Appointment(
                "A010",
                "P009",
                "D005",
                LocalDate.of(2026,5,24),
                "09:30 AM",
                "Completed",
                "Anemia Check",
                "Iron levels improving"
        );

        Appointment a11 = new Appointment(
                "A011",
                "P010",
                "D006",
                LocalDate.of(2026,5,25),
                "02:15 PM",
                "Scheduled",
                "Fracture Review",
                "X-ray follow-up needed"
        );

        Appointment a12 = new Appointment(
                "A012",
                "P003",
                "D007",
                LocalDate.of(2026,5,26),
                "03:00 PM",
                "Cancelled",
                "General Checkup",
                "Patient unavailable"
        );

        Appointment a13 = new Appointment(
                "A013",
                "P002",
                "D008",
                LocalDate.of(2026,5,27),
                "09:00 AM",
                "Scheduled",
                "Skin Review",
                "Monitor allergy reaction"
        );

        Appointment a14 = new Appointment(
                "A014",
                "P001",
                "D002",
                LocalDate.of(2026,5,28),
                "10:45 AM",
                "Completed",
                "Hypertension Follow-up",
                "Blood pressure stable"
        );

        Appointment a15 = new Appointment(
                "A015",
                "P005",
                "D003",
                LocalDate.of(2026,5,29),
                "11:30 AM",
                "Scheduled",
                "General Consultation",
                "Routine checkup"
        );

        //Medical records sample data
        MedicalRecord mr1 = new MedicalRecord(
                "MR001",
                "P001",
                "D001",
                LocalDate.of(2026,5,1),
                "Hypertension",
                "Amlodipine 5mg",
                "Blood pressure slightly high",
                "Patient advised to reduce salt intake"
        );

        MedicalRecord mr2 = new MedicalRecord(
                "MR002",
                "P002",
                "D002",
                LocalDate.of(2026,5,2),
                "Skin Allergy",
                "Antihistamine tablets",
                "Allergy test positive",
                "Avoid seafood and dust exposure"
        );

        MedicalRecord mr3 = new MedicalRecord(
                "MR003",
                "P003",
                "D003",
                LocalDate.of(2026,5,3),
                "Viral Fever",
                "Paracetamol 500mg",
                "Blood test normal",
                "Rest and hydration recommended"
        );

        MedicalRecord mr4 = new MedicalRecord(
                "MR004",
                "P005",
                "D004",
                LocalDate.of(2026,5,4),
                "Migraine",
                "Ibuprofen",
                "CT scan normal",
                "Patient should avoid stress"
        );

        MedicalRecord mr5 = new MedicalRecord(
                "MR005",
                "P008",
                "D005",
                LocalDate.of(2026,5,5),
                "Knee Injury",
                "Pain relief medication",
                "MRI shows ligament tear",
                "Surgery may be required"
        );

        MedicalRecord mr6 = new MedicalRecord(
                "MR006",
                "P006",
                "D006",
                LocalDate.of(2026,5,6),
                "Back Pain",
                "Muscle Relaxant",
                "X-ray normal",
                "Physiotherapy recommended"
        );

        MedicalRecord mr7 = new MedicalRecord(
                "MR007",
                "P007",
                "D007",
                LocalDate.of(2026,5,7),
                "Common Cold",
                "Cough Syrup",
                "Temperature slightly elevated",
                "Drink warm fluids"
        );

        MedicalRecord mr8 = new MedicalRecord(
                "MR008",
                "P009",
                "D008",
                LocalDate.of(2026,5,8),
                "Anemia",
                "Iron Supplements",
                "Hemoglobin level low",
                "Follow-up after one month"
        );

        MedicalRecord mr9 = new MedicalRecord(
                "MR009",
                "P010",
                "D005",
                LocalDate.of(2026,5,9),
                "Fracture",
                "Painkillers",
                "X-ray confirms arm fracture",
                "Cast applied successfully"
        );

        MedicalRecord mr10 = new MedicalRecord(
                "MR010",
                "P001",
                "D003",
                LocalDate.of(2026,5,10),
                "Diabetes",
                "Metformin",
                "Blood sugar elevated",
                "Daily exercise advised"
        );

        MedicalRecord mr11 = new MedicalRecord(
                "MR011",
                "P004",
                "D001",
                LocalDate.of(2026,5,11),
                "Asthma",
                "Inhaler",
                "Breathing test abnormal",
                "Avoid dust and smoke"
        );

        MedicalRecord mr12 = new MedicalRecord(
                "MR012",
                "P002",
                "D004",
                LocalDate.of(2026,5,12),
                "Vitamin D Deficiency",
                "Vitamin D Capsules",
                "Vitamin D level low",
                "Sun exposure recommended"
        );



    }
}