package array.easy;

import utility.Fields;

public class FindSecLargSecSmallElementInArray {
    public static void main(String[] args) {
        int[] array= Fields.allSameElementArray;
        //Recursive Approach
        int[] result= findSecLargeSecSmallInArrayApproach1(array);
//        int[] result= findSecLargeSecSmallInArrayApproach2(array);
        System.out.println(result[0] + " "+ result[1]);
    }


    private static int[] findSecLargeSecSmallInArrayApproach2(int[] array) {
        if(array.length<2){
            return new int[]{-1,-1};
        }
        int largest=Integer.MIN_VALUE;
        int smallest=Integer.MAX_VALUE;
        int secLarge=largest;
        int secSmall=smallest;
        for(int i=0;i<array.length;i++){
            if(array[i]>largest){
                secLarge=largest;
                largest=array[i];
            }
            else if(array[i]>secLarge && array[i]!=largest){
                secLarge=array[i];
            }
            if(array[i]<smallest){
                secSmall=smallest;
                smallest=array[i];
            }
            else if(array[i]<secSmall && array[i]!=smallest){
                secSmall=array[i];
            }
        }
        if(secLarge==Integer.MIN_VALUE || secSmall==Integer.MAX_VALUE){
            return new int[]{-1,-1};
        }
        return new int[]{secSmall,secLarge};
    }

    private static int[] findSecLargeSecSmallInArrayApproach1(int[] array) {
        if(array.length<2){
            return new int[]{-1,-1};
        }
        int largest=Integer.MIN_VALUE;
        int smallest=Integer.MAX_VALUE;
        int secSmall=smallest;
        int secLarge=largest;
        for(int i=0;i<array.length;i++){
            largest=Math.max(largest,array[i]);
            smallest=Math.min(smallest,array[i]);
        }
        for(int i=0;i<array.length;i++){
            if(array[i]<largest)
                secLarge=Math.max(secLarge,array[i]);
            if(array[i]>smallest){
                secSmall=Math.min(secSmall,array[i]);
            }
        }
        if(secLarge==Integer.MIN_VALUE || secSmall==Integer.MAX_VALUE){
            return new int[]{-1,-1};
        }
        return new int[]{secSmall,secLarge};
    }
}
