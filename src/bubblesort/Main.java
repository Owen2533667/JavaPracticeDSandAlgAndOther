package bubblesort;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {

        // bubble sort = pairs of adjacent elements are compared, and the elements
        //               swapped if they are not in order.

        //               Quadratic time O(n^2)
        //               small data set = okay-ish
        //               large data set = bad

        long startTime;
        long endTime;
        long elapsedTime;


        int[] array = {1,5,2,6,3,4,7,8,10,9};
        int[] arrayTwo = {1,5,2,6,3,4,7,8,10,9};
        int[] arrayThree = {1,5,2,6,3,4,7,8,10,9};

        // **************************************
        // bubble sort one
        startTime = System.nanoTime();

        bubbleSort(array);

        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;

        System.out.println(Arrays.toString(array));
        System.out.println("bubble sort one:\t" + elapsedTime + " ns");
        // **************************************

        // **************************************
        // bubble sort two
        startTime = System.nanoTime();

        bubbleSortTwo(arrayTwo);

        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;

        System.out.println(Arrays.toString(arrayTwo));
        System.out.println("bubble sort two:\t" + elapsedTime + " ns");
        // **************************************

        // **************************************
        // bubble sort three
        startTime = System.nanoTime();

        bubbleSortThree(arrayThree);

        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;

        System.out.println(Arrays.toString(arrayThree));
        System.out.println("bubble sort three:\t" + elapsedTime + " ns");
        // **************************************

    }

    private static void bubbleSort(int[] array) {

        boolean hasSwapped = true;
        while (hasSwapped) {
            hasSwapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    hasSwapped = true;
                }
            }
        }
    }

    public static void bubbleSortTwo(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static void bubbleSortThree(int[] array) {
        boolean hasSwapped = true;
        int n = array.length;

        // Outer loop iterates up to n-1 times (largest elements bubble up)
        for (int i = 0; i < n - 1; i++) {
            hasSwapped = false;

            // Inner loop iterates up to n-i-1 times (remaining elements)
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap elements
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    hasSwapped = true;
                }
            }

            // If no swaps happened, break early (already sorted)
            if (!hasSwapped) {
                break;
            }
        }
    }

}
