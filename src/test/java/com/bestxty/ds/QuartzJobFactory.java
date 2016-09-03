package com.bestxty.ds;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author xty
 *         Created by xty on 2016/9/4.
 */
public class QuartzJobFactory implements Job {


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("QuartzJobFactory.execute");
    }
}
