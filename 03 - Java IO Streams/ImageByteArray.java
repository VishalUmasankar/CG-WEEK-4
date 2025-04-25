import java.io.*;

public class ImageByteArray {
    public static void main(String[] args) throws IOException {
        File img = new File("image.jpg");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try (FileInputStream fis = new FileInputStream(img)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, length);
            }
        }
        byte[] imageBytes = baos.toByteArray();

        try (FileOutputStream fos = new FileOutputStream("image_copy.jpg")) {
            fos.write(imageBytes);
        }
        System.out.println("Image copied via byte array.");
    }
}
