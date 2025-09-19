import java.util.Scanner;
public class Bai1511 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        System.out.print("Nhap so nguyen n: ");
        int n = sc.nextInt();
        int sum = 0;
        for(int i = 1; i<=n; i++){
            sum +=i;
        }
        System.out.println("Sum 1 den n la: " + sum);
    }
}
//Tính tổng các số từ 1 đến n (n nhập từ bàn phím).