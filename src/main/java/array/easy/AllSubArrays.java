package array.easy;

import utility.Fields;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AllSubArrays {
    public static void main(String[] args) {
        int[] array= Fields.upArray;
        List<List<Integer>> op=getAllSubArray(array);
        printList(op);
        System.out.println("New");
//        List<List<Integer>> op1=getAllSubArrayMethod1Improvement(array);
//        printList(op1);
    }

    private static void printList(List<List<Integer>> op) {
        for(List<Integer> lst:op){
            for(Integer val:lst){
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> getAllSubArray(int[] array) {
        int len=array.length;
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        for(int i=0;i<len;i++){
            List<Integer> temp=new ArrayList<Integer>();
            for(int j=i;j<len;j++){
                temp.add(array[j]);
                list.add(new ArrayList<>(temp));
            }
        }
        return list;
    }

    private static List<List<Integer>> getAllSubArrayMethod1Improvement(int[] array) {
        List<Integer> inputList= Arrays.stream(array).boxed().toList();
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<inputList.size();i++){
            for(int j=i+1;j<=inputList.size();j++){
                result.add(inputList.subList(i,j));
            }
        }
        return result;
    }


}
