package cn.com.yitian.thread;

public class Test1 {
    public static void main(String[] args) {
        Thread thread1 = new Sale();
        Thread thread2 = new Sale();
        thread1.setName("窗口1");
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setName("窗口2");
        thread1.start();
        thread2.start();
    }
}
