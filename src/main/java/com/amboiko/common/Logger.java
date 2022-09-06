package com.amboiko.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    public static void info(final String message) {
        System.out.println(
                "[INFO: "
                        + (LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")))
                        + "]: "
                        + message
        );
    }
}
