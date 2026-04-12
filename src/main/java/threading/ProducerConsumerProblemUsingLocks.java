package threading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerProblemUsingLocks {
    public static void main(String[] args) {
        SharedBufferLock buffer =new SharedBufferLock(10);
        new Thread(()->{
            int value=0;
            try{
                while(true){
                    buffer.produce(value);
                    Thread.sleep(200);
                    value++;
                }
            }
            catch(InterruptedException exc){
                Thread.currentThread().interrupt();
            }
        }).start();
        new Thread(()->{
            try{
                while(true){
                    buffer.consume();
                    Thread.sleep(800);
                }
            }
            catch(InterruptedException exc){
                Thread.currentThread().interrupt();
            }
        }).start();
    }
}

class SharedBufferLock{
    private Queue<Integer> buffer=new LinkedList<>();
    private int capacity;
    private Lock lock=new ReentrantLock();
    private Condition notFull=lock.newCondition();
    private Condition notEmpty=lock.newCondition();

    public SharedBufferLock(int capacity){
        this.capacity=capacity;
    }

    public void produce(int value) throws InterruptedException {
        lock.lock();
        try {
            while (buffer.size() == capacity) {
                notFull.await();
            }
            buffer.add(value);
            System.out.println("Produced: " + value);
            notEmpty.signalAll();
        }
        finally{
            lock.unlock();
        }
    }
    public void consume() throws InterruptedException {
        lock.lock();
        try{
            while(buffer.isEmpty()){
                notEmpty.await();
            }
            int value=buffer.poll();
            System.out.println("Consumed: " + value);
            notFull.signalAll();
        }
        finally{
            lock.unlock();
        }
    }
}

