public class Licplate {
    public static void main(String[] args) {
        String plate = "AB1234";
        if (plate.matches("^[A-Z]{2}\\d{4}$")) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}