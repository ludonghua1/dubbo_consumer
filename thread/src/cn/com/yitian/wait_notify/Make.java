package cn.com.yitian.wait_notify;

public class Make extends Thread {
    private Kuang kuang;

    public void setKuang(Kuang kuang) {
        this.kuang = kuang;
    }

    @Override
    public void run() {
        while (true){
            synchronized (kuang){
                if (kuang.getCount()>=100){
                    System.out.println("面包师傅等待！！！！");
                    try {
                        kuang.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    kuang.add();
                    System.out.println("面包师傅做了一个面包"+kuang.getCount());
                    kuang.notify();
                }
            }

        }
    }
}
