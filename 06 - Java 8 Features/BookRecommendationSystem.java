import java.util.*;
import java.util.stream.Collectors;

// Book class
class Book {
    String title;
    String author;
    String genre;
    double rating;

    public Book(String title, String author, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }
}

// BookRecommendation class
class BookRecommendation {
    String title;
    double rating;

    public BookRecommendation(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return title + " (Rating: " + rating + ")";
    }
}

// Main solution
public class BookRecommendationSystem {

    // Method to get paginated book recommendations
    public static List<List<BookRecommendation>> getBookRecommendations(List<Book> books) {
        // Step 1: Filter books (genre = "Science Fiction", rating > 4.0)
        List<BookRecommendation> filteredList = books.stream()
                .filter(b -> b.genre.equalsIgnoreCase("Science Fiction") && b.rating > 4.0)
                // Step 2: Transform to BookRecommendation (title + rating)
                .map(b -> new BookRecommendation(b.title, b.rating))
                // Step 3: Sort by rating descending
                .sorted((b1, b2) -> Double.compare(b2.rating, b1.rating))
                // Step 4: Limit to top 10
                .limit(10)
                .collect(Collectors.toList());

        // Step 5: Paginate (5 per page)
        List<List<BookRecommendation>> pages = new ArrayList<>();
        int pageSize = 5;
        for (int i = 0; i < filteredList.size(); i += pageSize) {
            pages.add(filteredList.subList(i, Math.min(i + pageSize, filteredList.size())));
        }

        return pages;
    }

    // Main method to test
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Dune", "Frank Herbert", "Science Fiction", 4.5),
                new Book("Neuromancer", "William Gibson", "Science Fiction", 4.2),
                new Book("Foundation", "Isaac Asimov", "Science Fiction", 4.3),
                new Book("The Martian", "Andy Weir", "Science Fiction", 4.6),
                new Book("Snow Crash", "Neal Stephenson", "Science Fiction", 4.1),
                new Book("Hyperion", "Dan Simmons", "Science Fiction", 4.4),
                new Book("Ender's Game", "Orson Scott Card", "Science Fiction", 4.5),
                new Book("Brave New World", "Aldous Huxley", "Science Fiction", 4.0),
                new Book("2001: A Space Odyssey", "Arthur C. Clarke", "Science Fiction", 4.2),
                new Book("Red Mars", "Kim Stanley Robinson", "Science Fiction", 4.3),
                new Book("I, Robot", "Isaac Asimov", "Science Fiction", 4.1),
                new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 4.8)
        );

        List<List<BookRecommendation>> paginatedRecommendations = getBookRecommendations(books);

        // Display pages
        for (int i = 0; i < paginatedRecommendations.size(); i++) {
            System.out.println("Page " + (i + 1) + ":");
            for (BookRecommendation rec : paginatedRecommendations.get(i)) {
                System.out.println(" - " + rec);
            }
            System.out.println();
        }
    }
}
