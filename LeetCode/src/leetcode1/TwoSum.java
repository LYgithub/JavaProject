package leetcode1;


import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        int [] x = {3,2,6,6,5,7,8,4,558,9};
        System.out.println(Arrays.toString(twoSum(x, 12)));
    }
    public static int[] twoSum(int[] nums, int target) {

        int i,j;
        int []x = new int [2];
        int [] index = new int[nums.length];
        for (i = 0; i < nums.length; i++) {
            index[i] = i;
        }

        //排序

        for( i = 0;i<nums.length;i++){
            for ( j = 0;j<nums.length - i-1;j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;

                    temp = index[j];
                    index[j] = index[j+1];
                    index[j+1] = temp;
                }
            }
        }

        for (i =0;i<nums.length ;i++){
            for (j = i; j<nums.length ;j++){
                if (nums[i] + nums[j] > target){
                    break;
                }
                if (nums[i] + nums[j] == target){
                    x[0] = i;
                    x[1] = j;
                    return x;
                }
            }
        }
        return  null;
    }
}