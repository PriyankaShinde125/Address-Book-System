package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddressBookDictionary {
    HashMap<String, AddressBook> addressBookDictionary;

    public AddressBookDictionary() {
        addressBookDictionary = new HashMap<>();
    }

    public HashMap<String, AddressBook> getAddressBookDictionary() {
        return addressBookDictionary;
    }

    public void setAddressBookDictionary(HashMap<String, AddressBook> addressBookDictionary) {
        this.addressBookDictionary = addressBookDictionary;
    }

    void addAddressBooks() {
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

    public boolean isExistContact(Contact contact) {
        for (AddressBook addressBook : addressBookDictionary.values()) {
            boolean isContainContact = addressBook.getContactList().stream().anyMatch(contactEntry -> contactEntry.equals(contact));
            if (isContainContact)
                return true;
        }
        return false;
    }

    public List<Contact> getContactFromCityOrState(String cityOrState, boolean isSearchByCity) {
        List<Contact> contacts = new ArrayList<>();
        if (isSearchByCity) {
            for (AddressBook addressBook : addressBookDictionary.values()) {
               addressBook.getContactList().stream().filter(contactEntry -> contactEntry.getAddress().getCity().equals(cityOrState)).forEach(contact -> contacts.add(contact));
            }
        } else {
            for (AddressBook addressBook : addressBookDictionary.values()) {
               addressBook.getContactList().stream().filter(contactEntry -> contactEntry.getAddress().getState().equals(cityOrState)).forEach(contact -> contacts.add(contact));
            }
        }
        return contacts;
    }
}
