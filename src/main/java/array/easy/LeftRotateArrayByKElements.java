package array.easy;

import utility.Fields;

import java.util.Arrays;

public class LeftRotateArrayByKElements {
    public static void main(String[] args) {
        int[] array= Fields.smallArray;
        System.out.println(Arrays.toString(array));
        int k=2;
//        leftRotateArrayByKPlaceBruteForce1(array,k);
//        rightRotateArrayByKPlaceBruteForce(array,k);
//        rightRotateArrayByKPlaceBruteForce1(array,k);
//        rotateArrayByKPlaceUsingExtraArrayInBothDir(array,k);
//        leftRotateArrayByKPlaceReversalArray(array,k);
//        rightRotateArrayByKPlaceReversalArray(array,k);
        leftOrRightArrayByReversalTechniqueInBothDir(array,2);
        System.out.println(Arrays.toString(array));
    }

    private static void rotateArrayByKPlaceUsingExtraArrayInBothDir(int[] array, int k) {
        if(array== null || array.length<=1){
            return;
        }
        int len=array.length;
        k%=len;
        int[] temp=new int[len];
        if(k<0){
            k+=len;
        }
        for(int i=0;i<len;i++){
            int arrayIndex=(i+k)%len;
            temp[arrayIndex]=array[i];
        }
        for(int i=0;i<len;i++){
            array[i]=temp[i];
        }
    }

    private static void leftOrRightArrayByReversalTechniqueInBothDir(int[] array, int k) {
        if(array== null || array.length<=1){
            return ;
        }
        int len=array.length;
        if(k<0) k+=len;
        k%=len;
        reverseArray(array,0,len-1);
        reverseArray(array,0,k-1);
        reverseArray(array,k,len-1);

    }

    private static void rightRotateArrayByKPlaceReversalArray(int[] array, int k) {
        if(array==null || array.length<2 || k<1){
            return;
        }
        int len=array.length;
        k=k%len;
        if(k>0){
            reverseArray(array, len-k,len-1);
            reverseArray(array,0,len-k-1);
            reverseArray(array,0,len-1);
        }

    }

    private static void leftRotateArrayByKPlaceReversalArray(int[] array, int k) {
        //Reversal Technique
        int len=array.length;
        if(array==null || len<2 || k==0) return;
        k=k%len;
        if(k>0){
            reverseArray(array, 0,k-1);
            reverseArray(array,k,len-1);
            reverseArray(array,0,len-1);
        }
    }

    private static void reverseArray(int[] array, int left, int right) {
        while(left<=right){
            int temp=array[left];
            array[left]=array[right];
            array[right]=temp;
            left++;
            right--;
        }
    }

    private static void rightRotateArrayByKPlaceBruteForce(int[] array, int rotatePLace) {
        int len=array.length;
        rotatePLace=rotatePLace%len;
        int temp[]=new int[rotatePLace];
        int ind=0;
        for(int i=len-rotatePLace;i<len;i++){
            temp[ind++]=array[i];
        }
        ind=len-1;
        int counter=0;
        while(counter<len-rotatePLace){
            array[ind]=array[ind-rotatePLace];
            ind--;
            counter++;
        }
        System.out.println(Arrays.toString(array));
        ind=0;
        for(int i=0;i<temp.length;i++){
            array[ind++]=temp[i];
        }
    }

    private static void rightRotateArrayByKPlaceBruteForce1(int[] array, int rotatePLace) {
        if(array==null || array.length<=1){
            return ;
        }
        int len=array.length;
        rotatePLace%=len;
        int[] temp=new int[rotatePLace];
        int k=0;
        for(int i=len-rotatePLace;i<len;i++){
            temp[k++]=array[i];
        }
        for(int i=len-1;i>=rotatePLace;i--){
            array[i]=array[i-rotatePLace];
        }
        for(int i=0;i<rotatePLace;i++){
            array[i]=temp[i];
        }
    }

    private static void printArrayTillIndex(int[] array,int updatedIndex) {
        for(int i = 0; i< updatedIndex; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    /*private static void leftRotateArrayByKPlaceBruteForce(int[] array, int rotatePLace) {
        int len=array.length;
        rotatePLace%=len;
        int temp[]=new int[rotatePLace];
        for(int i=0;i<rotatePLace;i++){
            temp[i]=array[i];
        }
        int k=0;
        for(int i=rotatePLace;i<len;i++){
            array[k++]=array[i];
        }
        int index=0;
        for(index=0;index<temp.length;index++){
            array[k++]=temp[index];
        }
    }*/

    private static void leftRotateArrayByKPlaceBruteForce1(int[] array, int rotatePLace) {
        if(array==null || array.length<=1) return ;
        int len=array.length;
        rotatePLace%= len;
        int[] temp=new int[rotatePLace];
        for(int i=0;i<rotatePLace;i++){
            temp[i]=array[i];
        }
        int ind=0;
        for(int i=rotatePLace;i<len;i++){
            array[ind++]=array[i];
        }
        for(int i=0;i<temp.length;i++){
            array[ind++]=temp[i];
        }
//        for(int i=0;i<array.length;)
    }
}
