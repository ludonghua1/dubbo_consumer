package com.yitian.mybatis.test;


import com.yitian.mybatis.model.Student;
import com.yitian.mybatis.service.StudentService;
import com.yitian.mybatis.service.impl.StudentServiceImpl;
import com.yitian.mybatis.vo.StudentVo;
import org.junit.Test;

import java.util.List;

public class StudentServiceTest {
    @Test
    public void test(){
        StudentService ss = new StudentServiceImpl();
        System.out.println(ss.findStudentById(17));
    }
    @Test
    public void test1(){
        StudentService ss = new StudentServiceImpl();
        System.out.println(ss.likeStudent("哈"));
    }
    @Test
    public void test2(){
        StudentService ss = new StudentServiceImpl();
        Student student = new Student();
        student.setId(12);
        student.setName("李四");
        student.setAge(16);
        student.setBirthday("999");
        ss.updateStudent(student);
        System.out.println(student);
    }
    @Test
    public void test3(){
        StudentService ss = new StudentServiceImpl();
        Student student = new Student();
        student.setName("花花");
        student.setAge(13);
        student.setClazz("三班");
        student.setCountry("加拿大");
        student.setTelNumber("1527846646");
        ss.insertStudent(student);
        System.out.println(student);
    }
    @Test
    public void test4(){
        StudentService ss=new StudentServiceImpl();
        StudentVo vo=new StudentVo();
        Student s=new Student();
        s.setName("张三");
        s.setAge(24);
        vo.setStudent(s);
        Student student= ss.findStudentVo(vo);
        System.out.println(student);
    }
    @Test
    public void test5(){
        StudentService ss = new StudentServiceImpl();
        Student student = new Student();
        List<Student> list = ss.findStudent(student);
        System.out.println(list);
    }
    @Test
    public void test6(){
        StudentService ss  = new StudentServiceImpl();
        Student student = new Student();
        student.setName("赵");
        System.out.println(ss.studentQuery(student));
    }
    @Test
    public void test7(){
        StudentService ss  = new StudentServiceImpl();
        int[] ids={10,11};
        ss.deleteStudentById(ids);
    }
}
