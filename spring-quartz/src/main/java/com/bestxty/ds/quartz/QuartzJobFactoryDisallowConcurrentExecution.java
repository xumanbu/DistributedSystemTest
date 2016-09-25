package com.bestxty.ds.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author xty
 *         Created by xty on 2016/9/3.
 */
public class QuartzJobFactoryDisallowConcurrentExecution implements Job {


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("QuartzJobFactoryDisallowConcurrentExecution.execute");
    }
}
