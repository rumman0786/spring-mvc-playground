package com.processors.concert;

import org.aspectj.lang.annotation.*;
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

    @Pointcut("execution(* Performance.perform(..))")
    public void performPointCut() {
    }

    @Before("performPointCut()")
    public void silencePhone() {
        logger.debug("Silencing phone of audience.");
    }

    @Before("performPointCut()")
    public void takeSeats() {
        logger.debug("Taking Seats Before Performance.");
    }

    @AfterReturning("performPointCut()")
    public void clap() {
        logger.debug("Clapping after successful performance.");
    }

    @AfterThrowing("performPointCut()")
    public void demandRefund() {
        logger.debug("Demanding Refund for bad performance.");
    }
}
