package com.usdj.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author gerrydeng
 * @date 2019-07-24 19:56
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        Filter f1 = new Filter();
        f1.setId(10);
        Filter f2 = new Filter();
        f2.setUserName("gerry");
        Filter f3 = new Filter();
        f3.setEmail("hello@usdj.com");
        System.out.println(MySql.query(f1));
        System.out.println(MySql.query(f2));
        System.out.println(MySql.query(f3));
    }

}
