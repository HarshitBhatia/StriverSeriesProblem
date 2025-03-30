package PatternProblem;

/*
Here we will print
E
DE
CDE
BCDE
ABCDE
*/
public class Star18 {
    public static void main(String[] args) {
        printPattern();
    }

    private static void printPattern() {
        int n=5;
        char val=(char)(65+n-1);
        for(int i=1;i<=n;i++,val--){
            char tempVal=val;
            for(int j=1;j<=i;j++){
                System.out.print(tempVal++);
            }
            System.out.println();
        }
    }
}
