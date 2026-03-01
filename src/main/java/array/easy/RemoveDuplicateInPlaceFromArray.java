package array.easy;

import utility.Fields;

public class RemoveDuplicateInPlaceFromArray {
    public static void main(String[] args) {
        int[] array= Fields.twoElementDuplicateArray;
        printArrayTillIndex(array,array.length);
        int updatedIndex=removeDuplicateElementsFromArrayInPlace(array);
        printArrayTillIndex(array,updatedIndex);
    }

    private static void printArrayTillIndex(int[] array,int updatedIndex) {
        for(int i = 0; i< updatedIndex; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    private static int removeDuplicateElementsFromArrayInPlace(int[] array) {
        int k=0;
        for(int i=1;i<array.length;i++){
            if(array[i]!=array[k]){
                array[++k]=array[i];
            }
        }
        return ++k;
    }
}
