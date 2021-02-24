package fr.endwiz.bot.sample.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EndwizLogger {

    public static String name;
    private static String color_prefix = EndwizLogger.ANSI_CYAN;
    private static String version = "1.0.3";

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public EndwizLogger(String name) {
        EndwizLogger.name = name;
    }

    public EndwizLogger(String name, String color_prefix) {
        EndwizLogger.name = name;
        EndwizLogger.color_prefix = color_prefix;
    }

    public void log(String log) {
        System.out.println(color_prefix + "[" + genTime() + "][" + name + "] " + ANSI_RESET + log);
    }

    public void warn(String log) {
        System.err.println("[" + genTime() + "][" + name + "] " + ANSI_RESET + log);
    }

    public static String getInfo(String info) {
        if (info.equalsIgnoreCase("name")) {
            return name;
        } else if (info.equalsIgnoreCase("version")) {
            return version;
        } else if (info.equalsIgnoreCase("pattern")) {
            return "[dd/MM/YYYY HH:mm:ss][Logger Name] log";
        } else {
            return "error";
        }
    }

    public static String genTime() {
        String pattern = "dd/MM/YYYY HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date(System.currentTimeMillis()));
        return date;
    }
}
