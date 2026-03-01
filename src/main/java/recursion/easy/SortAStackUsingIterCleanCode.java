package recursion.easy;

import java.util.Stack;

public class SortAStackUsingIterCleanCode {

    public static void main(String[] args) {
        Stack<Integer>org=new Stack<>();
        org.push(1);
        org.push(3);
        org.push(2);
        org.push(10);
        org.push(9);
        org.push(4);
        org.push(5);
        printStack(org);
        //Now will sort this stack
        Stack<Integer>copy=new Stack<Integer>();
        while(!org.isEmpty()){
            int popV=org.pop();
            while(!copy.isEmpty() && copy.peek()>popV){
                org.push(copy.pop());
            }
            copy.push(popV);
        }
        printStack(copy);
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
