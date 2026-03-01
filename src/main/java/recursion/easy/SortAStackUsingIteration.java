package recursion.easy;

import java.util.Stack;

public class SortAStackUsingIteration {
    static  Stack<Integer> org;
    static Stack<Integer> copy;
    public static void main(String[] args) {
        org=new Stack<>();
        org.push(1);
        org.push(3);
        org.push(2);
        org.push(10);
        org.push(9);
        org.push(4);
        org.push(5);
        //Now will sort this stack
        copy=new Stack<Integer>();
        printStack(org);
        //After sort
        while(!org.isEmpty()){
            Integer popV=org.pop();
            insertInCopy(copy,popV);
        }
        printStack(copy);
    }

    private static void insertInCopy(Stack<Integer> copy, Integer popV) {
        if(copy.isEmpty() || copy.peek()<=popV){
            copy.push(popV);
            return ;
        }
        while(!copy.isEmpty() && copy.peek()>popV){
            Integer temp=copy.pop();
            org.push(temp);
        }
        copy.push(popV);
    }



    private static void printStack(Stack<Integer> stk) {
        Stack<Integer> s=new Stack<Integer>();
        s.addAll(stk);
        while(!s.isEmpty()){
            int value=s.pop();
            System.out.print(value+" ");
        }
        System.out.println();
    }
}
