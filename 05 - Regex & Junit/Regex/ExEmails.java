import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ExEmails {
    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org";
        Pattern p = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        Matcher m = p.matcher(text);

        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
