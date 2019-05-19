package hw.nine;

public class TestTwo extends Test implements Comparable
{

    public TestTwo(int intField, String stringField)
    {
        super(intField, stringField);
    }

    @Override
    public int compareTo(Object o)
    {
        TestTwo that = (TestTwo) o;
        if (intField_ != that.intField_)
        {
            return intField_ - that.intField_;
        }
        else
        {
            return stringField_.compareTo(that.stringField_);
        }
    }
}