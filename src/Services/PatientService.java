package Services;

import Entities.Patient;
import Utils.Constants;

import java.io.Console;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PatientService {
    static Scanner scanner = new Scanner(System.in);
    private List<Patient> patients = new ArrayList<>();

    public void addPatients(){
        patients.add(addPatient());
        System.out.println("Press q to quit or enter key to continue:");
        if(scanner.nextLine().equalsIgnoreCase("q") ){
            return;
        }
        addPatients();

    }
    public Patient addPatient(){

        System.out.println("Enter patient id:");
        String id = scanner.nextLine();

        System.out.println("Enter first name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter last name:");
        String lastName = scanner.nextLine();

        System.out.println("Enter gender:");
        String gender = scanner.nextLine();

        System.out.println("Enter phone number:");
        String phone = scanner.nextLine();

        System.out.println("Enter date of birth (yyyy-MM-dd):");
        String DOB = scanner.nextLine();
        LocalDate dateOfBirth = LocalDate.parse(DOB);

        System.out.println("Enter email:");
        String email = scanner.nextLine();

        System.out.println("Enter address:");
        String address = scanner.nextLine();


        System.out.println("Enter blood group:");
        String bloodGroup = scanner.nextLine();

        System.out.println("Enter emergency contact:");
        String emergencyContact = scanner.nextLine();

        System.out.println("Enter insurance ID:");
        String insuranceId = scanner.nextLine();

        System.out.println("Do have any allergies? (yes/no)");
        String hasAllergies = scanner.nextLine();

        List<String> allergies = new ArrayList<>();
        if(hasAllergies.equalsIgnoreCase("yes")){
            System.out.println("Enter allergies separated by commas:");
            String allergiesInput = scanner.nextLine();
            allergies.add(Arrays.toString(allergiesInput.split(",")));
        }

        Patient patient= new Patient(
                id,
                firstName,
                lastName,
                dateOfBirth,
                gender,
                phone,
                email,
                address,
                bloodGroup,
                emergencyContact,
                LocalDate.now(),
                insuranceId,
                allergies
        );


        System.out.println(Constants.PATIENT_ADDED_SUCCESSFULLY);
        return patient;

    }
    public void updatePatient(String patientId, Patient updatedPatient){
        for(Patient p : patients){

            if(p.getId().equals(patientId)){
                p.setPhoneNumber(updatedPatient.getPhoneNumber());
                p.setEmail(updatedPatient.getEmail());
                p.setAddress(updatedPatient.getAddress());

                System.out.println(Constants.PATIENT_UPDATED_SUCCESSFULLY);
                return;
            }

        }
        System.out.println(Constants.PATIENT_NOT_FOUND);

    }
    public void removePatient(String patientId){
        for(Patient p : patients){
            if(p.getId().equals(patientId)){
                patients.remove(p);
                System.out.println(Constants.PATIENT_REMOVED_SUCCESSFULLY);
            }
        }
    }
    public void getPatientById(String patientId){
        for(Patient p : patients){
            if(p.getId().equals(patientId)){
                p.displayInfo();
                return;
            }
        }
        System.out.println(Constants.PATIENT_NOT_FOUND);
    }

    public void searchPatientsByName(String name){
        for(Patient p : patients){
            if(p.getFirstName().equalsIgnoreCase(name) || p.getLastName().equalsIgnoreCase(name)){
                p.displayInfo();
            }
        }
    }

    public void displayAllPatients(){
        for(Patient p : patients){
            p.displayInfo();
        }
    }




}