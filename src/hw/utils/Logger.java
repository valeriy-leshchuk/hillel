package hw.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Logger
{
    private static Date date_ = new Date();
    private static final String DEFAULT_DATE_TIME_FORMAT = "[dd-MMM-yyyy HH:mm:ss:sss a]";
    private static final SimpleDateFormat dateFormat_ = new SimpleDateFormat(DEFAULT_DATE_TIME_FORMAT);

    public static void info(String str)
    {
        System.out.println(currentTime() + " info: " + str);
    }

    public static void info(Boolean expr)
    {
        info(expr ? "true" : "false");
    }

    public static void warning(String str)
    {
        System.out.println(currentTime() + " info: " + str);
    }

    public static void warning(Boolean expr)
    {
        warning(expr ? "true" : "false");
    }

    public static void delimiter(int numOfRows)
    {
        if (numOfRows >=0)
        {
            for (int i = numOfRows; i > 0; i--)
            {
                System.out.println();
            }
        }
    }

    private static String currentTime()
    {
        return dateFormat_.format(date_);
    }
}
