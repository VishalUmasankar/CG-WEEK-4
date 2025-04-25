import java.util.*;

class Employee {
    String name;
    String department;
    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
    @Override
    public String toString() {
        return name;
    }
}
public class GroupByDepartment {
    public static Map<String, List<Employee>> group(List<Employee> employees) {
        Map<String, List<Employee>> grouped = new HashMap<>();
        for (Employee emp : employees) {
            grouped.computeIfAbsent(emp.department, k -> new ArrayList<>()).add(emp);
        }
        return grouped;
    }
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR")
        );
        System.out.println(group(employees));
    }
}
