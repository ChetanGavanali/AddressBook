package com.bridgelabz;

public class CreateContacts {

    public String firstName;
    public String lastName;
    public String address;
    public String city;
    public String state;
    public long zipCode;

    public String phoneNumber;
    public String email;

    public CreateContacts(String firstName, String lastName, String address,
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

        CreateContacts entry1=new CreateContacts("Chetan", "Gavanali",
                "Mutaga", "Belgaum", "Karnataka", 591124, "9449441490",
                "chetangavanali@gmail.com");
        System.out.println(entry1);
        entry1.display();

        CreateContacts entry2=new CreateContacts("ABCD", "EFGH",
                "IJKL", "MNOP", "QRST", 123456, "1234567890",
                "abcd@gmail.com");
        System.out.println(entry2);
        entry2.display();
    }
}