import java.util.Scanner;
public class Bai1514 {
    public static Scanner sc = new Scanner(System.in);
    public static int Fac(int n){
        if(n<=1) return 1;
        else return n*Fac(n-1);
    }
    public static void main(String[] args){
        System.out.print("Nhap so nguyen n: ");
        int n = sc.nextInt();
        System.out.println("n! la: " + Fac(n));
    }
}
//Nhập số nguyên n từ bàn phím và tính n!