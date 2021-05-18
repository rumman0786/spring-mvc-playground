package com.processors.concert;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author rumman
 * @since 5/16/21
 */
@Component
@Aspect
public class Audience {

    private final Logger logger = LoggerFactory.getLogger(Audience.class);
//
//    @Pointcut()
//    public void performPointCut(){
//    }

    @Before("execution(* Performance.perform(..))")
    public void silencePhone() {
        logger.debug("Silencing phone of audience.");
    }

//    public void takeSeats() {
//
//    }
//
//    public void clap() {
//
//    }
//
//    public void demandRefund() {
//
//    }
}
