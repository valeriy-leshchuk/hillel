package hw.five.three;

import java.util.Random;

public class IntUtils
{
    private static Random randomizer_ = new Random();

    private IntUtils()
    {
    }

    public static int plus(int a, int b)
    {
        return a + b;
    }

    public static int minus(int a, int b)
    {
        return a - b;
    }

    public static int pow(int number, int pow)
    {
        return (int) Math.pow(number, pow);
    }

    public static int getRandomInt(int boundOne, int boundTwo)
    {
        if (boundOne < boundTwo)
        {
            return randomizer_.nextInt(boundTwo - boundOne) + boundOne;
        }
        else
        {
            return randomizer_.nextInt(boundOne - boundTwo) + boundTwo;
        }
    }
}