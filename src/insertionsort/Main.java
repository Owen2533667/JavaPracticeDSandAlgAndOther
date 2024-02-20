package insertionsort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


        // insertion sort = after comparing elements to the left
        //                  shift elements to the right tom make room to insert a value

        //                  Quadratic time O(n^2)
        //                  small data set = decent
        //                  large data set = bad

        //                  less steps than bubble sort
        //                  best case is O(n) compared to selection sort O(n^2)



        int[] array = {9,1,8,2,7,3,6,5,4};

        insertionSort(array);


        for (int i : array) {
            System.out.print(i);
        }



    }

    private static void insertionSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }

    }

    public static void insertionSortTwo(int[] arr) {
        // Mutates elements in arr by inserting out of place elements into appropriate
        // index repeatedly until arr is sorted
        for (int i = 1; i < arr.length; i++) {
            int currentIndex = i;
            while (currentIndex > 0 && arr[currentIndex - 1] > arr[currentIndex]) {
                // Swap elements that are out of order
                int temp = arr[currentIndex];
                arr[currentIndex] = arr[currentIndex - 1];
                arr[currentIndex - 1] = temp;
                currentIndex -= 1;
            }
        }
    }
}
