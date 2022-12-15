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

    public static void main(String[] args) {
        AddressBookDictionary addressBookDictionary = new AddressBookDictionary();
        Scanner sc = new Scanner(System.in);
        String firstName;
        String lastName;
        addressBookDictionary.addAddressBooks();
        AddressBook addressBook;
        while (true) {
            System.out.println("Enter your choice : \n1 : Add new contact to address book \n2 : Edit contact \n3 : Delete contact \n4 : Create new address book \n5 : Print address book dictionary \n0 : Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case ADD_CONTACT:
                    System.out.println("How many contacts do you want to create ? ");
                    int numberOfContacts = sc.nextInt();
                    for (int i = 0; i < numberOfContacts; i++) {
                        Contact contact = new Contact();
                        if(addressBookDictionary.isExistContact(contact)){
                            System.out.println("Already exist. Try with another name");
                            i--;
                        }else {
                            addressBook = addressBookDictionary.selectAddressBook();
                            addressBook.addContact(contact);
                        }
                    }
                    break;
                case EDIT_CONTACT:
                    System.out.println("Enter first name ");
                    firstName = sc.next();
                    System.out.println("Enter last name ");
                    lastName = sc.next();
                    addressBook = addressBookDictionary.getAddressBook(firstName, lastName);
                    if (addressBook != null)
                        addressBook.editContact(firstName, lastName);
                    else System.out.println("No Match Found");
                    break;
                case DELETE_CONTACT:
                    System.out.println("Enter first name ");
                    firstName = sc.next();
                    System.out.println("Enter last name ");
                    lastName = sc.next();
                    addressBook = addressBookDictionary.getAddressBook(firstName, lastName);
                    if (addressBook != null)
                        addressBook.deleteContact(firstName, lastName);
                    else System.out.println("No Match Found");
                    break;
                case CREATE_ADDRESS_BOOK:
                    addressBookDictionary.addAddressBooks();
                    break;
                case PRINT_ADDRESS_BOOK_DICTIONARY:
                    System.out.println(addressBookDictionary.addressBookDictionary);
                    break;
                case EXIT:
                    return;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }






}
