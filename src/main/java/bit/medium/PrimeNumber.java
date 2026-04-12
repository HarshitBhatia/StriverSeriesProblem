package bit.medium;

//This is to check whether a number is prime or not
public class PrimeNumber {
    public static void main(String[] args) {
        int num=17;
//        checkMoreLongerVersion(num);
        boolean checkNum=checkMoreBetterVersion(num);
        System.out.println(checkNum);
    }

    private static boolean checkMoreLongerVersion(int num) {
        if(num <=1) {
            System.out.println("False");
            return true;
        }
        int divisor= num -1;
        while(divisor>1){
           if(num %divisor==0){
               System.out.println("False");
               return true;
           }
           divisor--;
        }
        System.out.println("True");
        return false;
    }

    private static boolean checkMoreBetterVersion(int num) {
        if(num<=1) return false;
        for(int i=2;i*i<=num;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }


}
