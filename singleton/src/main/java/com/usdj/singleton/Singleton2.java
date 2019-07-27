package com.usdj.singleton;

/**
 * @author gerrydeng
 * @date 2019-07-24 13:31
 * @Description: 懒汉模式
 */
public class Singleton2 {

    private Singleton2(){

    }

    private static Singleton2 instance;

    public static Singleton2 getInstance(){
        if (instance == null){
            instance = new Singleton2();
        }
        return instance;
    }
}
