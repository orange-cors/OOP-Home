import java.util.Scanner;
public class Bai159 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        System.out.print("Nhap so nguyen x can kiem tra: ");
        int x = sc.nextInt();
        if(x<0) System.out.println("So am");
        else if(x>0) System.out.println("So duong");
        else System.out.println("So 0");
    }
}
//Kiểm tra một số nguyên có phải là số âm, số dương hay số không.