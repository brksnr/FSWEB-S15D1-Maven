package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber, List<Contact> contacts) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>(contacts);
    }

    public String getMyNumber() {
        return myNumber;
    }

    public ArrayList<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact prm){
        if(myContacts.contains(prm)){
            return false;
        }else{
            myContacts.add(prm);
            return true;
        }
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int oldContactIndex = myContacts.indexOf(oldContact);

        if (oldContactIndex < 0) {
            return false;
        }
        for (Contact contact : myContacts) {
            if (!contact.equals(oldContact) &&
                    (contact.getName().equals(newContact.getName()) || contact.getPhoneNumber().equals(newContact.getPhoneNumber()))) {
                return false;
            }
        }
        myContacts.set(oldContactIndex, newContact);
        return true;
    }

    public boolean removeContact(Contact contact) {
        int contactIndex = findContact(contact);
        if (contactIndex > 0) {
            myContacts.remove(contactIndex);
            System.out.println("Silindi: " + contact.getName());
            return true;
        }else{
            return false;
        }
    }

    public int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    public int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(name)) {
                return i;
            }

        }
        return -1;
    }

    public Contact queryContact(String name) {
        int index = findContact(name);
        if (index >= 0) {
            return myContacts.get(index);
        }
        return null;
    }

    public void printContact() {
        System.out.println("Contact List:");
        for (Contact contact : myContacts) {
            System.out.println(contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }



}
