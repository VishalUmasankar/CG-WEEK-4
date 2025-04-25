public class Censor {
    public static void main(String[] args) {
        String text = "This is a damn bad example with some stupid words.";
        text = text.replaceAll("(?i)\\bdamn\\b|\\bstupid\\b", "****");
        System.out.println(text);
    }
}