package array.hard;

public class FindMaximumProductSubArray {
    public static void main(String[] args) {
        System.out.println(findMaxProductInSubArray());
    }

    private static int findMaxProductInSubArray() {
        int nums[]=new int[]{2,3,-2,4};
        int maxProd=Integer.MIN_VALUE;
        int currProd=1;
        //find Left Sum
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                currProd=1;
                continue;
            }
            currProd*=nums[i];
            maxProd=Math.max(currProd,maxProd);
        }
        currProd=1;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]==0){
                currProd=1;
                continue;
            }
            currProd*=nums[i];
            maxProd=Math.max(currProd,maxProd);
        }
        return maxProd;
    }

    public static int findMaxProductSubArray(int[] nums){
        int maxLProd=Integer.MIN_VALUE;
        int maxRProd=Integer.MIN_VALUE;
        int currLeftProd=1;
        int currRightProd=1;
        int len=nums.length;
        for(int i=0;i<len;i++){
            currLeftProd*=nums[i];
            maxLProd=Math.max(maxLProd,currLeftProd);
            currRightProd*=nums[len-i-1];
            maxRProd=Math.max(maxRProd,currRightProd);
            currLeftProd=(nums[i]==0?1:currLeftProd);
            currRightProd=(nums[len-i-1]==0?1:currRightProd);
        }
        return Math.max(maxLProd,maxRProd);
    }
}
