import java.util.Scanner;
public class Bai1516 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap mot so nguyen: ");
        int n = sc.nextInt();

        if (isPrime(n, 2)) {
            System.out.println(n + " la so nguyen to");
        } else {
            System.out.println(n + " khong phai so nguyen to");
        }
    }

    // Kiem tra snt bang de quy
    public static boolean isPrime(int n, int i) {
        if (n < 2) return false;
        if (i > Math.sqrt(n)) return true;
        if (n % i == 0) return false;
        return isPrime(n, i + 1);
    }
}
