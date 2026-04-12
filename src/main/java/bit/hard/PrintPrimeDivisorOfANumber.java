package bit.hard;

import utility.Helper;

import java.util.ArrayList;
import java.util.List;

public class PrintPrimeDivisorOfANumber {
    public static void main(String[] args) {
        int num=420;
        FindDivisorOfANumber(num);

    }

    private static void FindDivisorOfANumber(int num) {
        if(num%2==0){
            System.out.print("2 ");
            while(num%2==0){
                num/=2;
            }
        }
        for(int i=3;i*i<=num;i+=2){
            if(num%i==0){
                System.out.print(i+ " ");
                while(num%i==0) num/=i;
            }
        }
        if(num>1) System.out.print(num);
    }
}
