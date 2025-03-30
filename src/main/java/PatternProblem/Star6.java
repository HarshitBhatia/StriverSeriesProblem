package PatternProblem;

/*
Here we will print
   *
  ***
 *****
*******
*/
public class Star6 {
    public static void main(String[] args) {
//        printOneWay();
        printSecondWay();
    }

    private static void printSecondWay() {
        int n=5;
        for(int i=1;i<=n;i++){
            System.out.println(" ".repeat(n-i) + "*".repeat(i*2-1));
        }
    }

    private static void printOneWay() {
        int n=10;
        int colLimit;
        for(int i=1;i<=n;i++){
            colLimit=i*2;
            for(int j=1;colLimit>1;j++){
                if(i+j<=n){
                    System.out.print(" ");
                }
                else{
                    colLimit--;
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
