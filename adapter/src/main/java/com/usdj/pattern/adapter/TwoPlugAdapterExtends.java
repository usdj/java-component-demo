package com.usdj.pattern.adapter;

/**
 * @author gerrydeng
 * @date 2019-07-24 15:27
 * @Description:
 */
public class TwoPlugAdapterExtends extends GBTwoPlug implements ThreePlugIf{
    @Override
    public void powerWithThree() {
        System.out.println("继承适配器");
        this.powerWithTwo();
    }
}
