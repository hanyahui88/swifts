package com.swifts.frame.common.utils;


import org.slf4j.Logger;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

/**
 * 日志帮助类  所有的参数替换都是  {}
 * Created by yahui on 2016/1/13.
 */
public class LoggerUtils {

    public static void info(Logger logger, String message, Object... objects) {
        logger.info(message, objects);
    }

    public static void info(Logger logger, String message, Throwable throwable, Object... objects) {
        logger.info(message, objects, throwable);
    }

    public static void debug(Logger logger, String message, Object... objects) {
        logger.debug(message, objects);
    }

    public static void debug(Logger logger, String message, Throwable throwable, Object... objects) {
        FormattingTuple ft = MessageFormatter.format(message, objects);
        logger.debug(ft.getMessage(), throwable);
    }

    public static void trace(Logger logger, String message, Object... objects) {
        logger.trace(message, objects);
    }

    public static void trace(Logger logger, String message, Throwable throwable, Object... objects) {
        logger.trace(message, objects, throwable);
    }

    public static void error(Logger logger, String message, Object... objects) {
        logger.error(message, objects);
    }

    public static void error(Logger logger, String message, Throwable throwable, Object... objects) {
        logger.error(message, objects, throwable);
    }


    public static void warn(Logger logger, String message, Object... objects) {
        logger.warn(message, objects);
    }

    public static void warn(Logger logger, String message, Throwable throwable, Object... objects) {
        logger.warn(message, objects, throwable);
    }
}
