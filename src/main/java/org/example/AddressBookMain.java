package org.example;

import java.util.Scanner;

public class AddressBookMain {
    public static final int ADD_CONTACT = 1;
    public static final int EXIT = 0;
    public static final int EDIT_CONTACT = 2;
    public static final int DELETE_CONTACT = 3;
    AddressBook addressBook;

    public static void main(String[] args) {
        AddressBookMain main = new AddressBookMain();
        main.addressBook = new AddressBook();
        Scanner sc = new Scanner(System.in);
        String firstName;
        String lastName;
        while (true) {
            System.out.println("Enter your choice : \n1 : Add new contact to address book \n2 : Edit contact \n3 : Delete contact \n0 : Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case ADD_CONTACT:
                    main.addressBook.addContact();
                    System.out.println(main.addressBook);
                    break;
                case EDIT_CONTACT:
                    System.out.println("Enter first name ");
                    firstName = sc.next();
                    System.out.println("Enter last name ");
                    lastName = sc.next();
                    main.addressBook.editContact(firstName, lastName);
                    break;
                case DELETE_CONTACT:
                    System.out.println("Enter first name ");
                    firstName = sc.next();
                    System.out.println("Enter last name ");
                    lastName = sc.next();
                    main.addressBook.deleteContact(firstName, lastName);
                    break;
                case EXIT:
                    return;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }
}
