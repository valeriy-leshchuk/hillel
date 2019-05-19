package hw.nine;

public class Test
{
    protected int intField_;
    protected String stringField_;

    Test(int intField, String stringField)
    {
        intField_ = intField;
        stringField_ = stringField;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Test test = (Test) o;

        if (intField_ != test.intField_) return false;
        return stringField_ != null ? stringField_.equals(test.stringField_) : test.stringField_ == null;
    }

    @Override
    public int hashCode()
    {
        int result = intField_;
        result = 31 * result + (stringField_ != null ? stringField_.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return "[" + intField_ + "=" + stringField_ + "]";
    }
}
