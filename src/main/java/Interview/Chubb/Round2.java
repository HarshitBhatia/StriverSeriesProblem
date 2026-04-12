package Interview.Chubb;

public class Round2 {
    public static void main(String[] args) throws Exception {
        int[] input=new int[]{101,1,1,1,1,2,4,100,190};
        int value=findSecondLargestNumber(input);
        int value1=findSecondLargestNumberUsingTwoLoops(input);
        System.out.println("Value of both calls are "+value+ " "+ value1);
    }

    private static int findSecondLargestNumberUsingTwoLoops(int[] input) {
        if(input == null || input.length<2){
            throw new IllegalArgumentException("Array is empty");
        }
        int len=input.length;
        int largestNum=Integer.MIN_VALUE;
        //Find largest number first
        for(int i=0;i<len;i++){
            largestNum=Math.max(largestNum,input[i]);
        }
        int secondLargestNum=Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
            int curr=input[i];
            if(curr>secondLargestNum && curr!=largestNum){
                secondLargestNum=curr;
            }
        }
        return secondLargestNum;
    }

    private static int findSecondLargestNumber(int[] input) throws Exception {

        if(input==null || input.length<2) {
            throw new IllegalArgumentException("Array Length is < 2");
        }
        int largestEle=Integer.MIN_VALUE;
        int secLargestEle=Integer.MIN_VALUE;
        boolean foundSecond=false;

        for(int num:input){
            if(num>largestEle){
                secLargestEle=largestEle;
                largestEle=num;
                if(secLargestEle!=Integer.MIN_VALUE){
                    foundSecond=true;
                }
            }
            else if(num>secLargestEle && num!=largestEle){
                secLargestEle=num;
                foundSecond=true;
            }
        }
        if(!foundSecond)
            throw new IllegalArgumentException("Number not found");
        return secLargestEle;
    }
}
