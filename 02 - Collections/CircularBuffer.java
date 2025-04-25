import java.util.*;

public class CircularBuffer {
    int[] buffer;
    int size, start = 0, count = 0;
    public CircularBuffer(int k) {
        buffer = new int[k];
        size = k;
    }
    void insert(int val) {
        buffer[(start + count) % size] = val;
        if (count < size)
            count++;
        else
            start = (start + 1) % size;
    }
    List<Integer> getBuffer() {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            res.add(buffer[(start + i) % size]);
        }
        return res;
    }
    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.insert(4);
        System.out.println(cb.getBuffer()); // [2, 3, 4]
    }
}
