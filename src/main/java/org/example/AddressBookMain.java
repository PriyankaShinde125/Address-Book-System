package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMain {
    public static final int ADD_CONTACT = 1;
    public static final int EXIT = 0;
    public static final int EDIT_CONTACT = 2;
    public static final int DELETE_CONTACT = 3;
    public static final int CREATE_ADDRESS_BOOK = 4;
    public static final int PRINT_ADDRESS_BOOK_DICTIONARY = 5;
    HashMap<String, AddressBook> addressBookDictionary;

    public static void main(String[] args) {
        AddressBookMain main = new AddressBookMain();
        main.addressBookDictionary = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String firstName;
        String lastName;
        main.addAddressBooks();
        AddressBook addressBook;
        while (true) {
            System.out.println("Enter your choice : \n1 : Add new contact to address book \n2 : Edit contact \n3 : Delete contact \n4 : Create new address book \n5 : Print address book dictionary \n0 : Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case ADD_CONTACT:
                    addressBook = main.selectAddressBook();
                    if (addressBook != null) {
                        addressBook.addContact();
                        System.out.println(addressBook);
                    }
                    break;
                case EDIT_CONTACT:
                    System.out.println("Enter first name ");
                    firstName = sc.next();
                    System.out.println("Enter last name ");
                    lastName = sc.next();
                    addressBook = main.getAddressBook(firstName, lastName);
                    if (addressBook != null)
                        addressBook.editContact(firstName, lastName);
                    else System.out.println("No Match Found");
                    break;
                case DELETE_CONTACT:
                    System.out.println("Enter first name ");
                    firstName = sc.next();
                    System.out.println("Enter last name ");
                    lastName = sc.next();
                    addressBook = main.getAddressBook(firstName, lastName);
                    if (addressBook != null)
                        addressBook.deleteContact(firstName, lastName);
                    else System.out.println("No Match Found");
                    break;
                case CREATE_ADDRESS_BOOK:
                    main.addAddressBooks();
                    break;
                case PRINT_ADDRESS_BOOK_DICTIONARY:
                    System.out.println(main.addressBookDictionary);
                    break;
                case EXIT:
                    return;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }

    private void addAddressBooks() {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many address book do you want to create ? ");
        int numberOfAddressBooks = sc.nextInt();
        for (int i = 0; i < numberOfAddressBooks; i++) {
            System.out.println("Enter address book name");
            String addressBookName = sc.next();
            if (addressBookDictionary.containsKey(addressBookName)) {
                System.out.println("Already exist . Try with another name");
                i--;
            } else
                addressBookDictionary.put(addressBookName, new AddressBook());
        }
    }

    AddressBook selectAddressBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select address book to create contact : ");
        ArrayList<String> addressBookNames = new ArrayList<String>(addressBookDictionary.keySet());
        for (int i = 0; i < addressBookNames.size(); i++) {
            System.out.println(i + 1 + " : " + addressBookNames.get(i));
        }
        int addressBookNameIndex = sc.nextInt() - 1;
        if (addressBookNameIndex >= addressBookNames.size()) {
            System.out.println("Address book not available. ");
            return null;
        }
        return addressBookDictionary.get(addressBookNames.get(addressBookNameIndex));
    }

    AddressBook getAddressBook(String firstName, String lastName) {
        for (AddressBook addressBook : addressBookDictionary.values()) {
            boolean isContainContact = addressBook.getContactList().stream().anyMatch(contact -> firstName.equals(contact.getFirstName()) && lastName.equals(contact.getLastName()));
            if (isContainContact)
                return addressBook;
        }
        return null;
    }
}
