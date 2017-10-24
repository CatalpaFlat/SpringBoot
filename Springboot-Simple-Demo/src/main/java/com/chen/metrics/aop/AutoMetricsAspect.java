package com.chen.metrics.aop;

import com.codahale.metrics.Counter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import com.codahale.metrics.annotation.Counted;
import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static com.codahale.metrics.MetricRegistry.name;

/**
 * @author 陈梓平
 * @date 2017/10/16.
 */
@Component
@Aspect
public class AutoMetricsAspect {
    //表
    protected ConcurrentMap<String,Meter> meters = new ConcurrentHashMap<>();
    //异常表
    protected ConcurrentMap<String,Meter> exceptionsMeters = new ConcurrentHashMap<>();
    //定时器
    protected ConcurrentMap<String,Timer> timers = new ConcurrentHashMap<>();
    //计时器
    protected ConcurrentMap<String,Counter> counters = new ConcurrentHashMap<>();


    @Autowired
    MetricRegistry metricRegistry;

    @Pointcut(value = "execution(public * *(..))")
    public void publicMethods(){

    }

    @Before("publicMethods() && @annotation(counted)")
    public void instrumentCounted(JoinPoint joinPoint, Counted counted){
        String name = name(joinPoint.getTarget().getClass(), StringUtils.hasLength(counted.name()) ?
                counted.name() : joinPoint.getSignature().getName(), "counter");
        Counter counter = counters.computeIfAbsent(name, key -> metricRegistry.counter(key));
        counter.inc();
    }

    @Before("publicMethods() && @annotation(metered)")
    public void instrumentMetered(JoinPoint joinPoint, Metered metered){

        String name = name(joinPoint.getTarget().getClass(),StringUtils.hasLength(metered.name()) ?
                metered.name() : joinPoint.getSignature().getName(), "meter");
        Meter meter = meters.computeIfAbsent(name, key -> metricRegistry.meter(key));
        meter.mark();
    }

    @AfterThrowing(pointcut = "publicMethods() && @annotation(exceptionMetered)",throwing = "throwable")
    public void instrumentExceptionMetered(JoinPoint joinPoint, Throwable throwable,
                                           ExceptionMetered exceptionMetered){
        String name = name(joinPoint.getTarget().getClass(),StringUtils.hasLength(exceptionMetered.name()) ?
                exceptionMetered.name() : joinPoint.getSignature().getName(), "meter","exception");
        Meter meter = exceptionsMeters.computeIfAbsent(name, meterName -> metricRegistry.meter(meterName));
        meter.mark();
    }

    @Around("publicMethods() && @annotation(timed)")
    public Object instrumentTimeed(ProceedingJoinPoint proceedingJoinPoint, Timed timed) throws Throwable {
        String name = name(proceedingJoinPoint.getTarget().getClass(),StringUtils.hasLength(timed.name()) ?
                timed.name() : proceedingJoinPoint.getSignature().getName(), "timer");
        Timer timer = timers.computeIfAbsent(name, inputName -> metricRegistry.timer(inputName));
        Timer.Context tc = timer.time();
        try {
            return proceedingJoinPoint.proceed();
        }finally {
            tc.stop();
        }
    }


}
