package WordFrequencyCounter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Word frequency counter.
 */
public class WordFrequencyCounter {


    /**
     * Count word frequencies map.
     *
     * @param text the text
     * @return the map
     */
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

    /**
     * Is palindrome boolean.
     *
     * @param text the text
     * @return the boolean
     */
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

    public static double sumNumbersFromFile(String filePath) throws IOException {

        double total = 0.0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                try {
                    double parsedNum = Double.parseDouble(line.trim());
                    total += parsedNum;
                } catch (NumberFormatException e) {
                    System.out.println("Skipped line");
                }
            }
        }
        return total;
    }

    public static Map<Character, Integer> calculateCharacterFrequency(String text) {

        if (text == null || text.trim().isEmpty()) {
            return new HashMap<>();
        }

        HashMap<Character, Integer> charCount = new HashMap<>();

        for (char c : text.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        return charCount;
    }

}
