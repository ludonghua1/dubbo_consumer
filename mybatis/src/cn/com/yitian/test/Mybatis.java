package cn.com.yitian.test;


import cn.com.yitian.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Mybatis {
    @Test
    public void test() throws IOException {
        //1、加载核心配置文件resources是mybatis提供一个读取配置文件的工具类
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        //2、创建SQLSession工厂，使用工厂建造者模式
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3、创建sqlSession,会话对象（类似于connection）
        SqlSession session = factory.openSession();
        //4、使用会话对象去操作statement，映射文件当中的sql标签
        List<Student> list = session.selectList("student.findStudent");
        System.out.println(list);
        //5、释放资源
        session.close();
    }
    @Test
    public  void test1() throws Exception {
        //1、加载核心配置文件resources是mybatis提供一个读取配置文件的工具类
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        //2、创建SQLSession工厂，使用工厂建造者模式
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3、创建sqlSession,会话对象（类似于connection）
        SqlSession session = factory.openSession();
        //4、使用会话对象去操作statement，映射文件当中的sql标签
        Student student = new Student();
        student.setName("哈哈");
        student.setAge(15);
        student.setClazz("三班");
        student.setCountry("美国");
        session.insert("student.insertStudent",student);
        System.out.println(student);
        //提交事务
        session.commit();
        //释放资源
        session.close();

    }
    @Test
    public void test2() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        Student student = session.selectOne("student.findStudentById",9);
        System.out.println(student);
        session.close();
    }
    @Test
    public void test3() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        List<Student> list = session.selectList("student.likeStudent","王");
        System.out.println(list);
    }
    @Test
    public void test4() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        Student student = new Student();
        student.setId(10);
        student.setName("张三");
        student.setAge(24);
        session.update("student.updateStudent",student);
        System.out.println(student);
        session.commit();
        session.close();
    }
    @Test
    public void test5() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        session.delete("student.deleteStudent",9);
        session.commit();
    }
}
