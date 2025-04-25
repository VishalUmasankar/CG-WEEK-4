import java.io.*;

public class StudentData {
    public static void main(String[] args) {
        // Writing data to file
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("students.dat"))) {
            dos.writeInt(101);           // Roll number
            dos.writeUTF("Vishal");        // Name
            dos.writeDouble(8.5);        // GPA
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream("students.dat"))) {
            int roll = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();
            System.out.println(roll + " " + name + " " + gpa);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
