import java.util.*;

public class Main {

    public static void main(String[] args) {


        int[] intsmore = {2,4,6};

        int[] doubleints = Arrays.stream(intsmore).map(x -> x * 2).toArray();

        System.out.println(Arrays.toString(doubleints));

        int[] heightsTwo = {1,1,4,2,1,3};

        insertionSort(heightsTwo);

        System.out.println(Arrays.toString(heightsTwo));

        String[] names = {"Alice","Bob","Bob"};
        int[] heights = {155,185,150};

        String[] resultOne = sortPeople(names, heights);


        String[] namesOne = {"Mary","John","Emma"};
        int[] heightsOne = {180,165,170};

        String[] resultTwo = sortPeople(namesOne, heightsOne);


//        new LoginGUI();

        int x = 1221;

        System.out.println(isPalindrome(x));

        String attendance = "APPPLLPLPP";
        System.out.println(checkRecord(attendance));

        String s = "Owen Hughes";
        String t = "HughesOwen";

        System.out.println(isAnagram(s, t));


        int[] intArr = {2,3,4,3,5,6,4,5,6};
        System.out.println(containsDuplicate(intArr));
        int[] result = twoSum(intArr, 6);

    }

    /*
    * Contains Duplicate
    * https://leetcode.com/problems/contains-duplicate/description/
    * */
    /**
     * Checks an int array to see if duplicate elements exists. For example, an array [1,2,1,3] will return true as 1 is duplicated.
     * This is achieved by using a HashSet of Integers, and a for-loop through the array passed by checking if the
     * HashSet
     * contains the number, if not then add the number to the set. Otherwise, return true indicating that the number
     * is a
     * duplicate. When there is no duplicates the for loop will end and return false.
     * @param nums int array to be checked.
     * @return true if array contains duplicate elements, otherwise false.
     */
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    /**
     *  Find two numbers, when added together will result in the target number.
     *  The two numbers, that result in the target, has to be in different index to count.
     * @param nums array of numbers.
     * @param target the target which two numbers added in the array will equal.
     * @return the indices of the two numbers as an array.
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return nums;
    }

    //first attempt
//    public static boolean isAnagram2(String s, String t) {
//        for (int i = 0; i < t.length(); i++) {
//            if(s.indexOf(t.charAt(i)) == -1) {
//                return false;
//            }
//        }
//        return true;
//    }

    /**
     * Checks to see if String t is an anagram of String s. Will ignore case sensitivity and space, as the
     * method will replace spaces and convert two arguments passed to lower case. It then checks to see if length of the
     * two strings are the same. It will convert the two strings to a char array and sort them. If the two arrays are
     * equal, it will return true, otherwise false.
     * @param s first String that t will be checked to.
     * @param t second String that will be checked if it is an anagram of s.
     * @return true if t is an anagram of s, otherwise false.
     */
    public static boolean isAnagram(String s, String t) {

        String wordOne = s.toLowerCase().replace(" ", "");
        String wordTwo = t.toLowerCase().replace(" ", "");

        if(wordOne.length() == wordTwo.length()) {
            char[] wordOneChars = wordOne.toCharArray();
            char[] wordTwoChars = wordTwo.toCharArray();
            Arrays.sort(wordOneChars);
            Arrays.sort(wordTwoChars);
            return Arrays.equals(wordOneChars,wordTwoChars);
        }

        return false;
    }

    //https://leetcode.com/problems/palindrome-number/
    public static boolean isPalindrome(int x) {

        if(x < 0) {
            return false;
        }

        int temp = x;
        ArrayList<Integer> array = new ArrayList<Integer>();
        do{
            array.add(temp % 10);
            temp /= 10;
        } while  (temp > 0);

        return array.equals(array.reversed());
    }

    public static boolean checkRecord(String s) {
        if(s.contains("LLL")) return false;
        char someChar = 'A';
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == someChar) {
                count++;
                if(count >= 2) return false;
            }
        }
        return true;
    }

    //leetcode problem
    public static String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new IdentityHashMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }
        String[] orderedNames = map.values().toArray(new String[0]);
        return orderedNames ;
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }


    public LinkedList<String> reverseLinkedList(LinkedList<String> s) {
        ListIterator<String> iterator = s.listIterator();
        LinkedList<String> reversed = new LinkedList<>();
    
        while (iterator.hasNext()) {
            reversed.addFirst(iterator.next());
        }
    
        return reversed;
    }

    public LinkedList<String> reverseLinkedList2(LinkedList<String> s) {
        Collections.reverse(s);
        return s;
    }

    // sorts

    // bubblesort O(n^2) The space complexity of bubble sort is O(1)
    public void bubbleSort(int[] arr) {
        // Mutates arr so that it is sorted via swapping adjacent elements until
        // the arr is sorted.
        boolean hasSwapped = true;
        while (hasSwapped) {
            hasSwapped = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    // Swap adjacent elements
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    hasSwapped = true;
                }
            }
        }
    }


    public static int heightChecker(int[] heights) {

        int[] copy = Arrays.stream(heights).toArray();

        Arrays.sort(copy);

        int count = 0;

        for (int i = 0; i < heights.length; i++) {
            if(heights[i] != copy[i]) {
                count++;
            }
        }

        return count;
    }


    // selection Sort
    public void selectionSort(int[] arr) {
        // Mutates arr so that it is sorted via selecting the minimum element and
        // swapping it with the corresponding index
        int min_index;
        for (int i = 0; i < arr.length; i++) {
            min_index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
            // Swap current index with minimum element in rest of list
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(int[] arr) {
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
