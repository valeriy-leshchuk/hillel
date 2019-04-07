package hw.six;

import java.lang.reflect.Array;
import java.util.*;

public class UniqueList implements List
{
    private Object[] data_;

    @Override
    public int size()
    {
        int counter = 0;
        for (Object element : data_)
        {
            if (element != null)
            {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public boolean isEmpty()
    {
        return (size() == 0);
    }

    @Override
    public boolean contains(Object o)
    {
        for (Object element : data_)
        {
            if (element == o)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator()
    {
        return null;
    }

    @Override
    public Object[] toArray()
    {
        return Arrays.copyOf(data_, data_.length);
    }

    @Override
    public Object[] toArray(Object[] a)
    {
        return toArray();
    }

    @Override
    public boolean add(Object o)
    {
        if (contains(o))
        {
            return false;
        }

        if (size() == data_.length)
        {
            Object[] temp = Arrays.copyOf(data_, size() * 2);
            data_ = temp;
        }
        for (Object element : data_)
        {
            if (element == null)
            {
                element = o;
            }
        }
        return true;
    }


    @Override
    public boolean remove(Object o)
    {
        boolean result=false;
        for(Object element : data_)
        {
            if(element==o)
            {
                element=null;
                result=true;
            }
        }
        return result;
    }

    @Override
    public boolean containsAll(Collection c)
    {
        Iterator it = c.iterator();
        while (it.hasNext())
        {
            boolean elemMatched=false;
            for(Object element : data_)
            {
                if (element==it.next())
                {
                    elemMatched=true;
                    break;
                }
            }
            if (elemMatched==false)
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection c)
    {
        //if (c.size()+size()<=data_.length)
        //{
        //    Object [] temp
        //    temp
        //}


        return false;
    }

    @Override
    public boolean addAll(int index, Collection c)
    {
        return false;
    }

    @Override
    public boolean removeAll(Collection c)
    {
        return false;
    }

    @Override
    public boolean retainAll(Collection c)
    {
        return false;
    }

    @Override
    public void clear()
    {

    }

    @Override
    public boolean equals(Object o)
    {
        return false;
    }

    @Override
    public int hashCode()
    {
        return 0;
    }

    @Override
    public Object get(int index)
    {
        return null;
    }

    @Override
    public Object set(int index, Object element)
    {
        return null;
    }

    @Override
    public void add(int index, Object element)
    {

    }

    @Override
    public Object remove(int index)
    {
        return null;
    }

    @Override
    public int indexOf(Object o)
    {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o)
    {
        return 0;
    }

    @Override
    public ListIterator listIterator()
    {
        return null;
    }

    @Override
    public ListIterator listIterator(int index)
    {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex)
    {
        return null;
    }
}
