package com.usdj.pattern.template;

/**
 * @author gerrydeng
 * @date 2019-07-24 15:52
 * @Description:
 */
public class Tea extends RefreshBeverage {

    @Override
    protected void brew() {
        System.out.println("沸水加茶");
    }

    @Override
    protected void addCondiments() {
        System.out.println("加奶");
    }

    @Override
    protected boolean isCustomerWantsCondiments() {
        return false;
    }
}
