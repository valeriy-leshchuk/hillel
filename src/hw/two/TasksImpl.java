package hw.two;

import java.util.Arrays;
import java.util.Random;

class TasksImpl
{
    static void generateArrayWithMinMax ()
    {
        Random rand = new Random();
        int[] arr = new int[100];

        int minBound = 100;
        int maxBound = 10000;
        int minValue = 0, maxValue = 0;

        for(int i=0; i<arr.length; i++)
        {
            arr[i] = rand.nextInt(maxBound - minBound) + minBound;
            if (i==0)
            {
                minValue = maxValue = arr[i];
            }
            else
            {
                if (arr[i] > maxValue)
                {
                    maxValue = arr[i];
                }
                if (arr[i] < minValue)
                {
                    minValue = arr[i];
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("MinValue = "+minValue +"; MaxValue = "+maxValue + "\n\n\n");
    }

    static int calcFactorial(int number)
    {
        if (number == 0)
        {
            return 1;
        }
        else
        {
            return(number * calcFactorial(number-1));
        }
    }

    static void generateAndPrintReactangles ()
    {
        Random rand = new Random();
        int minBound = 10;
        int maxBound = 20;
        int width, height;
        width = rand.nextInt(maxBound-minBound)+minBound;
        height = rand.nextInt(maxBound-minBound)+minBound;
        System.out.println("Printing " + width+"x"+height + " rectangle.");
        for (int i = 0; i<height; i++)
        {
            for (int j = 0; j<width;j++)
            {
                System.out.print("#");
            }
            System.out.print("\n");
        }

        System.out.println("\nPrinting empty " + width+"x"+height + " rectangle.");
        for (int i = 0; i<height; i++)
        {
            for (int j = 0; j<width;j++)
            {
                if (j==0 || j==width-1 || i==0 || i==height-1)
                {
                    System.out.print("#");
                }
                else
                {
                    System.out.print("-");
                }
            }
            System.out.print("\n");
        }
        System.out.println("\n\n\n");
    }

    static void generateNumberAndCalcFactorial()
    {
        Random rand = new Random();
        int minBound = 1;
        int maxBound = 10;
        final int factInt = rand.nextInt(maxBound-minBound)+minBound;
        System.out.println("Calculating factorial for: " + factInt);


        int resultViaFor = 1;
        for (int i = 1; i <= factInt; i++)
        {
            resultViaFor = resultViaFor * i;
        }
        System.out.println("Fact via for = " + resultViaFor);


        int resultViaWhile = 1;
        int i = 1;
        while (i<=factInt)
        {
            resultViaWhile = resultViaWhile*i;
            i++;
        }
        System.out.println("Fact via while = " + resultViaWhile);


        int resultViaDoWhile = 1;
        i = 1;
        do
        {
            resultViaDoWhile = resultViaDoWhile * i;
            i++;
        }
        while (i<=factInt);
        System.out.println("Fact via doWhile = " + resultViaDoWhile);

        System.out.println("Result via recursion = " + calcFactorial(factInt));
        System.out.println("\n\n\n");
    }
}
