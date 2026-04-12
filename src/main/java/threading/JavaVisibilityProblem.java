package threading;

public class JavaVisibilityProblem {
    public static void main(String[] args) {
        Employee emp=new Employee();
        Thread thread1=new Thread(()->{
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            emp.age=23;
            emp.id=100;
        });

        Thread thread2=new Thread(()->{
            if(emp.age==23){
                System.out.println(emp.age+" "+ emp.id);;
            }
        });
        thread2.start();
        thread1.start();
        System.out.println("Thread ended");
    }
}

class Employee{
    int age;
    int id;
    public Employee(){

    }
}
