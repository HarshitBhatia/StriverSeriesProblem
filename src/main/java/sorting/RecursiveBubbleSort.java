package sorting;

import utility.Fields;

import java.util.Arrays;

public class RecursiveBubbleSort {
    public static void main(String[] args) {
        int[] array=Fields.inputArray;
        printArray(array);
        callRecursiveBubbleSort(array, array.length);
        System.out.println();
        printArray(array);
    }

    private static void callRecursiveBubbleSort(int[] arr, int len) {
        if(len==1){
            return;
        }
        for(int i=0;i<len-1;i++){
            if(arr[i]>arr[i+1]){
                int temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }
        callRecursiveBubbleSort(arr,len-1);
    }

    private static void printArray(int[] array) {
        Arrays.stream(array).forEach(x->System.out.print(x+" "));
    }

}
