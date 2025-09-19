import java.util.Scanner;
public class Bai1510 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        System.out.print("Nhap so x: ");
        int x = sc.nextInt();
        switch (x) {
            case 1:
                System.out.print("Sunday!");
                break;
            case 2:
                System.out.print("Monday!");
                break;
            case 3:
                System.out.print("Tuesday!");
                break;
            case 4:
                System.out.print("Wednesday!");
                break;
            case 5:
                System.out.print("Thursday!");
                break;
            case 6:
                System.out.print("Friday!");
                break;
            case 7:
                System.out.print("Saturday!");
                break;

        }
    }
}
//In ra ngày trong tuần dựa trên số nhập vào (1 là Chủ nhật, 2 là Thứ Hai, ..., 7 là Thứ Bảy).