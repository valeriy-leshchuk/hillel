package hw.ten;

import java.util.List;

public class ArrayAndListUtils
{

    public static <T> T[] swapElements(T[] array, int m, int n)
    {
        if (m < 0 || n < 0 || m > array.length || n > array.length)
        {
            return array;
        }
        T temp = array[m];
        array[m] = array[n];
        array[n] = temp;
        return array;
    }

    public static <T extends Comparable<T>> T findMaxElementInListWithinRange(List<T> list, int m, int n)
    {
        if (m < 0 || n < 0 || m > list.size() || n > list.size() || m > n)
        {
            return null;
        }

        T maxElement = list.get(m);
        for (int i = m + 1; i <= n; i++)
        {
            if (list.get(i).compareTo(maxElement) > 0)
            {
                maxElement = list.get(i);
            }
        }
        return maxElement;
    }
}