package PatternProblem;

/*
Here we will print
*      *
**    **
***  ***
********
***  ***
**    **
*      *
*/
public class Star20 {
    public static void main(String[] args) {
        printPattern();
    }

    private static void printPattern() {
        int n=10;
        int l=1,r=n;
        for(int i=1;i<=n;i++){
            //Top And Bottom Layer
            for(int j=1;j<=n;j++){
                if(j<=l || j>=r){
                    System.out.print("*");
                }
                else System.out.print(" ");
            }
            System.out.println();
            if(i<n/2){
                l++;
                r--;
            }
            else{
                l--;
                r++;
            }
        }
    }
}
