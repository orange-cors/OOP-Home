package Break;

public class Book {

    private String isbn;
    private String title;
    private String author;
    private int year;
    private double price;

    public Book(String isbn, String title, String author, int year, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        setPrice(price);
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price<0)
            this.price = 0;
        else    
            this.price = price;
    }

    public String getBookInfo(){
        return String.format("ISBN: %s | Title: %s | Author: %s | Year: %d | Price: %.2f", this.isbn, this.title, this.author, this.year, this.price);
    }

    public double getDiscountedPrice(double discountPercentage){
        if(discountPercentage<0) return price;
        else if(discountPercentage>100) return 0;
        else return this.price*(1-discountPercentage/100);
    }
    
}
