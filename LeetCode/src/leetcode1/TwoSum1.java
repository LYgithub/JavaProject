package leetcode1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LiYang
 * @Project Name: LeetCode
 * @Package Name: leetcode1
 * Created by MacBook Air on 2020/03/05.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class TwoSum1 {
    public static void main(String[] args) {
        int [] a = {3,3};
        int target = 6;
        long time = System.currentTimeMillis();
        Solution1 solution1 = new Solution1();
        System.out.println(Arrays.toString(solution1.twoSum(a, target)));

        Solution2 solution2 = new Solution2();
        System.out.println(Arrays.toString(solution2.twoSum(a, target)));
    }

}

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int [] index = {0,0};
        int i,x;
        for (i = 0; i < nums.length; i++) {
            x = findIndex(nums,target - nums[i],i);
            if(x!= -1){
                index[0] = i;
                index[1] = x;
                return index;
            }
        }
        return index;
    }

    private int findIndex(int []nums,int x,int y){

        for (int i = 0; i < nums.length; i++) {
            if(x == nums[i] && i != y){
                return i;
            }
        }
        return -1;
    }
}

class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap();
        for(int i =0 ;i < nums.length; i++){
            int j = target - nums[i];
            if(map.get(j) != null){
                result[0] = i;
                result[1] = map.get(j);
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
    }
}