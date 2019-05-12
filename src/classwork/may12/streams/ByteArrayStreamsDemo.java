package classwork.may12.streams;

import java.io.ByteArrayInputStream;

public class ByteArrayStreamsDemo
{
    public static void main(String[] args) throws Exception
    {
        ByteArrayInputStream bais = new ByteArrayInputStream(new byte[]{1,2,3});
        bais.reset();
        bais.close();//does not work
    }
}
