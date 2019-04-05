package hw.six.one;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.UnaryOperator;

public class UniqueList extends ArrayList
{

    @Override
    public Object set(int index, Object element)
    {
        if (isElementAlreadyPresented(element))
        {
            return null;
        }
        return super.set(index, element);

    }

    @Override
    public boolean add(Object o)
    {
        if (isElementAlreadyPresented(o))
        {
            return false;
        }
        return super.add(o);

    }

    @Override
    public void add(int index, Object element)
    {
        if (isElementAlreadyPresented(element))
        {
            return;
        }
        super.add(index, element);
    }

    @Override
    public boolean addAll(Collection c)
    {
        if (isAnyElementFromCollectionAlreadyPresented(c))
        {
            return false;
        }
        return super.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection c)
    {
        if (isAnyElementFromCollectionAlreadyPresented(c))
        {
            return false;
        }
        return super.addAll(index, c);
    }

    @Override
    public void replaceAll(UnaryOperator operator)
    {
        ArrayList temp = new ArrayList();
        for (Object currentElement : this)
        {
            temp.add(currentElement == null ? null : operator.apply(currentElement));
        }
        super.replaceAll(operator);
    }

    private boolean isElementAlreadyPresented(Object element)
    {
        for (Object elem : this)
        {
            if ((elem == null && element == null) || (elem != null && element != null && element.equals(elem)))
            {
                return true;
            }
        }
        return false;
    }

    private boolean isAnyElementFromCollectionAlreadyPresented(Collection c)
    {
        for (Object elemToAdd : c)
        {
            if (isElementAlreadyPresented(elemToAdd))
            {
                return true;
            }
        }
        return false;
    }

    private boolean isCollectionConsistOfUniqueElementsOnly(Collection c)
    {
        int nullCounter = 0;
        for (Object elem : c)
        {
            if (elem == null)
            {
                nullCounter++;
                if (nullCounter > 1)
                {
                    return false;
                }
            }
        }

        for (Object elem : c)
        {
            int matches = 0;
            for (Object elem2 : c)
            {
                if ((elem == null && elem2 == null) || (elem != null && elem2 != null && elem.equals(elem2)))
                {
                    matches++;
                }
            }
            if (matches > 1) //matches==1 would mean being unique, as it was a match to itself
            {
                return false;
            }
        }
        return true;
    }
}