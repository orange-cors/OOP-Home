package Prac2;

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
        if(bookCount<=books.length){
            books[bookCount] = book;
            bookCount++;
            check = true;
        }return check;
    }

    public boolean addLibraryCard(LibraryCard card){
        boolean check = false;
        if(cardCount>cards.length)
            return check;
        for(int i = 0;i<cardCount;i++){
            if(cards[i].getCardId().equals(card.getCardId()))
                return check;
        }
                cards[cardCount] = card;
                cardCount++;
                check = true;
        return check;
    }

    public boolean borrowBook(LibraryCard card, String isbn){
        boolean check = false;
        int cnt = 0;

        for(int i = 0;i<cardCount;i++){
            
            if(books[i].getIsbn().equalsIgnoreCase(isbn)||(cnt<card.getBookLimit())){
                cnt++;
                check = true;
            }
        }return check;
    }

    public String getLibraryInfo(){
        return String.format("BookCount: %d | CardCount: %d", bookCount, cardCount);
    }
}
