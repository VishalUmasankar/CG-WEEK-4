import java.util.*;
import java.util.stream.Collectors;

// Class to represent individual sales
class Sale {
    String productId;
    int quantity;
    double price;

    public Sale(String productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
}

// Class to represent transformed result (productId + totalRevenue)
class ProductSales {
    String productId;
    double totalRevenue;

    public ProductSales(String productId, double totalRevenue) {
        this.productId = productId;
        this.totalRevenue = totalRevenue;
    }

    @Override
    public String toString() {
        return "ProductID: " + productId + ", Total Revenue: $" + totalRevenue;
    }
}

public class ProductSalesAnalysis {

    public static List<ProductSales> analyzeSales(List<Sale> sales) {
        return sales.stream()
                .filter(s -> s.quantity > 10) // Step 1: Filter
                .collect(Collectors.groupingBy( // Group by productId
                        s -> s.productId,
                        Collectors.summingDouble(s -> s.quantity * s.price) // Total revenue per product
                ))
                .entrySet()
                .stream()
                .map(e -> new ProductSales(e.getKey(), e.getValue())) // Step 2: Transform to ProductSales
                .sorted((p1, p2) -> Double.compare(p2.totalRevenue, p1.totalRevenue)) // Step 3: Sort desc
                .limit(5) // Step 4: Top 5
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Sale> sales = Arrays.asList(
                new Sale("P101", 12, 50.0),
                new Sale("P102", 8, 100.0),
                new Sale("P103", 20, 30.0),
                new Sale("P104", 15, 80.0),
                new Sale("P105", 25, 60.0),
                new Sale("P106", 9, 200.0),
                new Sale("P107", 18, 40.0),
                new Sale("P108", 11, 70.0)
        );

        List<ProductSales> topProducts = analyzeSales(sales);
        topProducts.forEach(System.out::println);
    }
}
