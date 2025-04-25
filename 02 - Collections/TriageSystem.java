import java.util.*;

class Patient {
    String name;
    int severity;
    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
}
public class TriageSystem {
    public static void main(String[] args) {
        PriorityQueue<Patient> pq = new PriorityQueue<>((a, b) -> b.severity - a.severity);
        pq.add(new Patient("John", 3));
        pq.add(new Patient("Alice", 5));
        pq.add(new Patient("Bob", 2));
        while (!pq.isEmpty()) {
            System.out.println(pq.poll().name);
        }
    }
}
