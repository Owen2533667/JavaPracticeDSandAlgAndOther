package linearsearch;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // linear search = Iterate through a collection one element at a time

        //                 runtime complexity: O(n)

        //                 Disadvantage:
        //                 Slow for large data sets

        //                 Advantage:
        //                 Fast for searches of small to medium data sets
        //                 Does not need to be sorted
        //                 Uaeful for data structures that do not have random access (Linked List)


        int[] array = {9, 1, 8, 2, 1, 7, 3, 6, 4, 5, 1, 1};

        int index = linearSearch(array, 1);

        if (index != -1) {
            System.out.println("Element fount at index: " + index);
        } else {
            System.out.println("Element not found");
        }

        int[] index2 = linearSearchAll(array, 1);

        System.out.println(Arrays.toString(index2));



    }

    // This method conducts a linear search to locate a specific value within an array of integers.
    // It returns the index of the value if found, or -1 if not present.
    private static int linearSearch(int[] array, int value) {

        // Iterate through each element of the array
        for (int i = 0; i < array.length; i++) {
            // Check if the current element matches the passed value
            if (array[i] == value) {
                // If found, return its index
                return i;
            }
        }

        // If the value is not found within the array, return -1 to signal its absence.
        return -1;
    }

    private static int[] linearSearchAll(int[] array, int value) {

        // Initialise an empty array to store the found indices
        int[] indices = new int[0];

        // Iterate through the array
        for (int i = 0; i < array.length; i++) {
            // If the current element matches the value
            if (array[i] == value) {
                // Increase the size of the indices array by 1
                indices = Arrays.copyOf(indices, indices.length + 1);
                // Set the last element of the indices array to the current index
                indices[indices.length - 1] = i;
            }
        }

        // Return the final array containing all indices where the value was found
        return indices;
    }
}
