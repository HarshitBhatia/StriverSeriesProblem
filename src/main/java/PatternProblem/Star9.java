package PatternProblem;

/*
Here we will print
*
**
***
****
***
**
*
*/
public class Star9 {
    public static void main(String[] args) {
        printPattern();
    }

    private static void printPattern() {
        int n=5;
        int star=0;
        for(int i=0;i<n*2-1;i++){
            if(i<n){
                star++;
            }
            else star--;
            for(int j=0;j<star;j++){
               System.out.print("*");
            }
            System.out.println();
        }
    }


}
