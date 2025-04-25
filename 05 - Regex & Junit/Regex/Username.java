public class Username {
    public static void main(String[] args) {
        String username = "user_123";
        if (username.matches("^[a-zA-Z][a-zA-Z0-9_]{4,14}$")) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
