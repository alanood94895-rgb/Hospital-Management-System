package Entities;

import java.time.LocalDate;
import java.util.Objects;

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

        // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
