package com.yitian.mybatis.dao;

import com.yitian.mybatis.model.Student;
import com.yitian.mybatis.vo.StudentVo;

import java.util.List;

public interface StudentDao {
        public Student findStudentById(int id);
        public List<Student> likeStudent(String name);
        public void updateStudent(Student student);
        public void insertStudent(Student student);
        public Student findStudentVo(StudentVo vo);
        public List<Student> findStudent(Student student);
        public Student studentQuery(Student student);
        public void deleteStudentById(int[] ids);
}
