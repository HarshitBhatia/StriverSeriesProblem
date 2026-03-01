package sorting;

import utility.Fields;

import java.util.ArrayList;
import java.util.Arrays;


public class QuickSort {
    public static void main(String[] args) {
        int[] array=Fields.mergeSortArray;
        printArray(array);
        doQuickSort(array,0,array.length-1);
        System.out.println();
        printArray(array);
    }

    private static void doQuickSort(int[] array, int low, int high) {
        if(low<high){
            int partitionInd=getPartition(array,low,high);
            doQuickSort(array,low,partitionInd-1);
            doQuickSort(array,partitionInd+1,high);
        }
    }

    private static int getPartition(int[] array, int low, int high) {
        //Get the index of Pivot as Last Element
        int pivot=array[high];
        int i=low-1;
        for(int j=low;j<high;j++){
            if(array[j]<pivot){
                swap(array,i+1,j);
                i++;
            }
        }
        //To Place the pivot element in correct place.
        swap(array,i+1,high);
        return i+1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }

    private static void printArray(int[] array) {
        Arrays.stream(array).forEach(x->System.out.print(x+" "));
    }

}
