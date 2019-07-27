package com.usdj.pattern.template;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author gerrydeng
 * @date 2019-07-24 15:50
 * @Description:
 */
public class RefreshBeverageTest {

    @Test
    public void test(){
        System.out.println("制作咖啡");
        RefreshBeverage refreshBeverage1 = new Coffee();
        refreshBeverage1.prepareBeverageTemplate();
        System.out.println("done");
    }

    @Test
    public void test2(){
        System.out.println("冲茶");
        RefreshBeverage refreshBeverage2 = new Tea();
        refreshBeverage2.prepareBeverageTemplate();
        System.out.println("done");
    }

}