import java.util.Scanner;
public class Bai153 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        System.out.print("Nhap gia tri x: ");
        int x = sc.nextInt();
        int total = 10;
        total += x;
        System.out.println("Total la: " + total);
    }
}
//Giảm x đi 1 đơn vị, sau đó gán cho biến total giá trị là hiệu của total và x. Chỉ dùng một lệnh
