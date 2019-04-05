package hw.nine;

import hw.five.three.IntUtils;

import java.util.Iterator;
import java.util.Map;

public class Utils
{
    private static int CAP_CHAR_BEGIN = 65;
    private static int CAP_CHAR_END = 90;

    public static void printMapViaEntrySet(Map map)
    {
        System.out.println(map.entrySet());
    }

    public static void printMapViaKeySet(Map map)
    {
        if (map.isEmpty())
        {
            System.out.println("Map is empty.");
        }
        else
        {
            Iterator it = map.keySet().iterator();
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            while (it.hasNext())
            {
                Object item = it.next();
                sb.append(item.toString()).
                    append("=").
                    append(map.get(item).toString()).
                    append(it.hasNext() ? ", " : "]");
            }
            System.out.println(sb.toString());
        }
    }

    public static void printMapViaEntrySetAndKeySet(Map map)
    {
        printMapViaEntrySet(map);
        printMapViaKeySet(map);
    }

    public static int getRandomIntWithinBounds(int min, int max)
    {
        return IntUtils.getRandomInt(min, max);
    }

    public static int getRandomIntWithinBoundsOfCapitalsInAscii()
    {
        return getRandomIntWithinBounds(CAP_CHAR_BEGIN, CAP_CHAR_END);
    }

    public static String getRandomCapitalizedCharAsString()
    {
        return Character.toString((char) getRandomIntWithinBoundsOfCapitalsInAscii());
    }

}