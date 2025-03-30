package sorting;

import java.util.*;
import utility.Fields;


public class MergeSort {
    public static void main(String[] args) {
        int[] array=Fields.mergeSortArray;
        printArray(array);
        doMergeSort(array,0,array.length-1);
        System.out.println();
        printArray(array);
    }

    private static void doMergeSort(int[] array,int low,int high) {
        if(low==high){
            return;
        }
        int mid=(low+high)/2;
        doMergeSort(array,low,mid);
        doMergeSort(array,mid+1,high);
        mergeArray(array,low,mid,high);
//        LinkedList

    }

    private static void mergeArray(int[] array, int low, int mid, int high) {
        ArrayList<Integer> lst=new ArrayList<>();
        int left=low;
        int right=mid+1;
        while(left<=mid && right<=high){
            if(array[left]<=array[right]){
                lst.add(array[left]);
                left++;
            }
            else{
                lst.add(array[right]);
                right++;
            }
        }
        while(left<=mid){
            lst.add(array[left]);
            left++;
        }
        while(right<=high){
            lst.add(array[right]);
            right++;
        }
        for(int i=low;i<=high;i++){
            array[i]=lst.get(i-low);
        }
    }

    private static void printArray(int[] array) {
        Arrays.stream(array).forEach(x->System.out.print(x+" "));
    }

}
