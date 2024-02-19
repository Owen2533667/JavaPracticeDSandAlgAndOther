package interpolationsearch;

public class Main {
    public static void main(String[] args) {


        // interpolation search = improvement over binary search best used for "uniformly" distributed data
        //                        "guesses" where a value might be based on calculated probe results
        //                        if probe is incorrect, search area is narrowed, and a new probe is calculated.

        //                         average case: O(log(log(n)))
        //                         worst case: O(n) [values increase exponentially]

        int[] array = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};

        int index = interpolationSearch(array, 256);

        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element was not found");
        }

    }

    /**
     * Performs an interpolation search on a sorted array to find the index of a specific value.
     *
     * @param array The sorted array to search.
     * @param value The value to search for.
     * @return The index of the value in the array, or -1 if not found.
     */
    private static int interpolationSearch(int[] array, int value) {

        // Initialise search bounds
        int high = array.length - 1;
        int low = 0;

        // Loop until value is found or bounds cross
        while(value >= array[low] && value <= array[high] && low <= high) {

            // Calculate probe index using interpolation formula
            int probe = low + (high - low) * (value - array[low]) / (array[high] - array[low]);

            // Print probe position for debugging (optional)
            // System.out.println("probe: " + probe);

            // Check if value found at probe
            if (array[probe] == value) {
                return probe;
            } else if (array[probe] < value) {
                // Update lower bound if value is higher than probe
                low = probe + 1;
            } else {
                // Update upper bound if value is lower than probe
                high = probe - 1;
            }

        }

        // Value not found
        return -1;
    }
}
