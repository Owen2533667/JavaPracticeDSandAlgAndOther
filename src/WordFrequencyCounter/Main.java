package WordFrequencyCounter;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println(WordFrequencyCounter.countWordFrequencies("Hello world! This is a test. Hello again."));

        System.out.println(WordFrequencyCounter.isPalindrome("Racecar"));
        System.out.println(WordFrequencyCounter.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(WordFrequencyCounter.isPalindrome("hello"));
        System.out.println(WordFrequencyCounter.isPalindrome("Was it a car or a cat I saw?"));
        System.out.println(WordFrequencyCounter.isPalindrome("!"));
        System.out.println(WordFrequencyCounter.isPalindrome(""));
        System.out.println(WordFrequencyCounter.isPalindrome(null));

        System.out.println(WordFrequencyCounter.sumNumbersFromFile("/Users/owenhughes/IdeaProjects/SolutionsNeet/src/WordFrequencyCounter/data.txt"));


    }
}
