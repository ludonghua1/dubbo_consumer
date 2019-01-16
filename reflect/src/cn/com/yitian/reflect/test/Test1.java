package cn.com.yitian.reflect.test;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test1 {
    public static void main(String[] args) throws Exception{
        //1.取代目标类在jvm当中的元数据。
        Class clazz = Class.forName("cn.com.yitian.reflect.model.Reflect");
        //2.得到目标类的对象实例，必须得到object类型。
        Object obj = clazz.newInstance();
        //3.反射取到eat方法对象。
        Method method = clazz.getMethod("eat");
        //4.反射执行该方法
        method.invoke(obj);
    }
}
