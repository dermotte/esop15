package at.aau.esop15.course05;

class Person {
    String name;
    String phoneNumber;
}

class PhoneBook {
    Person[] data;
}


/**
 * @author Dr. Mathias Lux, 05.11.2015.
 */
public class PhoneBookProgram {
    public static void main(String[] args) {
        PhoneBook book = new PhoneBook();
        book.data = new Person[10];

        book.data[0] = new Person();
        book.data[0].name = "Alice";
        book.data[0].phoneNumber = "1";

        book.data[1] = new Person();
        book.data[1].name = "Bob";
        book.data[1].phoneNumber = "2";

        book.data[2] = new Person();
        book.data[2].name = "Charlie";
        book.data[2].phoneNumber = "3";

    }
}

