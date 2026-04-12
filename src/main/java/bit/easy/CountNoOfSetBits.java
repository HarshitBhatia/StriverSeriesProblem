package bit.easy;

public class CountNoOfSetBits {
    public static void main(String[] args) {
        int num=35;
        int count=0;
        while(num!=0){
            count+=num&1;
            num>>=1;
        }
        System.out.println(count);
    }
}
