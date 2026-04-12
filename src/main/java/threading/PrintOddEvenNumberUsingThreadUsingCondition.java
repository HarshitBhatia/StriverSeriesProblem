package threading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintOddEvenNumberUsingThreadUsingCondition {
    public static void main(String[] args) {
        OddEvenPrinterUsingLocksAndCondition printer = new OddEvenPrinterUsingLocksAndCondition(40);
        Thread even = new Thread(() -> {
            try {
                printer.printEven();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread odd = new Thread(() -> {
            try {
                printer.printOdd();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        odd.start();
        even.start();
        try {
            odd.join();
            even.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Both thread ended");
    }
}

class OddEvenPrinterUsingLocksAndCondition {
    private int count = 1;
    private final int max;
    private Lock lock = new ReentrantLock();
    private Condition evenCondition = lock.newCondition();
    private Condition oddCondition = lock.newCondition();

    public OddEvenPrinterUsingLocksAndCondition(int max) {
        this.max = max;
    }


    public void printEven() throws InterruptedException {
        lock.lock();
        try {
            while (count <= max) {
                while (count % 2 == 1) {
                    evenCondition.await();
                }
                System.out.println("Even Thread Printed " + count);
                count++;
                oddCondition.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public void printOdd() throws InterruptedException {
        lock.lock();
        try {
            while (count <= max) {
                while (count % 2 == 0) {
                    oddCondition.await();
                }

                System.out.println("Odd Thread Printed " + count);
                count++;
                evenCondition.signal();
            }
        } finally {
            lock.unlock();
        }
    }
}
