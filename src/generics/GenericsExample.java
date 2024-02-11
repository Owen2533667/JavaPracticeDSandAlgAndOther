package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsExample {

    public static void main(String[] args) {
        //Example without generics
        List names = new ArrayList<>();
        names.add("Kelly");
        String name = (String) names.get(0);
        System.out.println("first name:" + name);


        //example with generics
        List<String> names2 = new ArrayList<>();
        names2.add("Kelly");
        String name2 = names2.get(0);
        System.out.println("first name: " + name2);
    }

}
