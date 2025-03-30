package PatternProblem;

/*
Here we will print
1
2 3
4 5 6
7 8 9 10
*/
public class Star13 {
    public static void main(String[] args) {
        printPattern();
    }

    private static void printPattern() {
        int n=5;
        int counter=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(counter+++" ");
            }
            System.out.println();
        }
    }


}
