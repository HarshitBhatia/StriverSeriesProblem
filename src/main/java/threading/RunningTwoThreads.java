package threading;

public class RunningTwoThreads {
    public static volatile boolean visible = true;

    public static void main(String[] args) {
        NumberPrinter1 thread1 = new NumberPrinter1();
        NumberPrinter2 thread2 = new NumberPrinter2();
        thread1.start();
        thread2.start();
    }
}

class NumberPrinter1 extends Thread {
    public void run() {
        long i = 1;
        while (RunningTwoThreads.visible) {
//            System.out.println("Hello");
            i++;
        }
        System.out.println("Thread 1 stopped value of i is "+ i);
    }
}

class NumberPrinter2 extends Thread {
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        RunningTwoThreads.visible = false;
    }
}
