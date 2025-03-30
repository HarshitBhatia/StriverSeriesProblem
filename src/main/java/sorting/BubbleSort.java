package sorting;

import utility.Fields;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array=Fields.inputArray;
        printArray(array);
        //Bubble sorting begins
        for(int i=0;i< array.length;i++){
            for(int j=i+1;j<array.length;j++){
                //Sorting at every step by step level.
                if(array[j]<array[i]){
                    int temp=array[j];
                    array[j]=array[i];
                    array[i]=temp;
                }
            }
        }
        System.out.println();
        printArray(array);
    }

    private static void printArray(int[] array) {
        Arrays.stream(array).forEach(x->System.out.print(x+" "));
    }

}
