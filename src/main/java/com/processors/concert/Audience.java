package com.processors.concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
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

    @Pointcut("execution(* Performance.perform(..)) && bean(theChosenOne)")
    public void performChosenPointCut() {
    }

    public void silencePhone() {
        logger.debug("Silencing phone of audience.");
    }

    public void takeSeats() {
        logger.debug("Taking Seats Before Performance.");
    }

    public void keepStanding() {
        logger.debug("Every one stands before, during and after the chosen one performs.");
    }

    public void clap() {
        logger.debug("Clapping after successful performance.");
    }

    public void demandRefund() {
        logger.debug("Demanding Refund for bad performance.");
    }

    @Around("performPointCut()")
    public void doAllInSingleAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        silencePhone();
        takeSeats();

        try {
            proceedingJoinPoint.proceed();
            clap();
        } catch (Throwable throwable) {
            demandRefund();
        }
    }

    @Around("performChosenPointCut()")
    public void chosenPerformance(ProceedingJoinPoint proceedingJoinPoint) {
        silencePhone();
        keepStanding();

        try {
            proceedingJoinPoint.proceed();
            clap();
        } catch (Throwable throwable) {
            demandRefund();
        }

        clap();
        keepStanding();
    }
}
