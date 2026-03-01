package array.hard;

import java.util.HashMap;
import java.util.HashSet;

//Link of the problem
//https://www.geeksforgeeks.org/dsa/count-of-subarrays-having-exactly-k-distinct-elements/
public class FindSubarrayWithExactKDistinct {
    public static void main(String[] args) {
        int [] arr=new int[]{1, 2, 1, 2,3};
        int k=2;
        //Approach1 BruteForce Solution
//        int count=findSubArrayWithExactKNumberApproach1(arr,k);
        //Using Sliding Window option
        int count=findSubArrayCountWithAtmostK(arr,k);
        System.out.println(count);
    }
    private static int findSubArrayCountWithAtmostK(int[] arr ,int k){
        return findSubArrayWithExactKNumberUisngSlidingWindow(arr,k)-findSubArrayWithExactKNumberUisngSlidingWindow(arr,k-1);
    }
    private static int findSubArrayWithExactKNumberUisngSlidingWindow(int[] arr, int k) {
        int left=0,right=0;
        int count=0;
        if(k<0) return 0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(right=0;right<arr.length;right++){
            map.put(arr[right],map.getOrDefault(arr[right],0)+1);
            while(map.size()>k){
                map.put(arr[left],map.get(arr[left])-1);
                if(map.get(arr[left])==0){
                    map.remove(arr[left]);
                }
                left++;
            }
            count+=right-left+1;
        }
        return count;
    }

    private static int findSubArrayWithExactKNumberApproach1(int[] arr, int k) {
        int retCount=0;
        int len=arr.length;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<len;i++){
            set=new HashSet<>();
            for(int j=i;j<len && set.size()<=k;j++){
                set.add(arr[j]);
                if(set.size()==k){
                    retCount++;
                }
            }
        }
        return retCount;
    }
}
