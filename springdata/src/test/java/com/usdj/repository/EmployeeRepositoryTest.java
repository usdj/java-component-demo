package com.usdj.repository;

import com.usdj.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.tools.jconsole.inspector.XTable;

import static org.junit.Assert.*;

/**
 * @author gerrydeng
 * @date 2019-07-25 15:09
 * @Description:
 */
public class EmployeeRepositoryTest {

    private ApplicationContext ctx = null;
    private EmployeeRepository employeeRepository = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans2.xml");
        employeeRepository = ctx.getBean(EmployeeRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }


    @Test
    public void testFindByName(){
        Employee employee = employeeRepository.findByName("tom");
        System.out.println("id: " + employee.getId() + "name: " + employee.getName() + " age: " + employee.getAge());
    }
}