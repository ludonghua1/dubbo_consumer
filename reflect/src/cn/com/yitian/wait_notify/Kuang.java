package cn.com.yitian.wait_notify;

public class Kuang  {
    private int count=0;
    public void add(){
        count++;
    }
    public void del(){
        count--;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
