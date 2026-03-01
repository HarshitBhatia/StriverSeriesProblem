package array.easy;

public class FindMaxConsecutiveOnesInArray {
    public static void main(String[] args) {
        int arr1[] = new int[]{1,1,1,0,0,1,1,1,1,0,0,0,1,1,1,1,1,1};
        int maxCount= getMaxNumberOfConsecutiveOnes(arr1);
        System.out.println(maxCount);
    }

    private static int getMaxNumberOfConsecutiveOnes(int[] arr) {
        int count=0,maxCount=0;
        int len= arr.length;
        for(int i=0;i<len;i++){
            if(arr[i]==1){
                count++;
            }
            else{
                count=0;
            }
            maxCount=Math.max(maxCount,count);
        }
        return maxCount;

    }

}