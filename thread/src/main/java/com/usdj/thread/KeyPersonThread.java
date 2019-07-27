package com.usdj.thread;

/**
 * @author gerrydeng
 * @date 2019-07-26 13:50
 * @Description:
 */
public class KeyPersonThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "begin fire!");
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " fire on....");
        }
        System.out.println(Thread.currentThread().getName() + "end!");
    }
}
