package array.hard;

import java.util.HashMap;

public class FindMissingAndRepeatNumberinArray {
    public static void main(String[] args) {
        int arr[]=new int[]{1,1,1,1};
        int k=0;
        int res= countSubarrayWithGivenXORValue(arr,k);
        System.out.println(res);
    }

    private static int countSubarrayWithGivenXORValue(int[] arr, int k) {
        int count=0;
        int currXValue=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            currXValue^=arr[i];
            int value=currXValue^k;
            if(map.containsKey(value)){
                count+=map.get(value);
            }
            if(currXValue==k){
                count++;
            }
            map.put(currXValue,map.getOrDefault(currXValue,0)+1);
        }
        return count;
    }
}
