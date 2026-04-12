package recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class GeneratePowerSetOfString {
    public static void main(String[] args) {
        String str="abc";
        int len=str.length();
//        List<String> op=generatePowerSet(str,len);
        List<String> op=new ArrayList<>();
        generatePowerSetUsingRecursion(str,op,new StringBuilder(""),0);
        prinListValues(op);
    }

    private static void prinListValues(List<String> op) {
        System.out.println("Substrings are following..");
        for(String val:op){
            System.out.print(val+ " ");
        }
    }

    private static List<String> generatePowerSet(String str, int len) {
        List<String> op=new ArrayList<>();
        int totalCount=1<<len;
        for(int mask=0;mask<totalCount;mask++){
            StringBuilder temp=new StringBuilder();
            for(int i=0;i<len;i++){
                if((mask & (1<<i))!=0){
                    temp.append(str.charAt(i));
                }
            }
            op.add(temp.toString());
        }
        return op;
    }

    private static void generatePowerSetUsingRecursion(String str,List<String> op,StringBuilder temp,int index) {
        op.add(temp.toString());
        for(int i=index;i<str.length();i++){
            temp.append(str.charAt(i));
            generatePowerSetUsingRecursion(str,op,temp,i+1);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
