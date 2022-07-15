package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMain {

    private HashMap<String, ArrayList<Collection>> addressBook;
    private static ArrayList<Collection> record;

    public AddressBookMain() {
        record=new ArrayList<Collection>();
        addressBook = new HashMap<String, ArrayList<Collection>>();
    }

    public void display() {
        for (Collection obj:record) {
            obj.display();
        }
    }

    public void display(Collection obj) {
        obj.display();
    }

    public void addToRecord(Collection obj,String bookname) {
        try {
            record.add(new Collection(obj.firstName, obj.lastName, obj.address,
                    obj.city,obj.state, obj.zipCode, obj.phoneNumber, obj.email));
            addBookMap(bookname, record);
        }catch(NullPointerException e) {}
    }

    public void addBookMap(String bookName, ArrayList<Collection> obj) {
        addressBook.put(bookName, obj);
    }

    public static Collection add() {

        //method for adding new entries.
        Scanner sc=new Scanner(System.in);
        String firstName;					//Attributes to be added
        String lastName;
        String address;
        String city;
        String state;
        long zipCode;
        String phoneNo;
        String email;

        //asking user input
        System.out.println("Please enter details to be added.");
        System.out.print("First Name: ");
        firstName=sc.next();
        System.out.print("Last Name: ");
        lastName=sc.next();

        //Checking for duplicates
        if (record.stream().anyMatch(obj -> obj.firstName.equals(firstName))
                && record.stream().anyMatch(obj -> obj.lastName.equals(lastName))) {
            System.out.println("This contact already existes. Resetting");
            add();
            return null;
        }

        System.out.print("Address: ");
        address=sc.next();
        System.out.print("City: ");
        city=sc.next();
        System.out.print("State: ");
        state=sc.next();
        System.out.print("ZipCode: ");
        zipCode=sc.nextLong();
        System.out.print("Phone No.: ");
        phoneNo=sc.next();
        System.out.print("Email: ");
        email=sc.next();

        //saving as new entry
        Collection entry=new Collection(firstName,lastName,
                address,city,state,zipCode,phoneNo,email);
        return entry;					//returning entry to main
    }

    public static ArrayList<Collection> edit(ArrayList<Collection> list, String name) {

        //method for edit
        Scanner sc=new Scanner(System.in);
        boolean flag=false;
        name.replaceAll("\\P{Print}","");
        String lower_name=name.toLowerCase();
        for (Collection obj:list) {
            String firstName=obj.firstName.toLowerCase();
            String lastName=obj.lastName.toLowerCase();
            if (firstName.equals(lower_name) ||
                    lastName.equals(lower_name)) {
                flag=true;
                System.out.println("Please enter new details.");
                System.out.print("Address: ");
                obj.address=sc.next();
                System.out.print("City: ");
                obj.city=sc.next();
                System.out.print("State: ");
                obj.state=sc.next();
                System.out.print("ZipCode: ");
                obj.zipCode=sc.nextLong();
                System.out.print("Phone No.: ");
                obj.phoneNumber=sc.next();
                System.out.print("Email: ");
                obj.email=sc.next();

                System.out.println("Record updated.");
                break;
            }
        }
        if (flag==false) {
            System.out.println("No entry found for "+name);
        }
        return list;
    }

    public static ArrayList<Collection> delete(ArrayList<Collection> list, String name) {

        //method for delete
        Scanner sc=new Scanner(System.in);
        boolean flag=false;
        name.replaceAll("\\P{Print}","");
        String lower_name=name.toLowerCase();

        try {
            for (Collection obj:list) {
                String firstName=obj.firstName.toLowerCase();
                String lastName=obj.lastName.toLowerCase();
                if (firstName.equals(lower_name) ||
                        lastName.equals(lower_name)) {
                    flag=true;

                    System.out.println("Record deleted for "+obj.firstName+" "+obj.lastName);
                    list.remove(obj);			//delete entry from record
                    System.out.println("Record updated.");
                }
            }
        }catch(Exception e) {}
        if (flag==false) {
            System.out.println("No entry found for "+name);
        }
        return list;
    }

    public void searchContactAll(String contactFirstName,
                                 String contactLastName, String LocationName) {

        record.stream().filter(obj -> (
                        ((obj.city.equals(LocationName)) || (obj.state.equals(LocationName)))	//checking for city/state match
                                &&(obj.firstName.equals(contactFirstName))								//checking for first name match
                                &&(obj.lastName.equals(contactLastName))								//checking for last name match
                ))

                .forEach(
                        this::display
                );
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        AddressBookMain buildObj=new AddressBookMain();

        //Creating first entry
        Collection entry1=new Collection("Chetan", "Gavanali",
                "Mutaga", "Belgaum", "Karnataka", 591124, "9449441490",
                "chetangavanali@gmail.com");
        buildObj.addToRecord(entry1,"AddressBook1");				//Adding entry to record
        System.out.println(entry1);

        //Creating second entry
        Collection entry2=new Collection("ABCD", "EFGH",
                "IJKL", "MNOP", "QRST", 123456, "1234567890",
                "abcd@gmail.com");
        buildObj.addToRecord(entry2,"AddressBook1");				//Adding entry to record
        System.out.println(entry2);

        //initiating user functions of entries

        String user_input="1";
        while((user_input.equals("1") || user_input.equals("2") || user_input.equals("3") || user_input.equals("4"))) {

            // Checking in address list is present in hashmap
            System.out.print("Enter the Name of the Address Book: ");
            String bookName = sc.next();
            if (buildObj.addressBook.containsKey(bookName)) {
                buildObj.record = buildObj.addressBook.get(bookName);
            }

            else {
                System.out.println("Address book with name " + bookName + " not found. Creating a new entry");
                buildObj.addBookMap(bookName,new ArrayList<Collection>());
            }

            System.out.println("Record "+bookName+" loaded.");

            System.out.println();				//Waiting for user input
            System.out.println("What now?");
            System.out.println("1. Add a new contact.");
            System.out.println("2. Edit an existing contact.");
            System.out.println("3. Delete an existing contact.");
            System.out.println("4. Search all.");
            System.out.println("5. Switch Directory");
            System.out.println("Logout");
            user_input=sc.next();

            switch(user_input) {

                case "1": {
                    Collection entry=buildObj.add();		//calling function to make new entry
                    buildObj.addToRecord(entry,bookName);			//Adding entry to record
                    System.out.println(entry);
                    break;
                }
                case "2": {
                    System.out.println("Please enter First/Last name of entry to be edited.");
                    String name=sc.next();
                    ArrayList<Collection> list = buildObj.edit(record,name);
                    break;
                }
                case "3": {
                    System.out.println("Please enter First/Last name of entry to be deleted.");
                    String name=sc.next();
                    record=delete(record,name);
                    break;
                }
                case "4": {
                    System.out.println("Please enter details to be searched.");
                    System.out.print("First Name: ");
                    String firstName=sc.next();
                    System.out.print("Last Name: ");
                    String lastName=sc.next();
                    System.out.print("City/State: ");
                    String location=sc.next();
                    buildObj.searchContactAll(firstName, lastName, location);
                    break;
                }
                case "5": {
                    user_input="1";
                    continue;
                }
                default:
                    break;
            }
        }

        //displaying all entries
        buildObj.display();
    }
}
