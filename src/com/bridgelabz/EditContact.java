package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class EditContact {

    public String firstName;
    public String lastName;
    public String address;
    public String city;
    public String state;
    public long zipCode;

    public String phoneNumber;
    public String email;

    public EditContact(String firstName, String lastName, String address,
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

    public static ArrayList<EditContact> edit(ArrayList<EditContact> list, String name) {

        Scanner sc=new Scanner(System.in);
        boolean flag=false;
        name.replaceAll("\\P{Print}","");
        String lower_name=name.toLowerCase();
        for (EditContact obj:list) {
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

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        ArrayList<EditContact> record=new ArrayList<EditContact>();

        EditContact entry1=new EditContact("Chetan", "Gavanali",
                "Mutaga", "Belgaum", "Karnataka", 591124, "9449441490",
                "chetangavanali@gmail.com");
        record.add(entry1);
        System.out.println(entry1);

        EditContact entry2=new EditContact("ABCD", "EFGH",
                "IJKJL", "MNOP", "QRST", 13456, "9449441490",
                "ABCD@gmail.com");
        record.add(entry2);
        System.out.println(entry2);

        System.out.println("Please enter First/Last name of entry to be edited.");
        String name=sc.next();
        record=edit(record,name);

        entry1.display();
        entry2.display();
    }
}

