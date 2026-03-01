package array.easy;

import utility.Fields;

public class CheckIfArrayIsSorted {
    public static void main(String[] args) {
        int[] array= Fields.allSameElementArray;
        boolean result=checkIfArrayIsSorted(array);
        System.out.println(result);
    }

    private static boolean checkIfArrayIsSorted(int[] array) {
        int op;
        int len=array.length;
        if(array.length<2){
            return true;
        }
        op= Integer.compare(array[0], array[len - 1]);
        if(op<0){
            for(int i=1;i<len;i++){
                if(array[i]<=array[i-1]) {
                    return false;
                }
            }
        }
        else if(op>0){
            for(int i=1;i<len;i++){
                if(array[i]>=array[i-1]) {
                    return false;
                }
            }
        }
        else{
            for(int i=1;i<len;i++){
                if(array[i]!=array[i-1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
