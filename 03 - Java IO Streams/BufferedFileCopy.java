import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) throws IOException {
        File source = new File("C:\\Users\\91928\\Desktop\\CG - Training\\Week-4\\03 - Java IO Streams\\LargeFile.txt");
        File dest = new File("C:\\Users\\91928\\Desktop\\CG - Training\\Week-4\\03 - Java IO Streams\\Copy_LargeFile.txt");
        long start = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {

            byte[] buffer = new byte[4096];
            int length;
            while ((length = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, length);
            }
        }
        long end = System.nanoTime();
        System.out.println("Buffered copy time: " + (end - start) / 1_000_000 + " ms");
    }
}
