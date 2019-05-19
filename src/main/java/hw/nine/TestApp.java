package hw.nine;

import java.util.*;

public class TestApp
{
    public static void main(String[] args)
    {
        taskOne();
        taskTwo();
        taskThree();
        taskFour();
    }

    private static void taskOne()
    {
        System.out.println("Task one:");
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < 10; i++)
        {
            map.put(Integer.toString(i), Integer.toString(i * 10));
        }
        Utils.printMapViaEntrySetAndKeySet(map);
    }

    private static void taskTwo()
    {
        System.out.println("Task two:");
        Map<Test, Test> map = new HashMap<>();
        Random rand = new Random();

        int numberOfObject = rand.nextInt(20);
        for (int i = numberOfObject; i > 0; i--)
        {
            map.put(new Test(Utils.getRandomIntWithinBoundsOfCapitalsInAscii(), Utils.getRandomCapitalizedCharAsString()),
                new Test(Utils.getRandomIntWithinBoundsOfCapitalsInAscii(), Utils.getRandomCapitalizedCharAsString()));
        }
        Utils.printMapViaEntrySetAndKeySet(map);
    }

    private static void taskThree()
    {
        System.out.println("Task three:");
        Map<String, String> map = new LinkedHashMap<>();

        for (int i = 0; i < 10; i++)
        {
            map.put(Utils.getRandomCapitalizedCharAsString(), Utils.getRandomCapitalizedCharAsString());
        }
        Utils.printMapViaEntrySetAndKeySet(map);
    }

    private static void taskFour()
    {
        System.out.println("Task four:");
        Map<TestTwo, TestTwo> map = new TreeMap<>();
        for (int i = 0; i < 10; i++)
        {
            map.put(new TestTwo(Utils.getRandomIntWithinBoundsOfCapitalsInAscii(), Utils.getRandomCapitalizedCharAsString()),
                new TestTwo(Utils.getRandomIntWithinBoundsOfCapitalsInAscii(), Utils.getRandomCapitalizedCharAsString()));

        }
        Utils.printMapViaEntrySetAndKeySet(map);
    }
}