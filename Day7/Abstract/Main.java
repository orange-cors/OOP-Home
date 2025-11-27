package Day7.Abstract;

public class Main {
    public static void main(String[] args) {
        Animal d1 = new Dog();
        System.out.print("The dog says: ");
        d1.sound();
        Animal c1 = new Cat();
        System.out.print("The cat says: ");
        c1.sound();

    }
}
