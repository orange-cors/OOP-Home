package LeetCode;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < nums.length; i++) {
            nums[i]=sc.nextInt();
        }  

        int target = sc.nextInt();
        Solution a = new Solution();
        int [] result = a.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
