package com.usdj.singleton;

import org.junit.Test;

/**
 * @author gerrydeng
 * @date 2019-07-24 13:25
 * @Description:
 */
public class SingletonTest {

    @Test
    public void test1(){
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        if (s1 == s2) {
            System.out.println("相等");
        } else {
            System.out.println("other");
        }
    }

    @Test
    public void Test2(){
        Singleton2 s1 = Singleton2.getInstance();
        Singleton2 s2 = Singleton2.getInstance();
        if (s1 == s2){
            System.out.println("相等");
        } else {
            System.out.println("other");
        }
    }
}
