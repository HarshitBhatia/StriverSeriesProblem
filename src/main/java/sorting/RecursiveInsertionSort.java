package sorting;

import utility.Fields;

import java.util.Arrays;

public class RecursiveInsertionSort {
    public static void main(String[] args) {
        int[] array=Fields.inputArray;
        printArray(array);
        callInsertionBubbleSort(array, 1);
        System.out.println();
        printArray(array);
    }

    private static void callInsertionBubbleSort(int[] arr, int ind) {
        if(ind==arr.length){
            return;
        }
        int j=ind;
        while(j>0 && arr[j]<arr[j-1]){
            int temp=arr[j];
            arr[j]=arr[j-1];
            arr[j-1]=temp;
            j--;
        }
        callInsertionBubbleSort(arr,ind+1);
    }

    private static void printArray(int[] array) {
        Arrays.stream(array).forEach(x->System.out.print(x+" "));
    }

}
