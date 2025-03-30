package PatternProblem;

/*
Here we will print
A
AB
ABC
ABCD
ABCDE
*/
public class Star14 {
    public static void main(String[] args) {
        printPattern();
    }

    private static void printPattern() {
        int n=10;
        char val='A';
        for(int i=1;i<=n;i++){
            char jVal=val;
            for(int j=1;j<=i;j++){
                System.out.print(jVal++);
            }
            System.out.println();
        }
    }


}
