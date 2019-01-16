package cn.com.yitian.reflect.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Test2 {
    public static void main(String[] args) throws Exception {
        //
        Class clazz =Class.forName("cn.com.yitian.reflect.model.Dog");
        //目标类只有有参构造器
        //1.得到构造器对象
        Constructor con = clazz.getConstructor(String.class,Integer.class);
        //2.通过有参构造去构造对象
        Object obj = con.newInstance("黑色",1);
        //3.取到元数据当中的属性对象
        Field field = clazz.getField("color");
        Field field1 = clazz.getField("age");
        //4.得到属性对象的值
        Object value = field.get(obj);
        Object value1 = field1.get(obj);
        System.out.println(value+"   "+value1);
        
    }
}
