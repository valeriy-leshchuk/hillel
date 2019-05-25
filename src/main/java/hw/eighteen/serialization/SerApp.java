package hw.eighteen.serialization;

import lombok.extern.log4j.Log4j;

import java.io.*;
@Log4j
public class SerApp
{
    public static void main(String[] args) throws Exception
    {
        Entity entity = new Entity(11,"aa");

        String filePath = "/Users/valeriyl/Desktop/dir/file.txt";
        File file = new File(filePath);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(entity);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(bos.toByteArray());

        FileInputStream fin = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fin);
        Entity entiry2 = (Entity) ois.readObject();
        log.debug(entiry2.toString());
    }
}
