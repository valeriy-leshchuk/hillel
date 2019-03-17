package hw.four;

import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        Random rand = new Random();
        int[][] arrayOne = new int[10][20];
        int[][] arrayTwo = new int[10][20];
        int[][] resultArray = new int[10][20];
        fillArrayAndPrint(arrayOne);
        fillArrayAndPrint(arrayTwo);
        multiplyArraysAndPrintResult(arrayOne, arrayTwo, resultArray);
    }

    private static void fillArrayAndPrint(int[][] arrayToBeFilled)
    {
        Random rand = new Random();
        for (int i = 0; i < arrayToBeFilled.length; i++)
        {
            for (int j = 0; j < arrayToBeFilled[i].length; j++)
            {
                arrayToBeFilled[i][j] = rand.nextInt(10);
                System.out.print(arrayToBeFilled[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void multiplyArraysAndPrintResult(int[][] arrayOne, int[][] arrayTwo, int[][] resultArray)
    {
        for (int i = 0; i < arrayOne.length; i++)
        {
            for (int j = 0; j < arrayOne[i].length; j++)
            {
                resultArray[i][j] = arrayOne[i][j] * arrayTwo[i][j];
                System.out.print(resultArray[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
