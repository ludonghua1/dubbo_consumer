package cn.com.yitian.reflect.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Util<T> {
    public List<T> util(ResultSet rs,Class<T> clazz)throws Exception{
        List<T> list = new ArrayList<>();
        while (rs.next()){
            //创建目标类对象实例
            T obj = clazz.newInstance();
            //取到目标类的所有属性
            Field[] fields = clazz.getDeclaredFields();
            for (Field field:fields){
                String name = field.getName();
                if (field.getType().equals(String.class)){
                    //数据库的字段值
                    String value = rs.getString(name);
                    //拼接每一个属性对应的用set方法的名称
                    String methodName = "set"+name.substring(0,1).toUpperCase()+name.substring(1);
                    Method method = clazz.getMethod(methodName,String.class);
                    method.invoke(obj,value);
                }else if (field.getType().equals(Integer.class)){
                    Integer value = rs.getInt(name);
                    String methodName = "set"+name.substring(0,1).toUpperCase()+name.substring(1);
                    Method method = clazz.getMethod(methodName,Integer.class);
                    method.invoke(obj,value);
                }
            }
            list.add(obj);
        }
        return list;
    }
}
