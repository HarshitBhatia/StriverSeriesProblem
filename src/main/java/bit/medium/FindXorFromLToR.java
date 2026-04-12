package bit.medium;

public class FindXorFromLToR {
    public static void main(String[] args) {
        int L=2,R=10;
        int xor=findXor(L-1)^findXor(R);
        System.out.println("Xor from L To R is "+xor);

    }
    private static int findXor(int num) {
        if(num<0) return 0;
        if(num%4==1) return 1;
        if(num%4==2) return num+1;
        if(num%4==3) return 0;
        else return num;
    }
}
