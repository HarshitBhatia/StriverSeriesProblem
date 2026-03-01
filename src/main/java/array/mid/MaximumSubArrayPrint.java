package array.mid;

import utility.Fields;

import java.util.Arrays;

public class MaximumSubArrayPrint {
    public static void main(String[] args) {
        int[] nums = new int[]{};
        printMaximumSubArray(nums);

    }

    private static void printMaximumSubArray(int[] nums) {
        int maxSum=Integer.MIN_VALUE;
        int currSum=0,len=nums.length;
        int iStart=0,start=0,end=0;
        for(int i=0;i<len;i++){
            currSum+=nums[i];
            if(maxSum<currSum){
                maxSum=currSum;
                iStart=start;
                end=i;
            }
            if(currSum<0){
                currSum=0;
                start=i+1;
            }
        }
        System.out.println("Maximum Sum is "+ maxSum);
        System.out.println(iStart+ "iStarr");
        System.out.println(end+ "end");
        System.out.println(start+ "start");
    }

}
