package hw.thirteen.Prototype;

public interface IClonable<T extends IClonable<T>> extends Cloneable
{
//TODO: find out normal way how to make these methods return only objects of type of class where they are implemented.
//So if they are implemented in TestClass, then they should return only TestClass objects

    T shallowCopy();

    T deepCopy();
}
