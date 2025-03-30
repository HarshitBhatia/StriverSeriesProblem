package sorting;

import utility.Fields;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array=Fields.inputArray;
        printArray(array);
        //selection sorting begins
        for(int i=0;i< array.length;i++){
            int min=i;
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[min]){
                    min=j;
                }
            }
            swap(array,i,min);
        }
        System.out.println();
        printArray(array);
    }

    private static void printArray(int[] array) {
        Arrays.stream(array).forEach(x->System.out.print(x+" "));
    }

    private static void swap(int[] array, int i, int pos) {
        int temp=array[i];
        array[i]=array[pos];
        array[pos]=temp;
    }
}
