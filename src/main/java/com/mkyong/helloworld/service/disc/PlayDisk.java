package com.mkyong.helloworld.service.disc;

import com.mkyong.helloworld.web.WelcomeController;
import com.processors.soundsystem.BlankDisc;
import com.processors.soundsystem.CompactDisc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author rumman
 * @since 5/26/21
 */
@Service
public class PlayDisk implements CompactDisc {

    private final Logger LOGGER = LoggerFactory.getLogger(PlayDisk.class);

    @Autowired
    private BlankDisc blankDisc;

    @Override
    public String playTrack(int trackNumber) {

        String track = blankDisc.getTracks().get(trackNumber);
        LOGGER.debug("Blank Disc - Track Playing:{} Track Number: {}", track, trackNumber) ;

        return track;
    }
}
