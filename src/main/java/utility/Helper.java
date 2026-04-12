package utility;

import java.util.List;

public class Helper {
    public static void printIntegerList(List<Integer> nums){
        System.out.println("List values are");
        for(Integer num: nums){
            System.out.print(num+ " ");
        }
        System.out.println();
    }
    public static void printListValues(List<List<Integer>> op) {
        for(List<Integer> lst: op){
            for(Integer ele:lst){
                System.out.print(ele+" ");
            }
            System.out.println();
        }

    }
}
