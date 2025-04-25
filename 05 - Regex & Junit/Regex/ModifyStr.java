public class ModifyStr {
    public static void main(String[] args) {
        String text = "This is an example with multiple spaces.";
        text = text.replaceAll("\\s+", " ");
        System.out.println(text);
    }
}