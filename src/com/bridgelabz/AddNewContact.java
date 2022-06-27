package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddNewContact {
    public String firstName;
    public String lastName;
    public String address;
    public String city;
    public String state;
    public long zipCode;

    public String phoneNumber;
    public String email;

    public AddNewContact(String firstName, String lastName, String address,
                          String city, String state, long zipCode,
                          String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void display() {

        System.out.println("------------------------------------------------------");
        System.out.println("Name: "+firstName+" "+lastName);
        System.out.println("Address: "+address);
        System.out.println("City: "+city);
        System.out.println("State: "+state);
        System.out.println("Zip: "+zipCode);
        System.out.println("Phone No.: "+phoneNumber);
        System.out.println("Email: "+email);
        System.out.println("------------------------------------------------------");
        System.out.println();
    }

    @Override
    public String toString() {
        return "Created object for "+firstName+" "+lastName;
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        ArrayList<AddNewContact> record=new ArrayList<AddNewContact>();


        AddNewContact entry1=new AddNewContact("Chetan ", "Gavanali",
                "Mutaga", "Belgaum", "Karnataka", 591124, "9449441490",
                "chetangavanali@gmail.com");
        record.add(entry1);
        System.out.println(entry1);

        AddNewContact entry2=new AddNewContact("ABCD", "EFGH",
                "IJKL", "MNOP", "QRST", 123456, "1234567890",
                "abcd@gmail.com");
        record.add(entry2);
        System.out.println(entry2);

        String firstName;
        String lastName;
        String address;
        String city;
        String state;
        long zipCode;
        String phoneNumber;
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
        phoneNumber=sc.next();
        System.out.print("Email: ");
        email=sc.next();

        AddNewContact entry3=new AddNewContact(firstName,lastName,
                address,city,state,zipCode,phoneNumber,email);
        record.add(entry3);
        System.out.println(entry3);

        entry1.display();
        entry2.display();
        entry3.display();
    }
}
