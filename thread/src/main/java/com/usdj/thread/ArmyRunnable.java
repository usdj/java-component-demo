package com.usdj.thread;

/**
 * @author gerrydeng
 * @date 2019-07-26 13:38
 * @Description:
 */
public class ArmyRunnable implements Runnable {


    volatile boolean keepRunning = true;

    @Override
    public void run() {
        while (keepRunning) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " fire[" + i + "]");
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread().getName() + "end!");
    }
}
