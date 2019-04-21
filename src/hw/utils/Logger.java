package hw.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class Logger
{
    private static final String DEFAULT_DATE_TIME_FORMAT = "[dd-MMM-yyyy HH:mm:ss:sss Z]";
    private static final SimpleDateFormat dateFormat_ = new SimpleDateFormat(DEFAULT_DATE_TIME_FORMAT);

    private static Logger instance_ = new Logger();

    private Logger()
    {}

    public static Logger getLogger()
    {
        return instance_;
    }

    public Logger info(String str)
    {
        System.out.println(currentTime() + " info: " + str);
        return instance_;
    }

    public Logger info(Boolean expr)
    {
        return info(expr ? "true" : "false");
    }

    public Logger warning(String str)
    {
        System.out.println(currentTime() + " !!! warning: " + str);
        return instance_;
    }

    public Logger warning(Boolean expr)
    {
        return warning(expr ? "true" : "false");
    }

    public Logger error(String str)
    {
        System.err.println(currentTime() + " * error: " + str);
        return instance_;
    }

    public Logger error(Boolean expr)
    {
        return error(expr ? "true" : "false");
    }

    public Logger exception(Exception ex)
    {
        System.err.println(currentTime() + " ***** EXCEPTION: ");
        ex.printStackTrace();
        System.err.println(getDelimiter());
        return instance_;
    }

    public Logger delimiter()
    {
        return delimiter(1);
    }

    public Logger delimiter(int numOfRows)
    {
        System.out.println(new String(new char[numOfRows - 1]).replace("\0", "\n"));
        return instance_;
    }

    private String getDelimiter()
    {
        return getDelimiter(1);
    }

    private String getDelimiter(int numOfRows)
    {
        return new String(new char[numOfRows - 1]).replace("\0", "\n");
    }

    private static String currentTime()
    {
        return dateFormat_.format(new Date());
    }
}
