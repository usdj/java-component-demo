package com.usdj.pattern.template;

/**
 * @author gerrydeng
 * @date 2019-07-24 15:41
 * @Description:
 */
public abstract class RefreshBeverage {
    
    public final void prepareBeverageTemplate(){
        boilWater();
        brew();
        pourInCup();
        if (isCustomerWantsCondiments()){
            addCondiments();
        }

    }

    /**
     * Hook,钩子函数，提供一个模式或者空的实现
     * 具体子类可自行决定是否挂钩
     * @return
     */
    protected boolean isCustomerWantsCondiments() {
        return true;
    }

    protected abstract void brew();

    protected abstract void addCondiments();

    private void pourInCup(){
        System.out.println("讲饮料倒入杯中");
    }

   

    private void boilWater() {
        System.out.println("BoilWater");  
    }
}
