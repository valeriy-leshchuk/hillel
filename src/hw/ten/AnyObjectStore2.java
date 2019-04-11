package hw.ten;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AnyObjectStore2
{
    private static Set<Integer> intStore_ = new HashSet<>();
    private static Set<String> stringStore_ = new HashSet<>();

    private AnyObjectStore2()
    {
    }

    public static <T> void addElement(T elementToAdd)
    {
        if (elementToAdd instanceof Integer)
        {
            intStore_.add((Integer) elementToAdd);
        }
        else if (elementToAdd instanceof String)
        {
            stringStore_.add((String) elementToAdd);
        }
    }

    public static <T> T removeElement(T elementToRemove)
    {
        if (elementToRemove instanceof Integer)
        {
            Iterator<Integer> it = intStore_.iterator();
            Integer foundElem = null;
            while (it.hasNext())
            {
                Integer next = it.next();
                if (next.equals(elementToRemove))
                {
                    foundElem = next;
                    break;
                }
            }
            intStore_.remove(foundElem);
            return (T) foundElem;
        }
        else if (elementToRemove instanceof String)
        {
            Iterator<String> it = stringStore_.iterator();
            String foundElem = null;
            while (it.hasNext())
            {
                String next = it.next();
                if (next.equals(elementToRemove))
                {
                    foundElem = next;
                    break;
                }
            }
            intStore_.remove(foundElem);
            return (T) foundElem;
        }
        else
        {
            return null;
        }
    }

    public static <T> boolean contains(T element)
    {
        if (element instanceof Integer)
        {
            return intStore_.contains(element);
        }
        else if (element instanceof String)
        {
            return stringStore_.contains(element);
        }
        else
        {
            return false;
        }
    }

    public static <T> Set<T> getStore(Class T)
    {
        if (T.equals(Integer.class))
        {
            return (Set<T>) intStore_;
        }
        else if (T.equals(String.class))
        {
            return (Set<T>) stringStore_;
        }
        else
        {
            return null;
        }
    }
}