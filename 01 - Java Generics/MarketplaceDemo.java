abstract class Category {}

class BookCategory extends Category {}
class ClothingCategory extends Category {}
class GadgetCategory extends Category {}

class Product<T extends Category> {
    String name;
    double price;
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public void applyDiscount(double percentage) {
        price -= price * percentage / 100;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
}
class Catalog {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        product.applyDiscount(percentage);
        System.out.println("Applied " + percentage + "% discount to " + product.getName());
    }
}
public class MarketplaceDemo {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Programming", 500);
        Product<GadgetCategory> gadget = new Product<>("Smartwatch", 3000);
        Catalog.applyDiscount(book, 10);
        Catalog.applyDiscount(gadget, 15);
        System.out.println(book.getName() + ": ₹" + book.getPrice());
        System.out.println(gadget.getName() + ": ₹" + gadget.getPrice());
    }
}
