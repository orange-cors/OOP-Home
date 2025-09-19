public class Bai158 {
    public static void main(String[] args){
        int sum = 0;
        for(int i = 1 ; i <100 ; i++){
            if(i%2==0) sum += i;
        }
        System.out.println("Sum is: " + sum);
    }
}
//Tính tổng các số chẵn trong khoảng từ 1 đến 99.