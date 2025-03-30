package PatternProblem;

/*
Here we will print
   *
  ***
 *****
*******
 *****
  ***
   *
*/
public class Star8 {
    public static void main(String[] args) {
        printPattern();
    }

    private static void printPattern() {
        int n=5;
        int space=n-1;
        int startC=1;
        for(int i=0;i<n*2-1;i++){
            for(int j=0;j<space+startC;j++){
                if(j<space) System.out.print(" ");
                else System.out.print("*");
            }
            if(i>=n-1) {
                space++;
                startC-=2;
            }
            else{
                space--;
                startC+=2;
            }

            System.out.println();
        }
    }


}
