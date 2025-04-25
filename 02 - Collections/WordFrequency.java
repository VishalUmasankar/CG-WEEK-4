import java.util.*;
import java.util.regex.*;

public class WordFrequency {
    public static Map<String, Integer> countWords(String text) {
        Map<String, Integer> freq = new HashMap<>();
        text = text.toLowerCase().replaceAll("[^a-z\\s]", "");
        for (String word : text.split("\\s+")) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        return freq;
    }
    public static void main(String[] args) {
        String input = "Hello world, hello Java!";
        System.out.println(countWords(input));
    }
}
