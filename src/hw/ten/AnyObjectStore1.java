package hw.ten;

import java.util.HashSet;
import java.util.Set;

public class AnyObjectStore1<T extends Number>
{
    private Set<T> store_ = new HashSet<>();

    public boolean addElement(T elementToAdd)
    {
        return store_.add(elementToAdd);
    }

    public boolean removeElement(T elementToRemove)
    {
        return store_.remove(elementToRemove);
    }

    public boolean contains(T element)
    {
        return store_.remove(element);
    }

    public Set<T> getStore()
    {
        return store_;
    }
}
