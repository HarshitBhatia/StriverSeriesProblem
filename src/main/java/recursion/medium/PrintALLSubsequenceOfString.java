package recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class PrintALLSubsequenceOfString {

    public static void main(String[] args) {
        String str="abcd";
        List<String> op=new ArrayList<>();
        generateAllSubSequence(op,str,new StringBuilder(""),0,str.length());
        printList(op);
    }

    private static void printList(List<String> op) {
        System.out.println("All substring are follows");
        for(String str:op){
            System.out.print(str+ " ");
        }
    }

    private static void generateAllSubSequence(List<String> op, String input, StringBuilder str, int index, int len) {
        if(index==len){
            op.add(str.toString());
            return;
        }
        generateAllSubSequence(op,input,str,index+1,len);
        str.append(input.charAt(index));
        generateAllSubSequence(op,input,str,index+1,len);
        str.deleteCharAt(str.length()-1);

    }
}
