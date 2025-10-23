import java.util.Scanner;

public class Bai1515 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập 2 số nguyên từ bàn phím
        System.out.print("Nhap so thu nhat: ");
        int a = sc.nextInt();
        System.out.print("Nhap so thu hai: ");
        int b = sc.nextInt();

        // Tìm UCLN bằng thuật toán Euclid
        int gcd = findGCD(a, b);

        // In kết quả ra màn hình
        System.out.println("UCLN cua " + a + " va " + b + " la: " + gcd);
        sc.close();
    }

    // Hàm tìm UCLN
    public static int findGCD(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
}