package recursion.medium;

import java.util.Arrays;

public class GenerateAllBinaryStringsOfLenN {
    public static void main(String[] args) {
        int n=4;

        System.out.println(findBStringsCountOfN(0,0,n));

        System.out.println(findCountOfAllBSUsingDP(n));
        System.out.println(findCountOfAllBSUsingDP(n));
    }

    private static int findBStringsCountOfN(int index, int prev,int len) {
        if(index==len){
            return 1;
        }
        int count=findBStringsCountOfN(index+1,0,len);
        if(prev==0){
            count+=findBStringsCountOfN(index+1,1,len);
        }
        return count;
    }

    private static int findCountOfAllBSUsingDP(int n){
        if(n==0) return 1;
        if(n==1) return 2;
        int prev1=1,prev2=2;
        int curr=0;
        for(int i=2;i<=n;i++){
            curr=prev1+prev2;
            prev1=prev2;
            prev2=curr;
        }
        return curr;
    }
}
