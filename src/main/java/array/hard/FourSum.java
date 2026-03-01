package array.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-3,-2,-1,0,0,1,2,3};
        int target= 0;
        List<List<Integer>> op= fourSum(nums,target);
        for(List<Integer> temp:op){
            temp.forEach(x-> System.out.print(x+ " "));
            System.out.println();
        }
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> op = new ArrayList<>();
        op = findKSum(nums, target, 0, 4);
        return op;
    }

    public static List<List<Integer>> findKSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();
        // This we need to handle case when user is giving input of less than 4 size
        if (nums.length == start) return res;
        //Find Average value
        long avgVal = target / k;
        //Validate with given values in array
        if (avgVal < nums[start] || avgVal > nums[nums.length - 1]) {
            return res;
        }
        if (k == 2) {
            return findTwoSum(nums, target, start);
        }
        for (int i = start; i < nums.length; i++) {
            if (i == start || nums[i] != nums[i - 1]) {
                for (List<Integer> temp : findKSum(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(temp);
                }
            }
        }
        return res;
    }

    public static List<List<Integer>> findTwoSum(int[] nums, int target, int start) {
        int left = start;
        int right = nums.length - 1;
        List<List<Integer>> op = new ArrayList<>();
         while(left<right){
             int sum=nums[left]+nums[right];
             if(sum==target){
                 op.add(Arrays.asList(nums[left++],nums[right--]));
                 while(left<right && nums[left]==nums[left-1]){
                     left++;
                 }
                 while(left<right && nums[right]==nums[right+1]){
                     right--;
                 }
//                 Arrays.sort(intervals,)
             }
             else if(sum<target) {
                 left++;
             }
             else{
                 right--;
             }
         }


//        while (left < right) {
//            int currSum = nums[left] + nums[right];
//            if (currSum < target || (left > start && nums[left] == nums[left - 1])) {
//                ++left;
//            } else if (
//                    currSum > target ||
//                            (right < nums.length - 1 && nums[right] == nums[right + 1])
//            ) {
//                --right;
//            } else {
//                op.add(Arrays.asList(nums[left++], nums[right--]));
//            }
//        }
        return op;
    }

}
