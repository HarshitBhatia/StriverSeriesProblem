package threading;



public class OddEvenThread {
    public static void main(String[] args) {
        PrintingOddEvenThread obj=new PrintingOddEvenThread();
        Thread t1= new Thread(() -> {
            try {
                obj.printEven();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2= new Thread(() -> {
            try {
                obj.printOdd();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
    }
}
//class OddThread extends Thread{
//    public void run(){
//       while(true){
//           if(OddEvenThread.value.get()%2!=1){
//               try {
//                   wait();
//               } catch (InterruptedException e) {
//                   throw new RuntimeException(e);
//               }
//           }
//           System.out.println("Odd Thread runs and value is "+OddEvenThread.value.get());
//           OddEvenThread.value.incrementAndGet();
//           notifyAll();
//       }
//    }
//}
//
//class EvenThread extends Thread{
//    public void run(){
//        while(true){
//            if(OddEvenThread.value.get()%2!=0){
//                try {
//                    wait();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            System.out.println("Even Thread runs and value is "+ OddEvenThread.value.get());
//            OddEvenThread.value.incrementAndGet();
//            notifyAll();
//        }
//    }
//}

class PrintingOddEvenThread {
    private  int value=1;
    private int maxValue=10;

    public synchronized void printEven() throws InterruptedException {
        while(value<=maxValue){
            while(value%2==1){
                wait();
            }
            if(value<=maxValue){
                System.out.println("Print Even "+ value);
                value++;
                notifyAll();
            }
        }
    }

    public  synchronized void printOdd() throws InterruptedException {
        while(value<=maxValue){
            while(value%2==0){
                wait();
            }
            if(value<=maxValue){
                System.out.println("Print Odd "+ value);
                value++;
                notifyAll();
            }
        }
    }
}
