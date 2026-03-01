package array.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindLeaderInArray {
    public static void main(String[] args) {
        int[] nums = new int[]{200,500,499,9,8,7,6-90,0,1,34,56,2,3,4};
        printArray(nums);
        int[] leader= findLeaderInArray(nums);
        printArray(leader);
    }

    private static void printArray(int[] leader) {
        Arrays.stream(leader).forEach(s-> System.out.print(s+" "));
        System.out.println();
    }

    private static int[] findLeaderInArray(int[] nums) {
        List<Integer> lst=new LinkedList<>();
        int len=nums.length;
        int maxNum=nums[len-1];
        lst.add(maxNum);
//        Arrays.asList()
        for(int i=len-2;i>=0;i--){
            if(nums[i]>maxNum){
                maxNum=nums[i];
                lst.addFirst(maxNum);
            }
        }
        return lst.stream().mapToInt(Integer :: intValue).toArray();
    }
}


