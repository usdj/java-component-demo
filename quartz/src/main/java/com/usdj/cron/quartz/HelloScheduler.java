package com.usdj.cron.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.time.LocalDateTime;

/**
 * @author gerrydeng
 * @date 2019-07-22 14:38
 * @Description:
 */
public class HelloScheduler {
    public static void main(String[] args) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("myJob", "group1")
                .usingJobData("message","hello").usingJobData("mathJobValue",3.14).build();
//        SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1")
//                .startNow()
//                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2)
//                        .repeatForever()).usingJobData("message","hello myTrigger")
//                        .usingJobData("DoubleTriggerValue",2.0D).build();
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("myCron", "group1")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ? *")).build();
        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = stdSchedulerFactory.getScheduler();
        scheduler.start();
        System.out.println("Scheduler:" + LocalDateTime.now());
        scheduler.scheduleJob(jobDetail, trigger);

    }
}