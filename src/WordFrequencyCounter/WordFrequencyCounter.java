package WordFrequencyCounter;

import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounter {


    public static Map<String, Integer> countWordFrequencies(String text) {

        if (text == null || text.trim().isEmpty()) {
            return new HashMap<>(); // Return an empty map for null or empty input
        }

        HashMap<String, Integer> wordCount = new HashMap<>();

        // Replace all non-letter, non-whitespace characters with an empty string
        String cleanedText = text.toLowerCase().replaceAll("[^a-zA-Z\\s]", "");

        for (String i : cleanedText.split("\\s+")) {
            if (!i.isEmpty()) { // Only process non-empty words
                wordCount.put(i, wordCount.getOrDefault(i, 0) + 1);
            }
        }
        return wordCount;
    }

    public static boolean isPalindrome(String text) {

        if (text == null) {
            return false;
        }

        String cleanedText = text.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

        if (cleanedText.isEmpty() || cleanedText.length() == 1) {
            return true;
        }

        StringBuilder reversedText = new StringBuilder(cleanedText).reverse();

        return cleanedText.contentEquals(reversedText);
    }

}
