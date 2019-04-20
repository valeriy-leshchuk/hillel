package hw.ten;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class DataStructure implements Iterable<Integer>
{

    private final static int SIZE = 15;
    private int[] arrayOfInts = new int[SIZE];

    public DataStructure()
    {
        for (int i = 0; i < SIZE; i++)
        {
            arrayOfInts[i] = i;
        }
    }

    @Override
    public Iterator<Integer> iterator()
    {
        return new EvenIterator();
    }

    interface DataStructureIterator extends java.util.Iterator<Integer>
    {
    }

    class EvenIterator implements DataStructureIterator
    {
        private int currentPos_ = 0;
        private int posOfNext_ = 0;
        private boolean endReached_ = false;
        private int[] initArrayOfInts_ = arrayOfInts;

        @Override
        public boolean hasNext()
        {
            if (initArrayOfInts_ != arrayOfInts)
            {
                throw new ConcurrentModificationException("Content was changed.");
            }
            if (!endReached_)
            {
                for (int i = currentPos_ + 1; i < SIZE; i++)
                {
                    if (arrayOfInts[i] % 2 == 0)
                    {
                        posOfNext_ = i;
                        return true;
                    }
                }
                endReached_ = true;
            }
            return false;
        }

        @Override
        public Integer next()
        {
            if (hasNext())
            {
                currentPos_ = posOfNext_;
                return arrayOfInts[posOfNext_];
            }
            return null;
        }

        @Override
        public void remove()
        {
            throw new ConcurrentModificationException();
        }
    }
}