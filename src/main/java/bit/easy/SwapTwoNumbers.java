package bit.easy;

public class SwapTwoNumbers {
    public static void main(String[] args) {
        int x=10, y=-900;
        System.out.println("Before swap "+x+" "+y);
        x=x^y;
        y=x^y;
        x=x^y;
        System.out.println("After swap "+x+" "+y);
    }
}
