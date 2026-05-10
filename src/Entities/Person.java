package Entities;

import java.time.LocalDate;

public class Person {
    private String id ;
    private String firstName ;
    private String lastName;
    private LocalDate dateOfBirth ;
    private String gender;
    private String phoneNumber;
    private String email;
    private String address;



    public Person(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender,
                  String phoneNumber, String email, String address) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;

        }
        public void displayInfo() {
            System.out.println("ID: " + id);
            System.out.println("Name: " + firstName + " " + lastName);
            System.out.println("DOB: " + dateOfBirth);
            System.out.println("Gender: " + gender);
            System.out.println("Phone: " + phoneNumber);
            System.out.println("Email: " + email);
            System.out.println("Address: " + address);
        }

}
}
