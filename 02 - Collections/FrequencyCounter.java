import java.util.*;

public class FrequencyCounter {
    public static Map<String, Integer> frequency(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : list) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return map;
    }
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "apple", "orange");
        System.out.println(frequency(list)); // {apple=2, banana=1, orange=1}
    }
}
