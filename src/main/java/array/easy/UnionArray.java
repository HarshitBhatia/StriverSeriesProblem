package array.easy;

import utility.Fields;

import java.util.Arrays;

public class UnionArray {
    public static void main(String[] args) {
        int arr1[]= Fields.sortArray1;
        int arr2[]= Fields.sortArray2;
        int resultArray[]=applyUnionAndMergeArray(arr1, arr2);
        System.out.println(Arrays.toString(resultArray));
    }

    private static int[] applyUnionAndMergeArray(int[] arr1, int[] arr2) {
        int len1=arr1.length;
        int len2=arr2.length;
        int i=0,j=0,k=0;
        int resultArr[]=new int[len1+len2];
        while(i<len1 && j<len2){
            resultArr[k++]=(arr1[i]<=arr2[j]?arr1[i++]:arr2[j++]);
        }
        while(i<len1){
            resultArr[k++]=arr1[i++];
        }
        while(j<len2){
            resultArr[k++]=arr2[j++];
        }
        return resultArr;
    }
}
