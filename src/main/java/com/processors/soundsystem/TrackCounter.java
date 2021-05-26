package com.processors.soundsystem;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author rumman
 * @since 5/26/21
 */
@Component
@Aspect
public class TrackCounter {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrackCounter.class);

    private Map<Integer, Integer> trackCounts = new HashMap<>();

    @Pointcut(
            "execution(* CompactDisc.playTrack(int)) && args(trackNumber)"
    )
    public void trackPlayed(int trackNumber) {}

    @After("trackPlayed(trackNumber)")
    public void countTrack(int trackNumber) {
        int newCount = getTrackCount(trackNumber) + 1;
        trackCounts.put(trackNumber, newCount);

        LOGGER.debug("Track Number {} played: {} Times.", trackNumber, newCount);
    }

    private int getTrackCount(int trackNumber) {
        return trackCounts.getOrDefault(trackNumber, 0);
    }
}
