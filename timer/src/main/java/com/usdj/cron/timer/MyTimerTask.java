package com.usdj.cron.timer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimerTask;

/**
 * @author gerrydeng
 * @date 2019-07-22 13:37
 * @Description:
 */
public class MyTimerTask extends TimerTask {

    private String name;

    MyTimerTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Current name is :" + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
