package com.usdj.dao;

import com.usdj.domain.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author gerrydeng
 * @date 2019-07-25 14:05
 * @Description:
 */
public class StudentDaoSpringJdbcImplTest {

    private ApplicationContext ctx = null;
    private StudentDao studentDao = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        studentDao = (StudentDao) ctx.getBean("studentDaoSpringJdbc");
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testQuery(){
        studentDao.query().forEach(e-> System.out.println(e.getId() + " " + e.getName() + " " + e.getAge()));

    }

    @Test
    public void testSave(){
        Student student = new Student();
        student.setName("spring-jdbc");
        student.setAge(20);
        studentDao.save(student);
    }


}