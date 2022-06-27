package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class DeleteContact {
    public String firstName;
    public String lastName;
    public String address;
    public String city;
    public String state;
    public long zipCode;
    public String phoneNumber;
    public String email;

    public DeleteContact(String firstName, String lastName, String address,
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
        System.out.println("Phone Number.: "+phoneNumber);
        System.out.println("Email: "+email);
        System.out.println("------------------------------------------------------");
        System.out.println();
    }

    @Override
    public String toString() {
        return "Created object for "+firstName+" "+lastName;
    }

    public static ArrayList<DeleteContact> delete(ArrayList<DeleteContact> list, String name) {

        Scanner sc=new Scanner(System.in);
        boolean flag=false;
        name.replaceAll("\\P{Print}","");
        String lower_name=name.toLowerCase();

        try {
            for (DeleteContact obj:list) {
                String firstName=obj.firstName.toLowerCase();
                String lastName=obj.lastName.toLowerCase();
                if (firstName.equals(lower_name) ||
                        lastName.equals(lower_name)) {
                    flag=true;

                    System.out.println("Record deleted for "+obj.firstName+" "+obj.lastName);
                    list.remove(obj);
                    System.out.println("Record updated.");
                }
            }
        }catch(Exception e) {}
        if (flag==false) {
            System.out.println("No entry found for "+name);
        }
        return list;
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        ArrayList<DeleteContact> record=new ArrayList<DeleteContact>();

        DeleteContact entry1=new DeleteContact("Chetan", "Gavanali",
                "Mutaga", "Belgaum", "Karnataka", 591124, "9449441490",
                "chetangavanali@gmail.com");
        record.add(entry1);
        System.out.println(entry1);

        DeleteContact entry2=new DeleteContact("ABCD", "EFGH",
                "IJKL", "MNOP", "QRST", 123456, "1234567890",
                "abcd@gmail.com");
        record.add(entry2);
        System.out.println(entry2);

        System.out.println("Please enter First/Last name of entry to be deleted.");
        String name=sc.next();
        record=delete(record,name);

        for (DeleteContact obj:record) {
            obj.display();
        }
    }
}
