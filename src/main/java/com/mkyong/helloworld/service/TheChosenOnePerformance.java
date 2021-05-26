package com.mkyong.helloworld.service;

import com.processors.concert.Performance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author rumman
 * @since 5/26/21
 */
@Service("theChosenOne")
public class TheChosenOnePerformance implements Performance {

    private static final Logger LOGGER = LoggerFactory.getLogger(TheChosenOnePerformance.class);

    @Override
    public void perform() {
        LOGGER.debug("This is special performance by the chosen one!!!");
    }
}
