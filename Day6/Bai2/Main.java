package Day6.Bai2;

// import java.util.Arrays;

/**
 * Lớp Book: Đại diện cho một cuốn sách.
 */
class Book {
    private String isbn;
    private String title;
    private double price;

    /**
     * Constructor đầy đủ cho lớp Book.
     */
    public Book(String isbn, String title, double price) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
    }

    // --- Getters ---
    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    /**
     * Trả về giá sau khi đã áp dụng giảm giá.
     * @param percent Tỷ lệ phần trăm giảm giá (ví dụ: 10 cho 10%).
     * @return Giá mới sau khi giảm.
     */
    public double applyDiscount(double percent) {
        return this.price * (1 - percent / 100.0);
    }

    /**
     * Trả về chuỗi đại diện cho cuốn sách.
     * Ví dụ: "978604... - Clean Code - 150000"
     */
    @Override
    public String toString() {
        // Sử dụng String.format để làm tròn giá về số nguyên như ví dụ
        return String.format("%s - %s - %.0f", this.isbn, this.title, this.price);
    }
}

/**
 * Lớp InvoiceItem: Đại diện cho một mục hàng trong hóa đơn.
 */
class InvoiceItem {
    private Book book;
    private int quantity;

    /**
     * Constructor đầy đủ cho InvoiceItem.
     */
    public InvoiceItem(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    // --- Getters ---
    public Book getBook() {
        return book;
    }

    public int getQuantity() {
        return quantity;
    }

    /**
     * Tính tổng tiền cho mục hàng này (giá sách * số lượng).
     * @return Tổng tiền của dòng.
     */
    public double lineTotal() {
        return this.book.getPrice() * this.quantity;
    }

    /**
     * Chuỗi đại diện cho mục hàng, hữu ích cho việc in hóa đơn.
     */
    @Override
    public String toString() {
        return String.format("Item: [%s], Quantity: %d, Line Total: %.2f",
                this.book.toString(), this.quantity, this.lineTotal());
    }
}

/**
 * Lớp Invoice: Đại diện cho một hóa đơn, chứa nhiều InvoiceItem.
 */
class Invoice {
    // Sử dụng hằng số cho kích thước tối đa
    private static final int MAX_ITEMS = 100;
    private InvoiceItem[] items;
    private int count; // Số lượng mục hàng hiện tại

    /**
     * Constructor cho Invoice.
     * Khởi tạo mảng và đặt count = 0.
     */
    public Invoice() {
        this.items = new InvoiceItem[MAX_ITEMS];
        this.count = 0;
    }
    
    // --- Getters (Cần thiết cho InvoiceUtils) ---
    public InvoiceItem[] getItems() {
        return items;
    }
    
    public int getCount() {
        return count;
    }

    /**
     * Thêm một InvoiceItem vào hóa đơn.
     */
    public void add(InvoiceItem it) {
        if (this.count < MAX_ITEMS) {
            this.items[this.count] = it;
            this.count++;
        } else {
            System.out.println("Hóa đơn đã đầy, không thể thêm mục mới.");
        }
    }

    /**
     * Overloading: Thêm một mục hàng bằng đối tượng Book và số lượng.
     */
    public void add(Book b, int quantity) {
        InvoiceItem newItem = new InvoiceItem(b, quantity);
        this.add(newItem); // Gọi lại phương thức add(InvoiceItem)
    }

    /**
     * Overloading: Thêm một mục hàng bằng thông tin chi tiết của sách và số lượng.
     */
    public void add(String isbn, String title, double price, int quantity) {
        Book newBook = new Book(isbn, title, price);
        // Gọi lại phương thức add(Book, int)
        this.add(newBook, quantity); 
    }

    /**
     * Tính tổng cộng tiền của toàn bộ hóa đơn.
     * @return Tổng tiền.
     */
    public double grandTotal() {
        double total = 0.0;
        for (int i = 0; i < this.count; i++) {
            total += this.items[i].lineTotal();
        }
        return total;
    }

