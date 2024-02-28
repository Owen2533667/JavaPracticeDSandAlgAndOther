package scanner;

import java.util.Scanner;

public class PersonCreator {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the name, age and phone number: ");
        String name = sc.next();
        int age = sc.nextInt();
        long phoneNumber = sc.nextLong();

        Person person = new Person(name, age, phoneNumber);

    }

}
