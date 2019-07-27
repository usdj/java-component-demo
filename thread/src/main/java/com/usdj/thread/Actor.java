package com.usdj.thread;

/**
 * @author gerrydeng
 * @date 2019-07-26 13:11
 * @Description:
 */
public class Actor extends Thread {

    @Override
    public void run() {
        int count = 0;
        System.out.println(getName() + " is a actor");
        do {
            System.out.println(getName() + " acting " + (++count));
            if (count%10==0){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } while (count != 100);

        System.out.println(getName() + " end");
    }

    public static void main(String[] args) {
        Thread actor = new Actor();
        actor.setName("Tom");
        actor.start();

        Thread actressThread = new Thread(new Actress(),"Alice");
        actressThread.start();
    }
}


