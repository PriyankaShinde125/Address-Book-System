package org.example;

import java.util.Scanner;

public class Contact {
    private String firstName;
    private String lastName;
    private Long phoneNumber;
    private String emailId;
    private Address address;

    public Contact(String firstName, String lastName, Long phoneNumber, String emailId, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.address = address;
    }

    public Contact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your details to create contact : ");
        System.out.print(" First name = ");
        firstName = sc.next();
        System.out.print("\n Last name = ");
        lastName = sc.next();
        System.out.print("\n Phone no = ");
        phoneNumber = Long.valueOf(sc.next());
        System.out.print("\n Email Id = ");
        emailId = sc.next();
        address = new Address();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "{ First name = " + firstName + "\n Lastname = " + lastName + "\n Phone number = " + phoneNumber + "\n Email Id = " + emailId + "\n Address = " + address + "}";
    }
}
