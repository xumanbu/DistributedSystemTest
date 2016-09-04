package com.bestxty.ds;

import com.bestxty.ds.bean.ScheduleJob;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.*;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * @author xty
 *         Created by xty on 2016/9/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-config.xml", "classpath:spring-quartz.xml"})
public class QuartzTest extends AbstractJUnit4SpringContextTests {


    private SchedulerFactoryBean schedulerFactoryBean;


    @Before
    public void prepareSchedulerFactory() {
        schedulerFactoryBean = applicationContext.getBean(SchedulerFactoryBean.class);
    }


    @Test
    public void testQuartzTask() throws SchedulerException, IOException {

        System.out.println(schedulerFactoryBean == null);

//        ScheduleJob job = new ScheduleJob();
//        job.setJobName("testName");
//        job.setJobGroup("testGroup");
//        job.setCronExpression("0/5 * * ? * *");
//
//        job.setJobStatus(ScheduleJob.STATUS_NOT_RUNNING);
//        addJob(job);


        System.in.read();

    }


    public void addJob(ScheduleJob job) throws SchedulerException {
        if (job == null || ScheduleJob.STATUS_RUNNING.equals(job.getJobStatus())) {
            return;
        }

        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(), job.getJobGroup());

        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

        // 不存在，创建一个
        if (null == trigger) {
            Class<? extends Job> clazz = ScheduleJob.CONCURRENT_IS.equals(job.getIsConcurrent()) ? QuartzJobFactory.class : QuartzJobFactoryDisallowConcurrentExecution.class;

            JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(job.getJobName(), job.getJobGroup()).build();

            jobDetail.getJobDataMap().put("scheduleJob", job);

            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());

            trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName(), job.getJobGroup()).withSchedule(scheduleBuilder).build();

            scheduler.scheduleJob(jobDetail, trigger);
        } else {
            // Trigger已存在，那么更新相应的定时设置
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());

            // 按新的cronExpression表达式重新构建trigger
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();

            // 按新的trigger重新设置job执行
            scheduler.rescheduleJob(triggerKey, trigger);
        }
    }

}
