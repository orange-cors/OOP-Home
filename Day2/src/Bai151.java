public class Bai151 {
    public static void main(String[] args){
        int x = 3;
        int y = 2;
        int z = y + x++;
        System.out.println("Tong z=x+y la: " + z + " Va x++ = " +x);
    }
}
//Dùng một lệnh để gán tổng của x và y cho z và tăng x thêm 1 sau phép tính trên.