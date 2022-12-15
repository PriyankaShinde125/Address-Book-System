package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    ArrayList<Contact> contactList;

    public AddressBook() {
        contactList = new ArrayList<Contact>();
    }

    public ArrayList<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(ArrayList<Contact> contactList) {
        this.contactList = contactList;
    }

    @Override
    public String toString() {
        return " contactList = \n" + contactList;
    }

    public void addContact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many contacts do you want to create ? ");
        int numberOfContacts = sc.nextInt();
        for (int i = 0; i < numberOfContacts; i++) {
            Contact contact = new Contact();
            contactList.add(contact);
        }
    }

    public void editContact(String firstName, String lastName) {
        Contact contact = contactList.stream()
                .filter(tempContact -> firstName.equals(tempContact.getFirstName()) && lastName.equals(tempContact.getLastName()))
                .findAny()
                .orElse(null);
        if (contact != null) {
            System.out.println("Your details : " + contact);
            contact.edit();
            System.out.println("Edited : " + contact);
        } else
            System.out.println("Contact not found");
    }

    public void deleteContact(String firstName, String lastName) {
        Contact contact = contactList.stream()
                .filter(tempContact -> firstName.equals(tempContact.getFirstName()) && lastName.equals(tempContact.getLastName()))
                .findAny()
                .orElse(null);
        if (contact != null) {
            contactList.remove(contact);
            System.out.println("Deleted : " + contact);
        } else
            System.out.println("Contact not available");
    }
}
