package org.example;

import java.util.Scanner;

public class Contact {
    public static final int FIRST_NAME = 1;
    public static final int LAST_NAME = 2;
    public static final int PHONE_NUMBER = 3;
    public static final int EMAIL_ID = 4;
    public static final int AREA = 5;
    public static final int CITY = 7;
    public static final int STATE = 8;
    public static final int ZIP = 9;
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

    @Override
    public boolean equals(Object obj) {
        Contact c = (Contact) obj;
        return firstName.equals(c.firstName) && lastName.equals(c.lastName);
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

    public void edit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter which field do you want to edit : ");
        System.out.println("1 : First name \n2 : Last name \n3 : Phone no \n4 : Email Id \n5 : Area \n6 : City \n7 : State \n8 : Zip");
        int choice = sc.nextInt();
        switch (choice) {
            case FIRST_NAME:
                System.out.println("Enter new first name ");
                setFirstName(sc.next());
                break;
            case LAST_NAME:
                System.out.println("Enter Last name = ");
                setLastName(sc.next());
                break;
            case PHONE_NUMBER:
                System.out.println("Enter Phone no = ");
                setPhoneNumber(Long.parseLong(sc.next()));
                break;
            case EMAIL_ID:
                System.out.println("Enter Email Id = ");
                setEmailId(sc.next());
                break;
            case AREA:
                System.out.println("Enter Area = ");
                address.setArea(sc.next());
                break;
            case CITY:
                System.out.println("Enter city = ");
                address.setArea(sc.next());
                break;
            case STATE:
                System.out.println("Enter state = ");
                address.setState(sc.next());
                break;
            case ZIP:
                System.out.println("Enter Zip = ");
                address.setZip(Integer.parseInt(sc.next()));
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
    }
}
