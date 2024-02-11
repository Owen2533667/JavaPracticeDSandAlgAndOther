package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsMethods {

    static Character[] charArry = {'h', 'e', 'l', 'l', 'o'};
    static Integer[] intArray = {1, 2, 3, 4, 5};
    static Boolean[] boolArray = {true, false, true};

    public static <T> List<T> arrayToList(T[] array, List<T> list) {
        for (T obj : array) {
            list.add(obj);
        }
        return list;
    }

    public static void main(String[] args) {
        List<Character> charList = arrayToList(charArry, new ArrayList<>());
        List<Integer> intList = arrayToList(intArray, new ArrayList<>());
        List<Boolean> boolList = arrayToList(boolArray, new ArrayList<>());
    }


}
