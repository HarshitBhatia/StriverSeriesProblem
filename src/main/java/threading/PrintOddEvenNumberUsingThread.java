package threading;

public class PrintOddEvenNumberUsingThread {
    public static void main(String[] args) {
        OddEvenPrinter printer = new OddEvenPrinter(40);
        Thread even = new Thread(() -> {
            try {
                printer.printEven();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        even.start();
        Thread odd = new Thread(() -> {
            try {
                printer.printOdd();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        odd.start();
        try {
            odd.join();
            even.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Both thread ended");
    }
}

class OddEvenPrinter {
    private int count = 0;
    private final int max;

    public OddEvenPrinter(int max) {
        this.max = max;
    }

    public synchronized void printEven() throws InterruptedException {
        while (count <= max) {
            while (count % 2 == 1) {
                wait();
            }
            if(count>max){
                notifyAll();
                break;
            }
            System.out.println("Even Thread Printed " + count);
            count++;
            notify();

        }
    }

    public synchronized void printOdd() throws InterruptedException {
        while (count <= max) {
            while (count % 2 == 0) {
                wait();
            }
            if(count>max){
                notifyAll();
                break;
            }
            System.out.println("Odd Thread Printed " + count);
            count++;
            notify();

        }
    }
}
