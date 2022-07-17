package com.bridgelabz;


public class Collection {

    public String firstName;
    public String lastName;
    public String address;
    public String city;
    public String state;
    public long zipCode;

    public String phoneNumber;
    public String email;

    public Collection(String firstName, String lastName, String address,
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
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Address: " + address);
        System.out.println("City: " + city);
        System.out.println("State: " + state);
        System.out.println("Zip: " + zipCode);
        System.out.println("Phone No.: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.println("------------------------------------------------------");
        System.out.println();
    }

    @Override
    public String toString() {
        System.out.println();
        return "Created entry for " + firstName + " " + lastName;
    }


    public static <U extends Comparable<? super U>, T> U getFirstName(T t) {
        return null;
    }
}