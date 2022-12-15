package org.example;

import java.util.Scanner;

public class AddressBookMain {
    AddressBook addressBook;

    public static void main(String[] args) {
        AddressBookMain main = new AddressBookMain();
        main.addressBook = new AddressBook();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your choice : \n1 : Add new contact to address book \n2 : Edit contact \n0 : Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case Constants.ADD_CONTACT:
                    main.addressBook.addContact();
                    System.out.println(main.addressBook);
                    break;
                case Constants.EDIT_CONTACT:
                    System.out.println("Enter first name ");
                    String firstName = sc.next();
                    System.out.println("Enter last name ");
                    String lastName = sc.next();
                    main.addressBook.editContact(firstName, lastName);
                    break;
                case Constants.EXIT:
                    return;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }
}
