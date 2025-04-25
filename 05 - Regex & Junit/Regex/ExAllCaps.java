import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ExAllCaps{
    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        Pattern p = Pattern.compile("\\b[A-Z][a-z]*\\b");
        Matcher m = p.matcher(text);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
