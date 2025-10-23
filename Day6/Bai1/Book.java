package Day6.Bai1;
public class Book {
    private String isbn;
    private String title;
    private double price;

    public Book(String isbn, String title, double price) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
    }

    

    public double getPrice() {
        return price;
    }



    public double applyDiscount(double percent) {
        if(percent<0) return this.price;
        else if(percent>100) return 0;
        else return this.price * (1 - percent / 100.0);
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %.2f", this.isbn, this.title, this.price);
    }

    public static void main(String[] args) {
        Book b = new Book("978-0-13", "Clean Code", 100000);
        
        System.out.println(b.toString());
        System.out.printf("after10=%.2f%n", b.applyDiscount(-5));
    }
}