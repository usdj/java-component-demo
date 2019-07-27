package com.usdj.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gerrydeng
 * @date 2019-07-25 15:02
 * @Description:
 */
public class SpringDataTest {

    private ApplicationContext ctx = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans2.xml");

        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testEntityManagerFactory(){}
}
