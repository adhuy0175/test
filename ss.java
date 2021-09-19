package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static ArrayList<Contact> contacts;
    private static Scanner scanner;
    private static int id = 0;


    public static void main(String[] args) {
         /**
         * Simulate your phone's contacts and messages applications
         *
         * Greet the user
         * Show these 3 options 1. Manage contacts 2. Messages 3.Quit
         * In case of selecting 1 --> show these options:
         *      1. Show all contacts
         *      2. Add a new contacts
         *      3. Search for a contacts
         *      4. Delete a contact
         *      5. Go back to the previous menu
         * In case of 2 --> show these options:
         *      1. See the list of all messages
         *      2. Send a new message
         *      3. Go back to the previous menu
         * In case of 3 --> Quit the application
         */
        contacts = new ArrayList<>();
        System.out.println("Welcome to my humble world of programming");
        showIntialOptions();


    }
    private static void showIntialOptions(){
        System.out.println("Please select one: " +
                "\n\t1. Message Contacts" +
                "\n\t2. Message" +
                "\n\t3. Quit");

        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch(choice){
            case 1:
                manageContacts();
                break;
            case 2:
                manageMessage();
                break;
                default:
                    break;
        }
    }

    private static void manageMessage() {
        System.out.println("Please select one:" +
                "\n\t1. Show all messages" +
                "\n\t2. Send a new message" +
                "\n\t3. Go back");
        int choice = scanner.nextInt();
        switch(choice){
            case 1:
                showAllContact();
                break;
            case 2:
                sendNewMessage();
                break;
            default:
                showIntialOptions();
                break;
        }
    }

    private static void sendNewMessage() {
        System.out.println("Who are you going to send the message?");
        String name = scanner.next();
        if(name.equals("")){
            System.out.println("Please enter the name of the contact");
            sendNewMessage();
        }else {
            boolean doesExist = false;
            for(Contact c: contacts){
                if(c.getName().equals(name)){
                    doesExist = true;
                }
            }

            if(doesExist){
                System.out.println("What are you going to say?");
                String text = scanner.next();
                if(text.equals("")){
                    System.out.println("Please enter some message");
                    sendNewMessage();
                }else{
                    id++;
                    Message newMessage = new Message(text, name, id);
                    for(Contact c: contacts){
                        if(c.getName().equals(name)){
                            ArrayList<Message> newMessages = c.getMessages();
                            newMessages.add(newMessage);
                            Contact currentContact = c;
                            currentContact.setMessages(newMessages);
                            contacts.remove(c);
                            contacts.add(currentContact);
                        }
                    }
                }
            }else{
                System.out.println("There is no such contact");
            }
        }
        showIntialOptions();
    }

    private static void manageContacts(){
        System.out.println("Please select one: " +
                "\n\t1. Show all contacts" +
                "\n\t2. Add a new contact" +
                "\n\t3. Search for a contact" +
                "\n\t4. Delete a contact" +
                "\n\t5. Go back");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                showAllMessage();
                break;
            case 2:
                addNewContact();
                break;
            case 3:
                searchForContact();
                break;
            case 4:
                deleteContact();
                break;
                default:
                    showIntialOptions();
                    break;
        }
    }

    private static void showAllMessage() {
        ArrayList<Message> allMessages = new ArrayList<>();
        for (Contact c: contacts){
            allMessages.addAll(c.getMessages());
        }
        if(allMessages.size() > 0){
            for(Message m: allMessages){
                m.getDetail();
                System.out.println("***********");
            }
        }else{
            System.out.println("You don't have any message");
        }
    }

    private static void deleteContact() {
        System.out.println("Please enter the contact's name:");
        String name = scanner.next();
        if(name.equals("")){
            System.out.println("Please enter the name:");
            deleteContact();
        }else {
            boolean doesExist = false;
            for(Contact c : contacts){
                if(c.getName().equals(name)){
                    doesExist = true;
                    contacts.remove(c);
                }
            }
            if(!doesExist){
                System.out.println("There is no such contact");
            }
        }
        showIntialOptions();
    }


    private static void searchForContact() {
        System.out.println("Please enter the contacts name:");
        String name = scanner.next();
        if(name.equals("")){
            System.out.println("Please enter the name");
            searchForContact();
        }else {
            boolean doesExist = false;
            for(Contact c: contacts){
                if(c.getName().equals(name)){
                    doesExist = true;
                    c.getDetails();
                }
            }
            if(!doesExist){
                System.out.println("There is no such contact in your phone");
            }
        }
        showIntialOptions();
    }

    private static void addNewContact() {
        System.out.println("Adding a new contact..." +
                "\n Please enter the contact's name:");
        String name = scanner.next();
        System.out.println("Please enter the contact's number:");
        String number = scanner.next();
        System.out.println("Please enter the contact's email:");
        String email = scanner.next();

        if(name.equals("") || number.equals("") || email.equals("")){
            System.out.println("Please enter all of the information");
            addNewContact();
        }else{

            boolean doesExist = false;
            for(Contact c: contacts){
                if(c.getName().equals(name)){
                    doesExist = true;
                }
            }
            if(doesExist){
                System.out.println("We have contact of name " + name + " save on this device");
                addNewContact();
            }else {
                Contact contact = new Contact(name, number, email);
                contacts.add(contact);
                System.out.println(name + " add successfully");
            }

        }
        showIntialOptions();
    }

    private static void showAllContact() {
        for(Contact c: contacts){
            c.getDetails();
            System.out.println("**********");
        }

        showIntialOptions();
    }


}