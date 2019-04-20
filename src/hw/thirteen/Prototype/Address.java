package hw.thirteen.Prototype;

public class Address implements IClonable<Address>
{
    private String city_;
    private String street_;
    private int house_;

    public Address(String city, String street, int house)
    {
        city_ = city;
        street_ = street;
        house_ = house;
    }

    @Override
    public Address shallowCopy()
    {
        return new Address(city_, street_, house_);
    }

    @Override
    public Address deepCopy()
    {
        //Strings are immutable so we don't need to create them as separate objects
        return shallowCopy();
    }
}
