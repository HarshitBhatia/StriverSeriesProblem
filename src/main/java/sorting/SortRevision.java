package sorting;

import utility.Fields;

import java.util.Arrays;


public class SortRevision {
    public static void main(String[] args) {
        int[] arr = Fields.inputArray;
        int[] sys = Fields.inputArray.clone();
        printArray(arr);
//        doSelectionSort(arr.clone());
//        insertionSort(arr);
//        mergeSort(arr,0,arr.length-1);
//        recursiveBubbleSort(arr,arr.length);
//        doMergeSort(arr,0,arr.length-1);
//        printArray(Fields.inputArray);
//        printArray(sys);
        doQuickSortArray(sys,0, sys.length-1);
        printArray(sys);
    }

    private static void doQuickSortArray(int[] arr, int low, int high) {
        if(low<high){
            int pivotIndex= getPartitionIndexAndPlacePivot(arr,low,high);
            doQuickSortArray(arr,low,pivotIndex-1);
            doQuickSortArray(arr,pivotIndex+1,high);
        }
    }

    private static int getPartitionIndexAndPlacePivot(int[] arr, int low, int high) {
        int pivotElement=arr[high];
        int i=low-1;
        for(int j=low;j<high;j++){
            if(arr[j]<pivotElement){
                swap(arr,i+1,j);
                i++;
            }
        }
        swap(arr,++i,high);
        return i;
    }

    private static void doMergeSort(int[] arr, int low, int high) {
        if(low<high){
            int mid=(low+high)/2;
            doMergeSort(arr,low,mid);
            doMergeSort(arr,mid+1,high);
            mergeSortedArray(arr,low,mid,high);
        }
    }

    private static void recursiveBubbleSort(int[] arr, int length) {
        if(length==1){
            return;
        }
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                int temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }
        recursiveBubbleSort(arr,length-1);
    }

    private static void mergeSort(int[] arr,int left,int right) {
        if(left==right){
            return ;
        }
        int mid=(left+right)/2;
        mergeSort(arr, left,mid);
        mergeSort(arr,mid+1,right);
        mergeSortedArray(arr,left,mid,right);

    }

    private static void mergeSortedArray(int[] arr,int left,int mid,int right) {
        int i=left;
        int j=mid+1;
        int k=0;
        int[] resultedArr=new int[right-left+1];
        while(i<=mid && j<=right){
           resultedArr[k++]=arr[i]<=arr[j]?arr[i++]:arr[j++];
        }
        while(i<=mid){
            resultedArr[k++]=arr[i++];
        }
        while(j<=right){
            resultedArr[k++]=arr[j++];
        }
        if (right + 1 - left >= 0) System.arraycopy(resultedArr, left - left, arr, left, right + 1 - left);
    }

    private static void insertionSort(int[] arr) {
        for(int i=1;i<arr.length;i++){
            int j=i;
            while(j>0 && arr[j]<arr[j-1]){
                swap(arr,j,j-1);
                j--;
            }
        }
        printArray(arr);
    }

    private static void doSelectionSort(int[] arr) {
        for(int i = 0; i< arr.length-1; i++){
            int min=i;
            for(int j = i+1; j< arr.length; j++){
                if(arr[j]< arr[min]){
                    min=j;
                }
            }
            swap(arr,i,min);
        }
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    private static void swap(int[] arr, int i, int min) {
        int temp=arr[i];
        arr[i]=arr[min];
        arr[min]=temp;
    }
}
