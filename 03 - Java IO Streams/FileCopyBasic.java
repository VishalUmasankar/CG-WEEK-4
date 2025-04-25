import java.io.*;

public class FileCopyBasic {
    public static void main(String[] args) {
        File source = new File("C:\\Users\\91928\\Desktop\\CG - Training\\Week-4\\03 - Java IO Streams\\Ioq1.txt");
        File destination = new File("C:\\Users\\91928\\Desktop\\CG - Training\\Week-4\\03 - Java IO Streams\\Ioq1-copy.txt");

        if (!source.exists()) {
            System.out.println("Source file does not exist.");
            return;
        }
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
