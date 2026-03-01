package sorting;

import utility.Fields;

public class SortRevisionNew {
    public static void main(String[] args) {
        int[] arr = new int[]{6,5,4,3,2,1};
        printArray(arr);
//        mergeSort(arr,0,arr.length-1);
//        bubbleSort(arr);
//        doSelectionSort(arr);
//        insertionSort(arr);
//        recursiveBubbleSort(arr,arr.length);
        recursiveInsertionSort(arr,1);
        printArray(arr);
    }

    private static void recursiveInsertionSort(int[] arr, int index) {
        if(index==arr.length)
            return ;
        int j=index-1;
        int key=arr[index];
        while(j>=0 && arr[j]>key){
            arr[j+1]=arr[j];
            j--;
        }
        arr[j+1]=key;
        recursiveInsertionSort(arr,index+1);

    }

    private static void recursiveBubbleSort(int[] arr,int len) {
        if(len==1){
            return ;
        }
        for(int i=0;i<len-1;i++){
            if(arr[i]>arr[i+1]){
                swap(arr,i ,i+1);
            }
        }
        recursiveBubbleSort(arr,len-1);
    }

    private static void bubbleSort(int[] arr) {
        int len=arr.length;
        for(int i=0;i<len;i++){
            for(int j=i;j<len-i-1;j++){
                if(arr[j+1]<arr[j]){
                    swap(arr,j+1,i);
                }
            }
        }

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
        int len=arr.length;
        for(int i=1;i<len;i++){
            int j=i-1;
            int key=arr[i];
            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }

    private static void doSelectionSort(int[] arr) {
        int len=arr.length;
        for(int i=0;i<len;i++){
            int min=i;
            for(int j=i+1;j<len;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            swap(arr,i,min);
        }
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
