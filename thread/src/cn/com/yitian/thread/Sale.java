package cn.com.yitian.thread;

public class Sale extends Thread {
    public  int cont=100;
    @Override
    public void run() {
        while (true){
            if (cont==0){
                break;
            }else {
                cont--;
                System.out.println(Thread.currentThread().getName()+"余票   "+cont);
            }
        }
    }
}
