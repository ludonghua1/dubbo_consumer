package com.yitian.mybatis.vo;

import com.yitian.mybatis.model.Student;

public class StudentVo {
    private Student student;
    private String  birthday;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "StudentVo{" +
                "student=" + student +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
