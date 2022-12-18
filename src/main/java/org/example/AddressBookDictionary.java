package org.example;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
        System.out.println("In which of the following do you want to store contact? : ");
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
            boolean isContainContact = addressBook
                    .getContactList()
                    .stream()
                    .anyMatch(contact -> firstName.equals(contact.getFirstName()) && lastName.equals(contact.getLastName()));
            if (isContainContact)
                return addressBook;
        }
        return null;
    }

    public boolean isExistContact(Contact contact) {
        for (AddressBook addressBook : addressBookDictionary.values()) {
            boolean isContainContact = addressBook
                    .getContactList()
                    .stream()
                    .anyMatch(contactEntry -> contactEntry.equals(contact));
            if (isContainContact)
                return true;
        }
        return false;
    }

    public void getContactFromCityOrState(String cityOrState, boolean isSearchByCity) {
        List<Contact> contacts = new ArrayList<>();
        for (AddressBook addressBook : addressBookDictionary.values()) {
            addressBook.getContactList()
                    .stream()
                    .filter(getContactByCityOrStatePredicate(cityOrState, isSearchByCity))
                    .forEach(contacts::add);
        }
        contacts.forEach(System.out::println);
    }

    private static Predicate<Contact> getContactByCityOrStatePredicate(String cityOrState, boolean isSearchByCity) {
        if (isSearchByCity)
            return contactEntry -> contactEntry.getCity().equals(cityOrState);
        else
            return contactEntry -> contactEntry.getState().equals(cityOrState);
    }

    public Map<String, List<Contact>> getCityWiseOrStateWiseContacts(boolean isCityWise) {
        Map<String, List<Contact>> map = new HashMap<>();
        addressBookDictionary.values().forEach(addressBook -> {
            addressBook.getContactList()
                    .stream().collect(getStateWiseOrCityWiseContactMapCollector(isCityWise))
                    .forEach((key, value) -> {
                        if (map.containsKey(key)) {
                            map.get(key).addAll(value);
                        } else {
                            map.put(key, value);
                        }
                    });
        });
        map.forEach((key, value) -> System.out.println("City = " + key + "\nContacts = " + value));
        return map;
    }


    private static Collector<Contact, ?, Map<String, List<Contact>>> getStateWiseOrCityWiseContactMapCollector(boolean isCityWise) {
        if (isCityWise)
            return Collectors.groupingBy(Contact::getCity);
        else
            return Collectors.groupingBy(Contact::getState);
    }

    public void getCityWiseContactsCount() {
        getCityWiseOrStateWiseContacts(true).forEach((key, value) -> System.out.println("State = " + key + "\nContacts = " + value.size()));
    }

    public void getStateWiseContactsCount() {
        getCityWiseOrStateWiseContacts(false).forEach((key, value) -> System.out.println("State = " + key + "\nContacts = " + value.size()));
    }

    public void sortAddressBookEntries() {
        addressBookDictionary.values().stream().flatMap(addressBook -> addressBook.getContactList().stream()).sorted(Contact::compareTo).collect(Collectors.toList()).stream().forEach(System.out::println);
    }
}
