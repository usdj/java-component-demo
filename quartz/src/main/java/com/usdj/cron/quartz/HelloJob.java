package com.usdj.cron.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author gerrydeng
 * @date 2019-07-22 14:32
 * @Description:
 */
public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        System.out.println("Current time: " + LocalDateTime.now().toString());
//        System.out.println(jobExecutionContext.getJobDetail().getKey().getGroup());
//        System.out.println(jobExecutionContext.getJobDetail().getKey().getName());
//        System.out.println(jobExecutionContext.getTrigger().getKey().getGroup());
//        System.out.println(jobExecutionContext.getTrigger().getKey().getName());
        System.out.println(jobExecutionContext.getJobDetail().getJobDataMap().get("message"));
        System.out.println(jobExecutionContext.getJobDetail().getJobDataMap().get("mathJobValue"));
        System.out.println(jobExecutionContext.getTrigger().getJobDataMap().get("message"));
    }


}
