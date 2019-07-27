package com.usdj.pattern.template;

/**
 * @author gerrydeng
 * @date 2019-07-24 15:47
 * @Description:
 */
public class Coffee extends RefreshBeverage {

    @Override
    protected void brew() {
        System.out.println("沸水冲咖啡");
    }

    @Override
    protected void addCondiments() {
        System.out.println("加牛奶和糖");
    }
}
