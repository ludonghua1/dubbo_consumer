package cn.com.yitian.wait_notify;

public class Test {
    public static void main(String[] args) {
        Kuang kuang = new Kuang();
        Make make = new Make();
        make.setKuang(kuang);

        Consumer consumer = new Consumer();
        consumer.setKuang(kuang);

        make.start();
        consumer.start();
    }
}
