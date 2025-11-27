package Break;

public class Book {

    private String isbn;
    private String title;
    private String author;
    private int year;
    private double price;

    public Book() {
        this.isbn = "";
        this.title = "";
        this.author = "";
        this.year = 0;
        this.price = 0;
    }

    public Book(String isbn, String title, String author, int year, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        setPrice(price);
    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }
    public double getPrice() { return price; }

    public void setPrice(double price) {
        this.price = Math.max(price, 0);
    }

    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setYear(int year) { this.year = year; }

    public String getBookInfo() {
        return String.format(
            "ISBN: %s | Title: %s | Author: %s | Year: %d | Price: %.2f",
            isbn, title, author, year, price
        );
    }

    public double getDiscountedPrice(double discountPercentage) {
        if (discountPercentage < 0) return price;
        if (discountPercentage > 100) return 0;
        return price * (1 - discountPercentage / 100);
    }

    @Override
    public String toString() {
        return String.format("ISBN: %s | Title: %s | Author: %s | Year: %d | Price: %.2f",
                isbn, title, author, year, price);
}

}
