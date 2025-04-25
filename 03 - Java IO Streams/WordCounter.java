import java.io.*;
import java.util.*;
public class WordCounter {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> freq = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("LargeFile.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String word : line.toLowerCase().split("\\W+")) {
                    if (!word.isEmpty()) {
                        freq.put(word, freq.getOrDefault(word, 0) + 1);
                    }
                }
            }
        }
        freq.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(5)
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}
