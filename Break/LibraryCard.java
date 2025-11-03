package Break;

public class LibraryCard {

    private String cardId;
    private String holderName;
    private int validityPeriod;
    private int bookLimit;

    public LibraryCard(String cardId, String holderName, int validityPeriod, int bookLimit) {
        this.cardId = cardId;
        this.holderName = holderName;
        setValidityPeriod(validityPeriod);
        setBookLimit(bookLimit);
    }

    public String getCardId() {
        return cardId;
    }

    public String getHolderName() {
        return holderName;
    }

    public int getValidityPeriod() {
        return validityPeriod;
    }

    public int getBookLimit() {
        return bookLimit;
    }

    public void setValidityPeriod(int validityPeriod) {
        if(validityPeriod<1)
            this.validityPeriod = 1;
        else
            this.validityPeriod = validityPeriod;
    }

    public void setBookLimit(int bookLimit) {
        if(bookLimit<1)
            this.bookLimit = 1;
        else
            this.bookLimit = bookLimit;
    }

    public boolean isValid(int monthsPassed){
        if(monthsPassed>this.validityPeriod)
            return false;
        else return true;
    }

    public String toString(){
        return String.format("CardID: %s | Holder: %s | Validity: %d | BookLimit: %d", this.cardId, this.holderName, this.validityPeriod, this.bookLimit);

    }
}
