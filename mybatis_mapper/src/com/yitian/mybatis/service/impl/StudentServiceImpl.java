package com.yitian.mybatis.service.impl;

import com.yitian.mybatis.dao.StudentDao;
import com.yitian.mybatis.model.Student;
import com.yitian.mybatis.service.StudentService;
import com.yitian.mybatis.util.MybatisUtil;
import com.yitian.mybatis.vo.StudentVo;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**/
public class StudentServiceImpl implements StudentService {
    @Override
    public Student findStudentById(int id) {
        SqlSession session = MybatisUtil.getFactory().openSession();
        StudentDao sd = session.getMapper(StudentDao.class);
        return sd.findStudentById(id);
    }

    @Override
    public List<Student> likeStudent(String name) {
        SqlSession session = MybatisUtil.getFactory().openSession();
        StudentDao sd = session.getMapper(StudentDao.class);
        return sd.likeStudent(name);
    }

    @Override
    public void updateStudent(Student student) {
        SqlSession session = MybatisUtil.getFactory().openSession();
        StudentDao sd = session.getMapper(StudentDao.class);
        sd.updateStudent(student);
        session.commit();
    }

    @Override
    public void insertStudent(Student student) {
        SqlSession session = MybatisUtil.getFactory().openSession();
        StudentDao sd = session.getMapper(StudentDao.class);
        sd.insertStudent(student);
        session.commit();
    }

    @Override
    public Student findStudentVo(StudentVo vo) {
        SqlSession session = MybatisUtil.getFactory().openSession();
        StudentDao sd = session.getMapper(StudentDao.class);
        return sd.findStudentVo(vo);
    }

    @Override
    public List<Student> findStudent(Student student) {
        SqlSession session = MybatisUtil.getFactory().openSession();
        StudentDao sd = session.getMapper(StudentDao.class);
        return sd.findStudent(student);
    }

    @Override
    public Student studentQuery(Student student) {
        SqlSession session = MybatisUtil.getFactory().openSession();
        StudentDao sd = session.getMapper(StudentDao.class);
        return sd.studentQuery(student);
    }

    @Override
    public void deleteStudentById(int[] ids) {
        SqlSession session = MybatisUtil.getFactory().openSession();
        StudentDao sd = session.getMapper(StudentDao.class);
        sd.deleteStudentById(ids);
        session.commit();
        session.close();
    }

}
