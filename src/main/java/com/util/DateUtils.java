package com.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author rumman
 * @since 5/13/21
 */
public class DateUtils {

    public static final String DATE_TIME = "yyyy/MM/dd HH:mm:ss";

    public static String getCurrentTimeStamp() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_TIME);

        return dtf.format(LocalDateTime.now());
    }
}
