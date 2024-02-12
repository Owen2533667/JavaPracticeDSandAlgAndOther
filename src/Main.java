

import GUI.LoginGUI;

import java.awt.*;
import java.sql.Array;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {


        String[] names = {"Alice","Bob","Bob"};
        int[] heights = {155,185,150};

        String[] resultOne = sortPeople(names, heights);


        String[] namesOne = {"Mary","John","Emma"};
        int[] heightsOne = {180,165,170};

        String[] resultTwo = sortPeople(namesOne, heightsOne);


        new LoginGUI();

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
    public static boolean isAnagram2(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            if(s.indexOf(t.charAt(i)) == -1) {
                return false;
            }
        }
        return true;
    }

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

        if(array.equals(array.reversed())) {
            return true;
        }
        return false;
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
}