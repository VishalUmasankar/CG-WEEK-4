import java.io.*;
import java.util.*;

class Employee implements Serializable {
    int id;
    String name, department;
    double salary;

    Employee(int id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.department = dept;
        this.salary = salary;
    }

    public String toString() {
        return id + ", " + name + ", " + department + ", " + salary;
    }
}

public class EmployeeSerialization {
    public static void main(String[] args) {
        List<Employee> list = List.of(
                new Employee(1, "Alice", "HR", 50000),
                new Employee(2, "Bob", "IT", 60000)
        );

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.ser"))) {
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.ser"))) {
            List<Employee> deserialized = (List<Employee>) ois.readObject();
            deserialized.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
