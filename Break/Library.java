package Break;

public class Library {

    private Book[] books;
    private LibraryCard[] cards;
    private int bookCount;
    private int cardCount;

    public Library(int maxBooks, int maxCards){
        this.books = new Book[maxBooks];
        this.cards = new LibraryCard[maxCards];
        this.bookCount = 0;
        this.cardCount = 0;
    }

    public boolean addBook(Book book){
        boolean check = false;
        if(this.bookCount<this.books.length){
            this.books[this.bookCount] = book;
            bookCount++;
            check = true;
        }
        return check;
    }

     public boolean addLibraryCard(LibraryCard card) {
        if (this.cardCount >= this.cards.length) return false;
        for (int i = 0; i < this.cardCount; i++) {
            if (this.cards[i].getCardId().equals(card.getCardId())) return false;
        }
        cards[cardCount++] = card;
        return true;
    }

    public boolean borrowBook(LibraryCard card, String isbn) {
        boolean foundCard = false;
        for (int i = 0; i < cardCount; i++) {
            if (cards[i].getCardId().equals(card.getCardId())) {
                foundCard = true;
                break;
            }
        }
        if (!foundCard) return false;

        boolean foundBook = false;
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                foundBook = true;
                break;
            }
        }
        return foundBook;
    }

    public String getLibraryInfo() {
        return String.format("Library: Books=%d | Cards=%d", bookCount, cardCount);
    }
}
