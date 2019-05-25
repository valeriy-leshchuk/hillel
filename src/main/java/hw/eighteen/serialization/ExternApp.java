package hw.eighteen.serialization;

import lombok.extern.log4j.Log4j;

import java.io.*;

@Log4j
public class ExternApp
{
    public static void main(String[] args) throws Exception
    {
        Entity entity = new Entity(11,"aa");

        String filePath = "/Users/valeriyl/Desktop/dir/file2.txt";
        File file = new File(filePath);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        entity.writeExternal(oos);
        oos.flush();
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(bos.toByteArray());

        FileInputStream fin = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fin);
        Entity entiry2 = new Entity();
        entiry2.readExternal(ois);
        log.debug(entiry2.toString());
    }

}
