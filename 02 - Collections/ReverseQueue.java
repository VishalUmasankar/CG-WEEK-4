import java.util.*;

public class ReverseQueue {
    public static <T> void reverse(Queue<T> queue) {
        if (queue.isEmpty()) return;
        T temp = queue.remove();
        reverse(queue);
        queue.add(temp);
    }
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(List.of(10, 20, 30));
        reverse(queue);
        System.out.println(queue);
    }
}
