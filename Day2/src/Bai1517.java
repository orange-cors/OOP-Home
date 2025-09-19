import java.util.Scanner;
public class Bai1517 {
    public static Scanner sc = new Scanner(System.in);

    public static double hinhTron(float r) {
        return Math.PI * r * r;
    }

    public static double hinhThang(int a, int b, int h) {
        return (1.0*(a+b)/2)*h;
    }

    public static double TamGiac(int x, int y, int z) {
        double p = (1.0)*(x+y+z)/2;

        return Math.sqrt(p*(p-x)*(p-y)*(p-z));
    }

    public static void main(String[] args) {
        System.out.print("Nhap ban kinh r: ");
        float r = sc.nextFloat();
        System.out.println("Dien tich hinh tron la: " + hinhTron(r));

        System.out.print("Nhap canh day a: ");
        int a = sc.nextInt();
        System.out.print("Nhap canh day b: ");
        int b = sc.nextInt();
        System.out.print("Nhap chieu cao h: ");
        int h = sc.nextInt();
        System.out.println("Dien tich hinh thang la: " + hinhThang(a,b,h));

        System.out.print("Nhap canh x: ");
        int x = sc.nextInt();
        System.out.print("Nhap canh y: ");
        int y = sc.nextInt();
        System.out.print("Nhap canh z: ");
        int z = sc.nextInt();
        System.out.println("Dien tich tam giac la: " + TamGiac(x,y,z));

    }
}