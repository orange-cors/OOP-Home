package Day6.Bai1;

public class InvoiceItem {
    private Book book;
    private int quantity;

    public InvoiceItem(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }



    public double lineTotal(){
        return this.book.getPrice() * this.quantity;
    }
}
