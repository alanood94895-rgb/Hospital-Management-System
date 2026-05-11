package Entities;

import Entities.Doctor;
import Utils.Constants;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Surgeon extends Doctor {
    static Scanner scanner = new Scanner(System.in);
    private Integer surgeriesPerformed;
    private List<String> surgeryTypes;
    private Boolean operationTheatreAccess;


    public Surgeon(String id,
                   String firstName,
                   String lastName,
                   LocalDate dateOfBirth,
                   String gender,
                   String phoneNumber,
                   String email,
                   String address,
                   String specialization,
                   String qualification,
                   Integer experienceYears,
                   String departmentId,
                   double consultationFee ,
                   Integer surgeriesPerformed ,
                   Boolean operationTheatreAccess) {


        super( id,
                firstName,
                lastName,
                dateOfBirth,
                gender,
                phoneNumber,
                email,
                address,
                id,
                specialization,
                qualification,
                experienceYears,
                departmentId,
                consultationFee,
                new ArrayList<>(),
                new ArrayList<>()
        );


        this.surgeriesPerformed = surgeriesPerformed;
        this.operationTheatreAccess = operationTheatreAccess;
        this.surgeryTypes = new ArrayList<>();
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Surgeries Performed: " + surgeriesPerformed);
        System.out.println("Operation Theatre Access: " + operationTheatreAccess);
        for(String x : surgeryTypes){
            System.out.print(x + " , ");
        }
    }
    public void updateSurgeryCount(){
        surgeriesPerformed = surgeriesPerformed + 1 ;
    }

    public void performSurgery(){
        if(operationTheatreAccess){
            System.out.println(Constants.SURGEON_CAN_OPERATE);
            System.out.println("Enter surgery type: ");
            surgeryTypes.add(scanner.nextLine());
            updateSurgeryCount();

        }else{
            System.out.println(Constants.SURGEON_CANNOT_OPERATE);
        }

    }
}