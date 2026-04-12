package threading;

import java.util.concurrent.atomic.AtomicInteger;

public class OddEvenThreadUsingAtomicNumbers {
    public static void main(String[] args) {

        AtomicOddEvenClass obj=new AtomicOddEvenClass();
        Thread t1=new Thread(new Runnable(){
            @Override
            public void run(){
                obj.printEven();
            }
        });
        Thread t2=new Thread(new Runnable(){
            @Override
            public void run(){
                obj.printOdd();
            }
        });
        t1.start();
        t2.start();
    }
}
class AtomicOddEvenClass{
    AtomicInteger value=new AtomicInteger(0);
    int max=10;
    public void printEven(){
        while(true){
            int current=value.get();
            if(current>max) break;
            if(current%2==0){
                if(value.compareAndSet(current,current+1)){
                    System.out.println("Even Value by PrintEven "+current);
                }
            }
        }
    }
    public void printOdd(){
        while(true){
            int current=value.get();
            if(current>max) break;
            if(current %2==1){
                if(value.compareAndSet(current,current+1)){
                    System.out.println("Odd Value by PrintOdd "+current);
                }
            }
        }
    }
}