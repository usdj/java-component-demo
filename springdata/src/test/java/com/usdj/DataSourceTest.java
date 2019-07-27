package com.usdj;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author gerrydeng
 * @date 2019-07-25 11:10
 * @Description:
 */
public class DataSourceTest {

    private ApplicationContext ctx = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testDataSource(){
        DataSource source = (DataSource) ctx.getBean("dataSource");
        Assert.assertNotNull(source);
    }

    @Test
    public void testJdbcTemplate(){
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        Assert.assertNotNull(jdbcTemplate);
    }
}
