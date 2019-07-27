package com.usdj.singleton;

/**
 * @author gerrydeng
 * @date 2019-07-24 13:23
 * @Description: 饿汉模式，在类加载就创建
 */
class Singleton {

    // 1.讲构造方法私有化，不允许外部直接创建对象
    private Singleton() {
    }

    // 2.创建类的唯一实例
    private static Singleton instance = new Singleton();

    // 3.提供一个用于获取实例的方法
    public static Singleton getInstance(){
        return instance;
    }
}
