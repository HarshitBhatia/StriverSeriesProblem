package PatternProblem;

/*
Here we will print
   A
  ABA
 ABCBA
ABCDCBA
*/
public class Star17 {
    public static void main(String[] args) {
        printPattern();
    }

    private static void printPattern() {
        int n=10;
        char val='A';
        int space=n-1;
        int letter=1,op;
        for(int i=1;i<=n;i++){
            char tempVal=val;
            op=1;
            for(int j=1;j<=space+letter;j++){
                if(j<=space){
                    System.out.print(" ");
                    continue;
                }
                else {
                    System.out.print(tempVal);
                }
                if(tempVal-val+1==i){
                    op=-1;
                }
                tempVal+=op;
            }
            space--;
            letter+=2;
            System.out.println();
        }
    }


}
