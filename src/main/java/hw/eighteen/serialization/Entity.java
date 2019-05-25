package hw.eighteen.serialization;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Entity implements Serializable, Externalizable
{
    private int intVar;
    private String strVar;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException
    {
        out.writeInt(intVar);
        out.writeObject(strVar);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
        intVar=in.readInt();
        strVar = (String)in.readObject();
    }
}
