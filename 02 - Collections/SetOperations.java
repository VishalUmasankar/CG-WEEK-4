import java.util.*;

public class SetOperations {
    public static <T> Set<T> union(Set<T> s1, Set<T> s2) {
        Set<T> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }
    public static <T> Set<T> intersection(Set<T> s1, Set<T> s2) {
        Set<T> result = new HashSet<>(s1);
        result.retainAll(s2);
        return result;
    }
    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(3, 4, 5));
        System.out.println("Union: " + union(s1, s2));         // [1, 2, 3, 4, 5]
        System.out.println("Intersection: " + intersection(s1, s2)); // [3]
    }
}
