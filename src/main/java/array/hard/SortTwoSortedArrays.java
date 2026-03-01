package array.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortTwoSortedArrays {
    public static void main(String[] args) {
        int[] num1 = new int[]{1,2,10,0,0,0};
        int[] num2 = new int[]{2,3,4};
        //Sort these two array with O(N+M) complexity
        int p1=num1.length/2-1;
        int p2=num2.length-1;
        for(int p=num1.length-1;p>=0;p--){
            if(num1[p1]>num2[p2]){
                num1[p]=num1[p1--];
            }
            else{
                num1[p]=num2[p2--];
            }
            if(p2<0){
                break;
            }
        }
        Arrays.stream(num1).forEach(x-> System.out.print(x+" "));
    }


}
