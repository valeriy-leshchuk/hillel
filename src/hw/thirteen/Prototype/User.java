package hw.thirteen.Prototype;

public class User implements IClonable<User>
{
    private String name_;
    private String lastName_;
    private double age_;
    private Address address_;

    public User(String name, String lastName, double age, Address address)
    {
        name_ = name;
        lastName_ = lastName;
        age_ = age;
        address_ = address;
    }

    @Override
    public User shallowCopy()
    {
        return new User(name_, lastName_, age_, address_);
    }

    @Override
    public User deepCopy()
    {
        //Strings are immutable so we don't need to create them as separate objects
        return new User(name_, lastName_, age_, address_.deepCopy());
    }
}
