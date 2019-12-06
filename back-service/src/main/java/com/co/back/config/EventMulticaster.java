package com.co.back.config;

import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.util.ErrorHandler;

import java.util.concurrent.Executor;

/**
 * @auther skg
 * @Date: 2019/12/3 异步 事件通知
 */
@Component("applicationEventMulticaster")
public class EventMulticaster extends SimpleApplicationEventMulticaster {

    @Override
    protected Executor getTaskExecutor() {
        // 这里可以按实际需求进行线程池的配置
        SimpleAsyncTaskExecutor simpleAsyncTaskExecutor = new SimpleAsyncTaskExecutor();
        //simpleAsyncTaskExecutor.setConcurrencyLimit(100);//异步并发设置
        return simpleAsyncTaskExecutor;
    }

    /**
     * 这个方法主要配置错误处理，默认只会打一个警告级别的日志
     * @return
     */
    @Override
    protected ErrorHandler getErrorHandler() {
        return null;
    }


}
