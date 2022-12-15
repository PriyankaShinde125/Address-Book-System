package org.example;

import java.util.ArrayList;
import java.util.stream.Stream;

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
        StringBuilder builder = new StringBuilder();
        builder.append("AddressBook : \n");
        Stream.of(contactList).forEach(contact -> builder.append(contact));
        return builder.toString();
    }
}
