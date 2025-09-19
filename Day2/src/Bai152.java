import java.util.Scanner;
public class Bai152 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        System.out.print("Nhap gia tri count can kiem tra: ");
        int count = sc.nextInt();
        if(count>10) System.out.println("Count is greater than 10");
        else System.out.println("Count is not greater than 10");
    }
}
//Kiểm tra xem giá trị biến count có lớn hơn 10 hay không, nếu có thì in ra dòng text "Count is greater than 10".
