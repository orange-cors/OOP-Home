package Day5;

public class MyArrays{
    public static int [] createArrays(int n){
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = (int) (Math.random()*1000);
        }return arr;
    }

    public static void printArray(int [] arr, int n){
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+ " ");
        }
    }

    public static void sortedArrays(int []arr, boolean flag, int n){
        byte value = (byte) (flag ? 1 : -1);
        for(int i=0;i<n;i++){
            for(int j=0;j<n-1-i;j++){
                if((arr[j]*value)<(arr[j+1]*value)){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }    
        }    
    }

    public static void main(String[] args) {
        int [] arr = MyArrays.createArrays(100);
        MyArrays.printArray(arr, 100);
        System.out.println(" ");
        MyArrays.sortedArrays(arr, true, 100);
        MyArrays.printArray(arr, 100);

    }
}