package array.easy;

import utility.Fields;

public class FindMaxValueinArray {
    public static void main(String[] args) {
        int[] array= Fields.inputArray;
        //Recursive Approach
        int max=findMaxInArray(array,Integer.MIN_VALUE,0);
        System.out.println(max);
    }

    private static Integer findMaxInArray(int[] array, int max,int index) {
        if(index>=array.length){
            return max;
        }
        max=Math.max(array[index],max);
        return findMaxInArray(array,max,index+1);
    }
}
