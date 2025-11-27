package Break;

public class Main {

    public static Book [] createBook(int n){
        Book [] list = new Book[n];

        String[] isbn = {
            "978-0132350884", 
            "978-0743273565", 
            "978-0262033848", 
            "978-0590353427", 
            "978-0596009205"
        };

        String[] title = {
            "Clean Code", 
            "The Great Gatsby", 
            "Introduction to Algorithms", 
            "Harry Potter and the Sorcerer's Stone", 
            "Head First Java"
        };

        String[] author = {
            "Robert C. Martin", 
            "F. Scott Fitzgerald", 
            "Thomas H. Cormen", 
            "J.K. Rowling", 
            "Kathy Sierra"
        };

        int[] year = {
            2008, 
            1925, 
            2009, 
            1997, 
            2005
        };

        double[] price = {
            42.99, 
            10.50, 
            85.00, 
            12.99, 
            39.50
        };

        int index;
        for(int i=0;i<n;i++){
            list[i] = new Book();
            index = (int)(Math.random()*isbn.length);
            list[i].setIsbn(isbn[index]);

            index = (int)(Math.random()*title.length);
            list[i].setTitle(title[index]);

            index = (int)(Math.random()*author.length);
            list[i].setAuthor(author[index]);

            index = (int)(Math.random()*year.length);
            list[i].setYear(year[index]);;

            index = (int)(Math.random()*price.length);
            list[i].setPrice(price[index]);
        }
        
        return list;
    } 

    public static void printBook(Book[] list){
        for(Book b: list){
            System.out.println(b);
        }
    }
    public static void main(String[] args) {
        Book[] list = Main.createBook(10);
        Main.printBook(list);
    }
}
