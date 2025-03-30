package PatternProblem;

/*
Here we will print
1
0 1
1 0 1
0 1 0 1
1 0 1 0 1
*/
public class Star11 {
    public static void main(String[] args) {
        printPattern();
    }

    private static void printPattern() {
        int n=5;
        int val=1;
        for(int i=0;i<n;i++){
            int value=val;
            for(int j=0;j<=i;j++){
               System.out.print(value+" ");
               value^=1;
            }
            val=val==1?0:1;
            System.out.println();
        }
    }


}
