package hw.five.six.two;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test
{
    public static void main(String[] args)
    {
        //create lists
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();

        //generate numbers and fill lists
        Random rand = new Random();
        int count1 = rand.nextInt(10) + 10;
        int count2 = rand.nextInt(10) + 10;

        for (int i = 0; i < count1; i++)
        {
            list1.add(rand.nextInt(10));
        }
        for (int i = 0; i < count2; i++)
        {
            list2.add(rand.nextInt(10));
        }

        //multiply lists per element
        int length = list1.size() >= list2.size() ? list1.size() : list2.size();
        for (int index = 0; index < length; index++)
        {
            int elem1, elem2;
            try
            {
                elem1 = list1.get(index);
            }
            catch (IndexOutOfBoundsException ex)
            {
                elem1 = 1;
            }
            try
            {
                elem2 = list2.get(index);
            }
            catch (IndexOutOfBoundsException ex)
            {
                elem2 = 1;
            }
            resultList.add(elem1 * elem2);
        }

        //print lists
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(resultList);
    }
}