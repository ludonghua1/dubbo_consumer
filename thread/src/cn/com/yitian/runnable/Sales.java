package cn.com.yitian.runnable;

public class Sales implements Runnable{
    public  int cont=50;
    public  Object lock = new Object();
    /*
    * java中提供了同步锁机制，有效的解决了并发问题
    */
    @Override
    public void run() {
        synchronized (lock){
            while (true){
                if (cont==0){
                    break;
                }else {
                    cont--;
                    System.out.println(Thread.currentThread().getName()+"余票"+cont);
                    try {
                        Thread.currentThread().sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