    /**
     * Tìm InvoiceItem đầu tiên trong hóa đơn dựa trên ISBN của sách.
     * @param isbn ISBN cần tìm.
     * @return InvoiceItem nếu tìm thấy, ngược lại trả về null.
     */
    public InvoiceItem findByIsbn(String isbn) {
        for (int i = 0; i < this.count; i++) {
            if (this.items[i].getBook().getIsbn().equals(isbn)) {
                return this.items[i];
            }
        }
        return null; // Không tìm thấy
    }

    /**
     * (Thêm từ hình ảnh) Trả về số lượng mục hàng trong hóa đơn.
     */
    public int size() {
        return this.count;
    }

    /**
     * Tạo một chuỗi tóm tắt toàn bộ hóa đơn.
     * @return Chuỗi chi tiết hóa đơn.
     */
    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append("============ INVOICE ============\n");
        for (int i = 0; i < this.count; i++) {
            // Sử dụng toString() của InvoiceItem
            sb.append(this.items[i].toString()).append("\n");
        }
        sb.append("=================================\n");
        sb.append(String.format("GRAND TOTAL: %.2f\n", this.grandTotal()));
        return sb.toString();
    }
}

/**
 * Lớp InvoiceUtils: Cung cấp các phương thức tĩnh để xử lý Invoice.
 */
class InvoiceUtils {

    /**
     * Lớp tiện ích không nên được khởi tạo.
     */
    private InvoiceUtils() {
    }

    /**
     * Lọc và trả về một mảng các InvoiceItem có tổng tiền (lineTotal)
     * lớn hơn một ngưỡng minLineTotal.
     */
    public static InvoiceItem[] filterExpensive(Invoice inv, double minLineTotal) {
        // Bước 1: Đếm số lượng mục hàng thỏa mãn điều kiện
        int matchCount = 0;
        for (int i = 0; i < inv.getCount(); i++) {
            if (inv.getItems()[i].lineTotal() > minLineTotal) {
                matchCount++;
            }
        }

        // Bước 2: Tạo mảng kết quả với kích thước vừa đủ
        InvoiceItem[] result = new InvoiceItem[matchCount];
        
        // Bước 3: Thêm các mục hàng thỏa mãn vào mảng kết quả
        int resultIndex = 0;
        for (int i = 0; i < inv.getCount(); i++) {
            InvoiceItem currentItem = inv.getItems()[i];
            if (currentItem.lineTotal() > minLineTotal) {
                result[resultIndex] = currentItem;
                resultIndex++;
            }
        }

        return result;
    }
}

/**
 * Lớp Main để chạy thử nghiệm các ví dụ.
 */
public class Main {
    public static void main(String[] args) {
        // --- Test 1 (Giống trong hình) ---
        System.out.println("--- Test 1 ---");
        Invoice inv = new Invoice();
        inv.add(new InvoiceItem(new Book("A", "B1", 10000), 2));
        inv.add(new Book("B", "B2", 20000), 1);
        inv.add("C", "B3", 30000, 3);
        System.out.println("size=" + inv.size()); // Kết quả: size=3

        System.out.println("\n-----------------");

        // --- Test 2 (Giống trong hình) ---
        System.out.println("--- Test 2 ---");
        Invoice inv2 = new Invoice();
        inv2.add("I1", "T1", 10000, 2); // lineTotal = 20000
        inv2.add("I2", "T2", 25000, 1); // lineTotal = 25000
        inv2.add("I3", "T3", 30000, 3); // lineTotal = 90000
        // Grand Total = 20000 + 25000 + 90000 = 135000
        System.out.printf("total=%.2f\n", inv2.grandTotal()); // Kết quả: total=135000.00
        
        System.out.println("\n-----------------");
        
        // --- Test 3 (Thử nghiệm print() và filterExpensive) ---
        System.out.println("--- Test 3: Print() ---");
        System.out.println(inv2.print());
        
        System.out.println("--- Test 4: filterExpensive (lineTotal > 21000) ---");
        // Lọc các mục có lineTotal > 21000 (sẽ là I2 và I3)
        InvoiceItem[] expensiveItems = InvoiceUtils.filterExpensive(inv2, 21000.0);
        
        for (InvoiceItem item : expensiveItems) {
            System.out.println(item);
        }
    }
}