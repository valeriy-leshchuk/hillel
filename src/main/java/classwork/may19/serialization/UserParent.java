package classwork.may19.serialization;

public class UserParent
{
    protected String parentStrVar = "111";

    public UserParent()
    {
        System.out.println("UserParent def constr.");
    }

    @Override
    public String toString()
    {
        return "UserParent{" +
            "parentStrVar='" + parentStrVar + '\'' +
            '}';
    }
}
