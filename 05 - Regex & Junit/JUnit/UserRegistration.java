import java.util.regex.Pattern;

public class UserRegistration {

    public static void registerUser(String username, String email, String password) {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }

        if (email == null || !isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email address");
        }

        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }
    }

    private static boolean isValidEmail(String email) {
        // Simple regex for email validation
        String emailRegex = "^[\\w.-]+@[\\w.-]+\\.\\w{2,}$";
        return Pattern.matches(emailRegex, email);
    }
}
