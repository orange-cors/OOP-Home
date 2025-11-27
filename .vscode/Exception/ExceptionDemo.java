package .vscode.Exception;

public import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class LowBalanceException extends Exception {
    public LowBalanceException(String msg) {
        super(msg);
    }
}

class Account {
    private int balance = 100;

    public void withdraw(int amount) throws LowBalanceException {
        if (amount > balance) {
            throw new LowBalanceException("Not enough balance!");
        }
        balance -= amount;
    }
}

public class ExceptionDemo {
    public static void main(String[] args) {

        // 1. NullPointerException
        try {
            String name = null;
            name.length(); 
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught!");
        }

        // 2. ClassCastException
        try {
            Object obj = "Hello";
            Integer num = (Integer) obj; 
        } catch (ClassCastException e) {
            System.out.println("ClassCastException caught!");
        }

        // 3. ArrayIndexOutOfBoundsException
        try {
            int[] arr = {1, 2, 3};
            int x = arr[10];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught!");
        }

        // 4. ArithmeticException (divide by zero)
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught!");
        }

        // 5. FileNotFoundException
        try {
            File f = new File("nofile.txt");
            Scanner sc = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException caught!");
        }

        // 6. IllegalArgumentException
        try {
            setAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught!");
        }

        // 7. Custom Exception
        try {
            Account acc = new Account();
            acc.withdraw(500); 
        } catch (LowBalanceException e) {
            System.out.println("Custom Exception caught: " + e.getMessage());
        }
    }

    static void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative!");
        }
    }
}
 {
    
}
