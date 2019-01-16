package cn.com.yitian.reflect.model;

public class Dog {
    public String color;
    public Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Dog(String color, Integer age) {
        this.color = color;
        this.age = age;
    }

    public Dog() {
    }

    public String getColor() {
        return color;
    }

    public Dog(String color) {
        this.color = color;
    }
    public void eat(){
        System.out.println("吃骨头");
    }
}
