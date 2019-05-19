package hw.thirteen.Prototype;

public class CloneApp
{
    public static void main(String[] args)
    {
        Address address = new Address("City", "Street", 1);
        User user = new User("Name", "LastName", 111, address);

        User user2 = user.shallowCopy();
        User user3 = user.deepCopy();
    }
}
