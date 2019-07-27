package com.usdj.dao;

import com.usdj.domain.Student;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author gerrydeng
 * @date 2019-07-25 10:34
 * @Description:
 */
public class StudentDaoImplTest {

    @Test
    public void testQuery(){
        StudentDaoImpl studentDao = new StudentDaoImpl();
        studentDao.query().forEach( e-> System.out.println(e.getId() + " " + e.getName() + " " + e.getAge()));
    }

    @Test
    public void testSave(){
        StudentDaoImpl studentDao = new StudentDaoImpl();
        Student student = new Student();
        student.setName("jerry");
        student.setAge(25);
        studentDao.save(student);
    }

}