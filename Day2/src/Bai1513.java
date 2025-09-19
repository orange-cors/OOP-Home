import java.util.Scanner;
public class Bai1513 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        System.out.print("Nhap so nguyen a cua phuong trinh (ax^2 + bx + c): ");
        int a = sc.nextInt();
        System.out.print("Nhap so nguyen b cua phuong trinh (ax^2 + bx + c): ");
        int b = sc.nextInt();
        System.out.print("Nhap so nguyen c cua phuong trinh (ax^2 + bx + c): ");
        int c = sc.nextInt();
        System.out.println("Phuong trinh bac 2 cua ban la: " + a + "x^2" + '+' + b + "x"+ '+' + c);

        if(a==0) System.out.println("Phuong trinh bac nhat co nghiem x = -c/b: " + -c/b);
        else{
            float del = b*b - 4*a*c;
            if(del<0) System.out.println("Phuong trinh vo nghiem!");
            else if(del==0) System.out.println("Phuong trinh co nghiem kep x1=x2= -b/2a: " + -b/(2*a));
            else {
                System.out.println("Phuong trinh co 2 nghiem phan biet!");
                System.out.println("Voi x1 = (-b+sqrt(del))/2a = " + (-b + Math.sqrt(del))/2*a);
                System.out.println("Voi x2 = (-b-sqrt(del))/2a = " + (-b - Math.sqrt(del))/2*a);
            }
        }
    }
}
//Giải và biện luận phương trình bậc 2