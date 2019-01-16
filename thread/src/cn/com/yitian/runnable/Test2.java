package cn.com.yitian.runnable;

public class Test2 {
    public static void main(String[] args) {
        //创建任务类
        Sales sales = new Sales();
        Thread thread1 = new Thread(sales);
        Thread thread2 = new Thread(sales);
        thread1.setName("窗口1");
        //thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setName("窗口2");
        //thread2.setPriority(Thread.MAX_PRIORITY);
        //当两个线程同时运行的时候，会对共享资源进行操作，有可能产生问题
        thread1.start();
        thread2.start();
    }
}
