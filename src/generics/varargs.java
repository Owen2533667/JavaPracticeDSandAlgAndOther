package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class varargs {


    public static void main(String[] args) {
        printShoppingList("Bread", "Milk", "Eggs", "Bananas");
    }


    private static void printShoppingList (String... items) {
        System.out.println("SHOPPING LIST");
        for (int i = 0; i < items.length; i++) {
            System.out.println(i + 1 + ": " + items[i]);
        }
        System.out.println();
    }

}
