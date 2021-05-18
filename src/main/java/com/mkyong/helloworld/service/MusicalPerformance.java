package com.mkyong.helloworld.service;

import com.processors.concert.Performance;
import org.springframework.stereotype.Service;

/**
 * @author rumman
 * @since 5/16/21
 */
@Service
public class MusicalPerformance implements Performance {

    @Override
    public void perform() {
        System.out.println("Singing a beautiful song.");
//        throw new RuntimeException();
    }
}
