import java.util.*;
public class NthFromEnd {
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        Iterator<T> lead = list.iterator();
        Iterator<T> follow = list.iterator();
        for (int i = 0; i < n; i++) {
            if (lead.hasNext()) lead.next();
            else return null;
        }
        while (lead.hasNext()) {
            lead.next();
            follow.next();
        }
        return follow.next();
    }
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        System.out.println(findNthFromEnd(list, 2)); // D
    }
}
