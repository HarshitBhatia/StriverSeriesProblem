package sorting;

import utility.Fields;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array=Fields.inputArray;
        printArray(array);
        //Selection sorting begins
        for(int i=1;i<array.length;i++){
            int j=i;
            while(j>0 && array[j]<array[j-1]){
                //swapping numbers
                int temp=array[j-1];
                array[j-1]=array[j];
                array[j]=temp;
                j--;
            }
        }
        System.out.println();
        printArray(array);
    }

    private static void printArray(int[] array) {
        Arrays.stream(array).forEach(x->System.out.print(x+" "));
    }

}
