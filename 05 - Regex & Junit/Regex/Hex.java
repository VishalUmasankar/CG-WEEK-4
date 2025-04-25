public class Hex {
    public static void main(String[] args) {
        String color = "#FFA500";
        if (color.matches("^#([A-Fa-f0-9]{6})$")) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
