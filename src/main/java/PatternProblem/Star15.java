package PatternProblem;

/*
Here we will print
ABCDE
ABCD
ABC
AB
A

*/
public class Star15 {
    public static void main(String[] args) {
        printPattern();
    }

    private static void printPattern() {
        int n=5;
        char val='A';
        for(int i=n;i>0;i--){
            char jVal=val;
            for(int j=1;j<=i;j++){
                System.out.print(jVal++);
            }
            System.out.println();
        }
    }


}
