import java.util.Scanner;
public class Bai1512 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        System.out.print("Nhap nam x can kiem tra: ");
        int x = sc.nextInt();
        if((x%4 == 0 && x%100 != 0) || x % 400 == 0) System.out.println(x + " La nam nhuan");
        else System.out.println(x + " Khong la nam nhuan");
    }
}
/*Kiểm tra một năm có phải là năm nhuận hay không. Năm nhuận
là năm chia hết cho 4 nhưng không chia hết cho 100, hoặc chia hết
cho 400
 */