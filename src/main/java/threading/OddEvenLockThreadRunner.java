package threading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class OddEvenThreadUsingLocks {
    private Lock lock=new ReentrantLock();
    private Condition oddWait=lock.newCondition();
    private Condition evenWait=lock.newCondition();;
    int maxNum,num;
    OddEvenThreadUsingLocks(int maxNum, int num){
        this.num=num;
        this.maxNum=maxNum;
    }

    public void printEven(){
        lock.lock();
        try{
            while(num<=maxNum) {
                while (num % 2 != 0) {
                    evenWait.await();
                }
                if(num<=maxNum){
                    System.out.println("PrintEven is printing " + (num++));
                    oddWait.signalAll();
                }
            }
        }
        catch(InterruptedException exc){
            Thread.currentThread().interrupt();
        }
        finally{
            lock.unlock();
        }

    }

    public void printOdd(){
        lock.lock();
        try{
            while(num<=maxNum){
                while(num%2==0){
                    oddWait.await();
                }
                if(num<+maxNum){
                    System.out.println("PrintOdd is printing "+ (num++));
                    evenWait.signalAll();
                }
            }
        }
        catch(InterruptedException exc){
            Thread.currentThread().interrupt();
        }
        finally{
            lock.unlock();
        }
    }
}
public class OddEvenLockThreadRunner{
    public static void main(String[] args) {
        OddEvenThreadUsingLocks obj=new OddEvenThreadUsingLocks(10,0);
        Thread t1=new Thread(obj :: printEven);
        Thread t2=new Thread(obj :: printOdd);
        t1.start();t2.start();
    }
}
