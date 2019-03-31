package hw.five.six.three;

import java.util.*;

public class Demo
{
    public static void main(String[] args)
    {
        List<Integer> list = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 100; i++)
        {
            list.add(rand.nextInt(100));
        }
        System.out.println(list);

        ListIterator it = list.listIterator();
        int oddNumbersCounter = 0;

        while (it.hasNext())
        {
            Integer elem = (Integer) it.next();
            if (elem % 2 != 0)
            {
                oddNumbersCounter++;
            }
            else
            {
                it.remove();
            }
        }
        System.out.println(list);
        System.out.println("List contain " + oddNumbersCounter + " numbers and all of them are odds.");
    }
}