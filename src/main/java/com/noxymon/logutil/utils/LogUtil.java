package com.noxymon.logutil.utils;

import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.*;

import java.util.Collections;

public final class LogUtil {
    private final Logging logging = LoggingOptions.getDefaultInstance().getService();
    private static String logName;

    public static LogUtil withLogName(String nameOfLog) {
        logName = nameOfLog;
        return new LogUtil();
    }

    public void error(String message){
        LogEntry logEntry = LogEntry.newBuilder(Payload.StringPayload.of(message))
                .setSeverity(Severity.ERROR)
                .setLogName(logName)
                .setResource(MonitoredResource.newBuilder("global").build())
                .build();
        logging.write(Collections.singleton(logEntry));
    }

    public void info(String message){
        LogEntry logEntry = LogEntry.newBuilder(Payload.StringPayload.of(message))
                .setSeverity(Severity.ERROR)
                .setLogName(logName)
                .setResource(MonitoredResource.newBuilder("global").build())
                .build();
        logging.write(Collections.singleton(logEntry));
    }

    public void debug(String message){
        LogEntry logEntry = LogEntry.newBuilder(Payload.StringPayload.of(message))
                .setSeverity(Severity.DEBUG)
                .setLogName(logName)
                .setResource(MonitoredResource.newBuilder("global").build())
                .build();
        logging.write(Collections.singleton(logEntry));
    }

    public void warning(String message){
        LogEntry logEntry = LogEntry.newBuilder(Payload.StringPayload.of(message))
                .setSeverity(Severity.WARNING)
                .setLogName(logName)
                .setResource(MonitoredResource.newBuilder("global").build())
                .build();
        logging.write(Collections.singleton(logEntry));
    }
}
