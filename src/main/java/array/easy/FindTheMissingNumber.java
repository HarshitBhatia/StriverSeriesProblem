package array.easy;

import utility.Fields;

import java.util.Arrays;

public class FindTheMissingNumber {
    public static void main(String[] args) {
        int arr1[] = new int[]{1,2,3,5};
        int num=findMissingNum(arr1);
        System.out.println(num);
    }

    private static int findMissingNum(int[] arr) {
        int resultXor=0;
        int len= arr.length;
        for(int i=0;i<len;i++){
            resultXor^=arr[i];
        }
        for(int i=1;i<=len+1;i++){
            resultXor^=i;
        }
        return resultXor;

    }

}