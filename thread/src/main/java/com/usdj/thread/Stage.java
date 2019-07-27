package com.usdj.thread;

/**
 * @author gerrydeng
 * @date 2019-07-26 13:41
 * @Description:
 */
public class Stage extends Thread {

    @Override
    public void run() {
        ArmyRunnable army1 = new ArmyRunnable();
        ArmyRunnable army2 = new ArmyRunnable();

        Thread hero1 = new Thread(army1, "hero1");
        Thread hero2 = new Thread(army2, "hero2");
        hero1.start();
        hero2.start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        army1.keepRunning = false;
        army2.keepRunning = false;
        try {
            hero2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Stage().start();
    }
}
