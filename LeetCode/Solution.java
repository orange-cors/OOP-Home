package LeetCode;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int check = nums[i];
            for(int j = i+1;j<nums.length;j++){
                if(check + nums[j] == target){
                    int[] tmp = {i, j};
                    return tmp;
                }
            }
        }return null;
    }
}