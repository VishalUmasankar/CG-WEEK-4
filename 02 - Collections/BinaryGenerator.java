import java.util.*;

public class BinaryGenerator {
    public static List<String> generateBinary(int n) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        while (n-- > 0) {
            String curr = queue.poll();
            result.add(curr);
            queue.add(curr + "0");
            queue.add(curr + "1");
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(generateBinary(5));
    }
}
