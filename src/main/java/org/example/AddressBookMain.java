package org.example;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to address book");
        AddressBook addressBook = new AddressBook();
        String firstName = "Priyanka";
        String lastName = "Shinde";
        String phoneNo = "9518905320";
        String emailId = "pshinde@gmail.com";
        String area = "Bhugaon";
        String city = "Pune";
        String state = "Maharashtra";
        int zip = 412115;
        Address postalAddress = new Address(area, city, state, zip);
        Contact contact = new Contact(firstName, lastName, Long.parseLong(phoneNo), emailId, postalAddress);
        addressBook.getContactList().add(contact);
        System.out.println(addressBook);
    }
}
