package bit.hard;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import utility.Helper;

public class PrimefactorisationofaNumber {
    public static void main(String[] args) {
        int[] queries =new int[]{2,3,4,5,6};
//        int[] queries =new int[]{7,12,18};
        List<List<Integer>> op=findPrimeFactors(queries);
        Helper.printListValues(op);
    }

    private static List<List<Integer>> findPrimeFactors(int[] queries) {
        List<List<Integer>> op=new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            op.add(findPrimeDivisor(queries[i]));
        }
        return op;
    }

    private static List<Integer> findPrimeDivisor(int num) {
        List<Integer> op=new ArrayList<>();
        if(num%2==0){
//            op.add(2);
            while(num%2==0){
                op.add(2);
                num/=2;
            }
        }
        for(int i=3;i*i<=num;i+=2){
            if(num%i==0){
                while(num%i==0){
                    op.add(i);
                    num/=i;
                }
            }
        }
        if(num>1){
            op.add(num);
        }
        return op;
    }
}
