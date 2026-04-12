package recursion.easy;

import java.util.Stack;

public class SortAStackUsingRecursion {
    public static void main(String[] args) {
        Stack<Integer> stk=new Stack<>();
        stk.push(1);
        stk.push(3);
        stk.push(2);
        stk.push(10);
        stk.push(9);
        stk.push(4);
        stk.push(5);
        //Now will sort this stack
        printStack(stk);
        //After sort
        reverseStack(stk);
        printStack(stk);
    }

    private static void reverseStack(Stack<Integer> stk) {
        if(!stk.isEmpty()){
            Integer temp=stk.pop();
            reverseStack(stk);
            insertAtBottom(temp,stk);
        }
    }

    private static void insertAtBottom(Integer temp, Stack<Integer> stk) {
        if(stk.isEmpty()){
            stk.push(temp);
            return ;
        }
        Integer popV=stk.pop();
        insertAtBottom(temp,stk);
        stk.push(popV);
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
