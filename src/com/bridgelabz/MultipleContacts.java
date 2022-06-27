package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class MultipleContacts {
    private ArrayList<Collection> record;

    public MultipleContacts() {
        record=new ArrayList<Collection>();
    }

    public void display() {
        for (Collection obj:record) {
            obj.display();
        }
    }

    public void addToRecord(Collection obj) {
        record.add(new Collection(obj.firstName, obj.lastName, obj.address,
                obj.city,obj.state, obj.zipCode, obj.phoneNumber, obj.email));
    }

    public static Collection add() {

        Scanner sc=new Scanner(System.in);
        String firstName;
        String lastName;
        String address;
        String city;
        String state;
        long zipCode;
        String phoneNo;
        String email;

        System.out.println("Please enter details to be added.");
        System.out.print("First Name: ");
        firstName=sc.next();
        System.out.print("Last Name: ");
        lastName=sc.next();
        System.out.print("Address: ");
        address=sc.next();
        System.out.print("City: ");
        city=sc.next();
        System.out.print("State: ");
        state=sc.next();
        System.out.print("ZipCode: ");
        zipCode=sc.nextLong();
        System.out.print("Phone Number.: ");
        phoneNo=sc.next();
        System.out.print("Email: ");
        email=sc.next();

        Collection entry=new Collection(firstName,lastName,
                address,city,state,zipCode,phoneNo,email);
        return entry;
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        MultipleContacts buildObj=new MultipleContacts();
        Collection entry1=new Collection("Chetan", "Gavanali",
                "Mutaga", "Belgaum", "Karnataka", 591124, "9449441490",
                "chetangavanali@gmail.com");
        buildObj.addToRecord(entry1);
        System.out.println(entry1);

        Collection entry2=new Collection("ABCD", "EFGH",
                "IJKL", "MNOP", "QRST", 123456, "9449441490",
                "abcd@gmail.com");
        buildObj.addToRecord(entry2);
        System.out.println(entry2);

        String user_input="1";
        while(user_input.equals("1")) {

            Collection entry=buildObj.add();
            buildObj.addToRecord(entry);
            System.out.println(entry);

            System.out.println();
            System.out.println("Press 1 to add new entry");
            System.out.println("Press any other key to exit.");
            user_input=sc.next();
        }

        buildObj.display();
    }
}
