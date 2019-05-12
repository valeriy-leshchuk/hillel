package classwork.apr25;

import hw.utils.Logger;

import java.io.*;
import java.util.Scanner;

public class StringDemo
{
    public static void main(String[] args) throws Exception
    {
        String a="a";
        String b="abcde";
        long initTime = System.currentTimeMillis();

        //for (long i = 0; i < 10000000L; i++)
        //{
        //    boolean c = b.matches("abcd.*");
            boolean c = b.endsWith("bcde");
        //}
        //long endTime = System.currentTimeMillis();

        //System.out.println(endTime-initTime);

        FileInputStream fis = new FileInputStream("/Users/valeriyl/Desktop/dir/file.txt");
        Scanner scanner = new Scanner(fis).useDelimiter(",");
        StringBuffer sb = new StringBuffer();
        while (scanner.hasNext())
        {
            sb.append(scanner.next());
        }

        System.out.println(sb.toString());


    }
}
