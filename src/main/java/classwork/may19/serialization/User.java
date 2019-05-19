package classwork.may19.serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class User extends UserParent implements Externalizable
{
    private int intVar;
    private String stringVar;
    private transient String stringVar2;

    public User(int intVar, String stringVar, String stringVar2)
    {
        this.intVar = intVar;
        this.stringVar = stringVar;
        this.stringVar2 = stringVar2;
    }

    public User()
    {
    }

    @Override
    public String toString()
    {
        return "User{" +
            "intVar=" + intVar +
            ", stringVar='" + stringVar + '\'' +
            ", stringVar2='" + stringVar2 + '\'' +
            ", parentStrVar='" + parentStrVar + '\'' +
            '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException
    {
        out.writeInt(this.intVar);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
        this.intVar = in.readInt();
    }
}
