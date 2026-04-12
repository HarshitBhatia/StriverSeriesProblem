package bit.hard;

import utility.Helper;

import java.util.ArrayList;
import java.util.List;

public class PrintDivisorOfANumber {
    public static void main(String[] args) {
        int num=36;
        List<Integer> divisors = FindDivisorOfANumber(num);
        Helper.printIntegerList(divisors);
    }

    private static List<Integer> FindDivisorOfANumber(int num) {
        List<Integer> divisors=new ArrayList<>();
        for(int i = 1; i*i<= num; i++){
            if(num %i==0){
                divisors.add(i);
                if(i!=(num /i)){
                    divisors.add(num /i);
                }
            }
        }
        return divisors;
    }
}
