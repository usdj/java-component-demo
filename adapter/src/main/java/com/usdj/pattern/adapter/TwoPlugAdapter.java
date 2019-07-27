package com.usdj.pattern.adapter;

/**
 * @author gerrydeng
 * @date 2019-07-24 15:16
 * @Description:
 */
public class TwoPlugAdapter implements ThreePlugIf {

    private GBTwoPlug twoPlug;

    public TwoPlugAdapter(GBTwoPlug twoPlug) {
        this.twoPlug = twoPlug;
    }


    @Override
    public void powerWithThree() {

        System.out.println("通过转化");
        twoPlug.powerWithTwo();
    }
}
