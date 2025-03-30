package PatternProblem;

/*
Here we will print
*******
 *****
  ***
   *
*/
public class Star7 {
    public static void main(String[] args) {
        printPattern();
    }

    private static void printPattern() {
        int n=5;
        int colDist,space=0;
        for(int i=0;i<n;i++){
            colDist=(n-i)*2-1;
            for(int j=0;j<colDist+space;j++){
                if(j<space) System.out.print(" ");
                else System.out.print("*");
            }
            space++;
            System.out.println();
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
