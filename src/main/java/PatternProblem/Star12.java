package PatternProblem;

/*
Here we will print
1      1
12    21
123  321
12344321
*/
public class Star12 {
    public static void main(String[] args) {

        printPattern();
        printMoreConciseVersion();
    }

    private static void printMoreConciseVersion() {
        int n=10;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n*2;j++){
                //For left Part
                if(j<=i){
                    System.out.print(j);
                }
                //for Right Part
                else if(j>n*2-i){
                    System.out.print(n*2-j+1);
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static void printPattern() {
        int n=10;
        int val;
        for(int i=1;i<=n;i++){
            val=i;
            int op;
            boolean flag=true;
            for(int j=1;j<=n*2 && j>0;j+=op){
                if(j<=val){
                    System.out.print(j);
                }
                else{
                    System.out.print(" ");
                }
                if(j<n && flag){
                    op=1;
                }
                else if(j==n && flag){
                    flag=false;
                    op=0;
                }
                else{
                    op=-1;
                }
            }
            System.out.println();
        }
    }


}
