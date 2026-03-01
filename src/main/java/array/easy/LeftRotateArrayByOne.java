package array.easy;

import utility.Fields;

public class LeftRotateArrayByOne {
    public static void main(String[] args) {
        int[] array= Fields.inputArray;
        printArrayTillIndex(array,array.length);
        leftRotateArrayByOnePlace1(array);
        printArrayTillIndex(array,array.length);
    }

    private static void printArrayTillIndex(int[] array,int updatedIndex) {
        for(int i = 0; i< updatedIndex; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    private static void leftRotateArrayByOnePlace(int[] array) {
        int len=array.length;
        if(array.length==0 || len<2) return;
        int firstEle=array[0];
        for(int i=1;i<len;i++){
            array[i-1]=array[i];
        }
        array[len-1]=firstEle;
    }

    private static void leftRotateArrayByOnePlace1(int[] array) {
        if(array==null || array.length==1) return;
        int len=array.length;
        int firstEle=array[0];
        for(int i=1;i<len;i++){
            array[i-1]=array[i];
        }
        array[len-1]=firstEle;
    }
}
