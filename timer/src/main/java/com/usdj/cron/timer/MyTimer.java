package com.usdj.cron.timer;

import java.util.Timer;

/**
 * @author gerrydeng
 * @date 2019-07-22 13:39
 * @Description:
 */
public class MyTimer {
    public static void main(String[] args) {
        // 1创建timer实例
        Timer timer = new Timer();
        // 2创建一个MyTimerTask实例
        MyTimerTask myTimerTask = new MyTimerTask("Hello!");
        // 3通过timer定时定频率调用myTimer业务逻辑
        timer.schedule(myTimerTask, 2000L, 1000L);

    }
}


