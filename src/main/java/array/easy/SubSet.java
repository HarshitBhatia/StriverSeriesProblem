package array.easy;

import java.util.ArrayList;
import java.util.List;
import utility.Helper;

public class SubSet {
    static List<List<Integer>> op=new ArrayList<>();
    public static void main(String[] args) {
        int arr[]=new int[]{1,2,3};
        SubSet obj =new SubSet();
//        List<List<Integer>> op=generateAllSubset(arr);
        ArrayList<Integer> lst=new ArrayList<Integer>();
        generateAllSubsetUsingBacktracking(0,lst,arr);
        Helper.printListValues(op);
    }

    private static void generateAllSubsetUsingBacktracking(int i, ArrayList<Integer> lst, int[] arr) {
        op.add(new ArrayList<>(lst));
        for(int first=i;first<arr.length;first++){
            lst.add(arr[first]);
            generateAllSubsetUsingBacktracking(first+1,lst,arr);
            lst.removeLast();
        }
    }

    private static List<List<Integer>> generateAllSubset(int[] nums) {
        // Using Cascading Technique
        List<List<Integer>> op=new ArrayList<>();
        op.add(new ArrayList<Integer>());
        for(int num:nums){
            List<List<Integer>> tempList=new ArrayList<>();
            //Below loop will take n(above loop) and(*) 2^n Time Complexity to complete this.
            for(List<Integer> temp:op){
               List<Integer> list=new ArrayList<>(temp);
               list.add(num);
               tempList.add(list);
            }
            op.addAll(tempList);

        }
        return op;
    }
}
