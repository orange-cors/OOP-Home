package Break;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library(10, 10);
LibraryCard card = new LibraryCard("LC001", "Nguyễn An", 12, 5);
lib.addLibraryCard(card);
System.out.println(card.toString());
    }
}
