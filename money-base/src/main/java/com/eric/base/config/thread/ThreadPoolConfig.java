package com.eric.base.config.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Eric
 * @since 2020/9/24 9:13 上午
 */
@Slf4j
@Configuration
@EnableAsync
@EnableScheduling
public class ThreadPoolConfig {

    /**
     * 线程池
     *
     * @return ThreadPoolTaskExecutor
     */
    @Bean("myExecutor")
    public ThreadPoolTaskExecutor myExecutor() {
        log.info("===== 加载myExecutor线程池 =====");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        int corePoolSize = Runtime.getRuntime().availableProcessors();
        executor.setCorePoolSize(corePoolSize * 2);
        executor.setMaxPoolSize(corePoolSize * 4);
        executor.setQueueCapacity(corePoolSize * 6);
        executor.setKeepAliveSeconds(60);
        executor.setThreadNamePrefix("task-executor-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.initialize();
        return executor;
    }

    /**
     * 定时线程池
     *
     * @return ThreadPoolTaskScheduler
     */
    @Bean("myScheduler")
    public ThreadPoolTaskScheduler myScheduler() {
        log.info("===== 加载myScheduler线程池 =====");
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        int corePoolSize = Runtime.getRuntime().availableProcessors();
        scheduler.setPoolSize(corePoolSize * 2);
        scheduler.setThreadNamePrefix("scheduler-executor-");
        scheduler.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //调度器shutdown被调用时等待当前被调度的任务完成
        scheduler.setWaitForTasksToCompleteOnShutdown(true);
        //等待时长
        scheduler.setAwaitTerminationSeconds(60);
        scheduler.initialize();
        return scheduler;
    }
}
