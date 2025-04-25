public class SSN {
    public static void main(String[] args) {
        String ssn = "123-45-6789";
        if (ssn.matches("^\\d{3}-\\d{2}-\\d{4}$")) {
            System.out.println("Valid SSN");
        } else {
            System.out.println("Invalid SSN");
        }
    }
}