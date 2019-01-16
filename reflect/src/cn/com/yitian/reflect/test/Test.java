package cn.com.yitian.reflect.test;

import cn.com.yitian.reflect.model.Athlete;
import cn.com.yitian.reflect.util.ReflectUtil;
import cn.com.yitian.reflect.util.Util;

import java.sql.*;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aa","root","");
        String sql = "select * from Athlete";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        ReflectUtil<Athlete> util = new ReflectUtil<>();
        List<Athlete> list = util.reflect(rs,Athlete.class);
        System.out.println(list);
    }
}
