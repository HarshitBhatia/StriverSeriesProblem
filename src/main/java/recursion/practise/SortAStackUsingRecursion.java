
package recursion.practise;

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
        sortStack(stk);
        printStack(stk);
    }

    private static void sortStack(Stack<Integer> stk) {
        if(!stk.isEmpty()){
            int value=stk.pop();
            sortStack(stk);
            insertInStack(stk,value);
        }
    }

    private static void insertInStack(Stack<Integer> stk,Integer temp) {
        if(stk.isEmpty() || stk.peek()<=temp){
            stk.push(temp);
            return;
        }
        Integer popValue=stk.pop();
        insertInStack(stk,temp);
        stk.push(popValue);
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
