package recursion.medium;

public class FindNumberOfSubsequenceMatchesSumAsK {
    public static void main(String[] args) {
        int nums[]=new int[]{1,2,3,4,5};
        int k=8;

//        System.out.println(findCountOfSubsequence(nums,0,k,0));
        boolean foundFirstMatch=findFirstSubsequenceHasSumK(nums,0,k,0);
        System.out.println(foundFirstMatch);
    }

    private static boolean findFirstSubsequenceHasSumK(int[] nums, int sum, int k, int index) {
        if(index==nums.length){
            return sum==k;
        }
        //Pick
        if(findFirstSubsequenceHasSumK(nums,sum+nums[index],k,index+1)){
            return true;
        }
        //Not Pick
        return findFirstSubsequenceHasSumK(nums, sum, k, index + 1);
    }

    private static int  findCountOfSubsequence(int[] nums, int sum, int k, int index) {
        //Here if we dont check that whether index==sum.length and only chceks that sum==k then we might miss valid
        //subsequence when next elements are 0,0,0 also if the next elements are -ve.
        //So Above condition will work correct if numbers are only +ve
        if(index==nums.length){
            if(sum==k) return 1;
            return 0;
        }
        return findCountOfSubsequence(nums,sum+nums[index],k,index+1) +
                findCountOfSubsequence(nums,sum,k,index+1);
    }


}
