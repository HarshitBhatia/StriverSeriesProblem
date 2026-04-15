package Interview.Today;

import java.util.ArrayList;
import java.util.List;

public class CountNumberOfSubsequneceMatchingPrefix {
    public static int count;
    private static String prefix="101";
    public static void main(String[] args) {
        count=0;
        String input="1001";
//        String input="10101";
        List<String> curr=new ArrayList<>();
        findAndMatchedSubstring(0,new StringBuilder(""),input,curr);
        System.out.println("Total count is "+count);
        int noOfPossiblePattern=countPattern(input);
        System.out.println("Total count is "+noOfPossiblePattern);
//        System.out.println("Following are substrings");
//        for(String str:curr){
//            System.out.println(str);
//        }
        Long number=9L;
        int count=findAndCountSubstring(number);
        System.out.println("Total count is "+count);
    }
    private static void findAndMatchedSubstring(int index, StringBuilder curr, String input,List<String> currList){
        if(index==input.length()){
//            currList.add(curr.toString());
            if(checkPatternMatches(curr)){
                currList.add(curr.toString()+ "True");
                count++;
            }
            else
            currList.add(curr.toString()+ "False");
            return;
        }
        curr.append(input.charAt(index));
        findAndMatchedSubstring(index+1,curr,input,currList);
        curr.deleteCharAt(curr.length()-1);
        curr.append('_');
        findAndMatchedSubstring(index+1,curr,input,currList);
        curr.deleteCharAt(curr.length()-1);
    }
    private static boolean checkPatternMatches(StringBuilder pattern){
        StringBuilder tempStr=new StringBuilder();
        for(int i=0;i<pattern.length();i++){
            if(pattern.charAt(i)!='_') {
                tempStr.append(pattern.charAt(i));
            }
        }
        return tempStr.toString().equals(CountNumberOfSubsequneceMatchingPrefix.prefix);
    }
    private static int countPattern(String input){
        int count=0,len=input.length();
        long mask = 1L <<len;
        for(int m=0;m<mask;m++){
            StringBuilder currStr=new StringBuilder();
            for(int i=0;i<len;i++){
                if((m & (1<<i))!=0){
                    currStr.append(input.charAt(i));
                }
            }
            count+=currStr.toString().equals(CountNumberOfSubsequneceMatchingPrefix.prefix)?1:0;
        }
        return count;
    }

    private static int findAndCountSubstring(Long num){
        String binaryString=Long.toBinaryString(num);
        int count1=0,count10=0,count101=0;
        for(char ch:binaryString.toCharArray()){
            if(ch=='1'){
                count1++;
                count101=count101+count10;
            }
            else{
                count10=count10+count1;
            }
        }
        return count101;
    }
}

