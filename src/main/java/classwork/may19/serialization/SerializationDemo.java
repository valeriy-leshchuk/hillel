package classwork.may19.serialization;

import java.io.*;
import java.util.Arrays;

public class SerializationDemo
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        User user = new User(1, "abc", "222");

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(user);

        System.out.println(Arrays.toString(bos.toByteArray()));
        String objToStr = new String(bos.toByteArray());
        System.out.println(objToStr);

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        User user2 = (User)ois.readObject();
        System.out.println(user2.toString());
    }
}
