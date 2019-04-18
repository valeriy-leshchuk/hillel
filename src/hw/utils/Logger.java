package hw.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Logger
{
    private static Date date_ = new Date();
    private static final String DEFAULT_DATE_TIME_FORMAT = "[dd-MMM-yyyy HH:mm:ss a]";
    private static final SimpleDateFormat dateFormat_ = new SimpleDateFormat(DEFAULT_DATE_TIME_FORMAT);

    public static void info(String str)
    {
        System.out.println(currentTime() + " info: " + str);
    }

    public static void warning(String str)
    {
        System.out.println(currentTime() + " info: " + str);
    }

    private static String currentTime()
    {
        return dateFormat_.format(date_);
    }
}
