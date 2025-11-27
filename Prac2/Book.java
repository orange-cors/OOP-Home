package Prac2;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private int year;
    private double price;

    Book(String isbn, String title, String author, int year, double price){
        this.isbn = isbn.trim();
        this.title = title.trim();
        this.author = author.trim();
        this.year = year;
        setPrice(price);
    }

    
    public String getIsbn() {
        return isbn;
    }

    public void setPrice(double price){
        if(price<0)
            this.price = 0;
        else 
            this.price = price;
    }

    public String getBookInfo(){
        return String.format("ISBN: %s | Title: %s | Author: %s | Year: %d | Price: %.2f", isbn, title, author, year, price);
    }

    double getDiscountedPrice(double discountPercentage){
        if(discountPercentage<0)
            return price;
        else if(discountPercentage>100)
            return 0;
        else
            return price*(1-discountPercentage/100);        
    }

}
