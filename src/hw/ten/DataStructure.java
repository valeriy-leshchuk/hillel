package hw.ten;

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
        private int currentPos = 0;
        private int posOfNext = 0;
        private boolean endReached = false;

        @Override
        public boolean hasNext()
        {
            if (!endReached)
            {
                for (int i = currentPos + 1; i < SIZE - 1; i++)
                {
                    if (arrayOfInts[i] % 2 == 0)
                    {
                        posOfNext = i;
                        return true;
                    }
                }
                endReached = true;
            }
            return false;
        }

        @Override
        public Integer next()
        {
            if (hasNext())
            {
                currentPos = posOfNext;
                return arrayOfInts[posOfNext];
            }
            return null;
        }
    }
}