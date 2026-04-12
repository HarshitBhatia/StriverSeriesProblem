package threading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerProblem {
    public static void main(String[] args) {
        SharedBuffer buffer =new SharedBuffer(10);
        Producer producer=new Producer(buffer);
        Consumer consumer=new Consumer(buffer);
        producer.start();
        consumer.start();
    }
}

class SharedBuffer{
    int capacity;
    Queue<Integer> buffer;
    public SharedBuffer(int capacity){
        this.capacity=capacity;
        this.buffer=new LinkedList<Integer>();
    }

    public synchronized void produce(int value) throws InterruptedException {
        while(buffer.size()==capacity){
            //Waiting buffer to be empty
            wait();
        }
        buffer.add(value);
        System.out.println("Producer thread produce "+ value);
        notifyAll();

    }

    public synchronized void consume() throws InterruptedException {
        while(buffer.isEmpty()){
            //Waiting buffer to be empty
            wait();
        }
        int value= buffer.poll();
        System.out.println("Consumer thread consume "+ value);
        notifyAll();
    }
}

class Producer extends Thread{
    SharedBuffer buffer;
    public Producer(SharedBuffer buffer){
        this.buffer=buffer;
    }

    @Override
    public void run(){
        int value=0;
        try {
            while(true) {
                buffer.produce(value);
                Thread.sleep(1000);
                value++;
            }
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Consumer extends Thread{
    SharedBuffer buffer;
    public Consumer(SharedBuffer buffer){
        this.buffer=buffer;
    }

    @Override
    public void run(){
        try {
            while(true) {
                buffer.consume();
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
