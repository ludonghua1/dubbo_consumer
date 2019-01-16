package cn.com.yitian.test;

import cn.com.yitian.model.Student;
import cn.com.yitian.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        SqlSessionFactory factory = MybatisUtil.getFactory();
        SqlSession session = factory.openSession();
        List<Student> list = session.selectList("student.findStudent");
        System.out.println(list);
    }
}
