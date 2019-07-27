package com.usdj.thread;

/**
 * @author gerrydeng
 * @date 2019-07-26 13:34
 * @Description:
 */
public class Actress implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "is a actor");
        int count = 0;
        do {
            System.out.println(Thread.currentThread().getName() + " acting " + (++count));
            if (count%10==0){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } while (count != 100);

        System.out.println(Thread.currentThread().getName() + " end");

    }
}
