package cn.com.yitian.wait_notify;

public class Consumer extends Thread {
    private Kuang kuang;

    public void setKuang(Kuang kuang) {
        this.kuang = kuang;
    }

    @Override
    public void run() {
        while (true){
            synchronized (kuang){
                if (kuang.getCount()<=20){
                    System.out.println("销售员等待！！！！");
                    try {
                        kuang.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    kuang.del();
                    System.out.println("销售员销售一个面包"+kuang.getCount());
                    kuang.notify();
                }
            }
        }
    }
}
