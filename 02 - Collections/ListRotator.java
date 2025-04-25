import java.util.*;

public class ListRotator {
    public static <T> void rotate(List<T> list, int k) {
        int n = list.size();
        k = k % n;
        List<T> rotated = new ArrayList<>();
        rotated.addAll(list.subList(k, n));
        rotated.addAll(list.subList(0, k));
        list.clear();
        list.addAll(rotated);
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        rotate(list, 2);
        System.out.println(list); // [30, 40, 50, 10, 20]
    }
}
