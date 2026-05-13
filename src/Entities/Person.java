package Entities;

import Behaviour.Displayable;

import java.time.LocalDate;
import java.util.Objects;

public class Person implements Displayable {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private String phoneNumber;
    private String email;
    private String address;

    //constructor
    public Person(String id,
                  String firstName,
                  String lastName,
                  LocalDate dateOfBirth,
                  String gender,
                  String phoneNumber,
                  String email,
                  String address){

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Person() {

    }

    // getters ans setters
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Patient getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void displayInfo(){
        System.out.println("ID:"+ id);
        System.out.println("First Name:"+ firstName);
        System.out.println("Last Name:"+lastName );
        System.out.println("Date of Birth  :"+dateOfBirth );
        System.out.println("Gender:"+ gender);
        System.out.println("Phone Number  :"+ phoneNumber);
        System.out.println("Email:"+email );
        System.out.println("Address :"+ address);
    }

    @Override
    public void displaySummary() {

    }


    //toString Method
    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    // equals method
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(dateOfBirth, person.dateOfBirth) && Objects.equals(gender, person.gender) && Objects.equals(phoneNumber, person.phoneNumber) && Objects.equals(email, person.email) && Objects.equals(address, person.address);
    }
    //hashcode method
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}