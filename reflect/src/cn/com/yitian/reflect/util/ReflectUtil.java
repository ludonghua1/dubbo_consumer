package cn.com.yitian.reflect.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReflectUtil<T> {
    public List<T> reflect(ResultSet rs,Class<T> clazz) throws Exception{
        List<T> list = new ArrayList<T>();
        while (rs.next()){
           //创建目标的类对象实例
           T obj = clazz.newInstance();
           //取到目标类所有的属性
            Field[] files = clazz.getDeclaredFields();
            for (Field field:files){
                //属性类型
                String name =field.getName();
                if (field.getType().equals(String.class)){
                    //数据库的字段值
                    String value = rs.getString(name);
                    //将数据库的字段值设置给obj当中的属性值
                    //拼接每一个属性对应的set方法的名称
                    String methodName = "set"+name.substring(0,1).toUpperCase()+name.substring(1);
                    Method method = clazz.getMethod(methodName,String.class);
                    method.invoke(obj,value);
                }else if(field.getType().equals(Integer.class)){
                    int value = rs.getInt(name);
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
