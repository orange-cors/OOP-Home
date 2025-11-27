package Prac2;

public class LibraryCard {
    private String cardId;
    private String holderName;
    private int validityPeriod;
    private int bookLimit;

    public LibraryCard(String cardId, String holderName, int validityPeriod, int bookLimit) {
        this.cardId = cardId;
        this.holderName = holderName;
        setValididyPeriod(validityPeriod);
        setBookLimit(bookLimit);
    }

    public String getCardId(){
        return cardId.trim();
    }

    public int getBookLimit() {
        return bookLimit;
    }

    public void setValididyPeriod(int validityPeriod){
        if(validityPeriod<1)
            this.validityPeriod = 1;
        else 
            this.validityPeriod = validityPeriod;    
    }

    public void setBookLimit(int bookLimit){
        if(bookLimit<0)
            this.bookLimit = 0;
        else 
            this.bookLimit = bookLimit;    
    }

    public boolean isValid(int monthsPassed){
        if(monthsPassed>=validityPeriod)
            return false;
        else    
            return true;
    }

    public String toString(){
        return String.format("CardID: %s | Holder: %s | Validity: %d months | BookLimit: %d", cardId, holderName, validityPeriod, bookLimit);
    }
}
