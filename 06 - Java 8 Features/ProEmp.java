import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}

public class ProEmp {

    public static void ProEmp(List<Employee> employees) {
        Map<String, Double> avgSalaryByDept = employees.stream()
                .filter(e -> e.department.equals("Engineering") && e.salary > 80000)
                .sorted((e1, e2) -> Double.compare(e2.salary, e1.salary))
                .collect(Collectors.groupingBy(
                        e -> e.department,
                        Collectors.averagingDouble(e -> e.salary)
                ));

        avgSalaryByDept.forEach((dept, avg) ->
                System.out.println(dept + ": Average Salary = $" + avg));
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(101, "Alice", "Engineering", 90000),
                new Employee(102, "Bob", "Engineering", 85000),
                new Employee(103, "Charlie", "Engineering", 75000),
                new Employee(104, "David", "HR", 65000),
                new Employee(105, "Eve", "Engineering", 95000)
        );

        ProEmp(employees);
    }
}
