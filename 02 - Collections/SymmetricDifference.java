import java.util.*;

public class SymmetricDifference {
    public static <T> Set<T> symmetricDifference(Set<T> s1, Set<T> s2) {
        Set<T> result = new HashSet<>(s1);
        result.addAll(s2);
        Set<T> intersection = new HashSet<>(s1);
        intersection.retainAll(s2);
        result.removeAll(intersection);
        return result;
    }
    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(3, 4, 5));
        System.out.println(symmetricDifference(s1, s2)); // [1, 2, 4, 5]
    }
}
