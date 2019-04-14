package classwork.apr14.io_demo;

import java.io.*;

public class Demo
{
    public static void main(String[] args)
    {
        try
        {
            //boolean dirsWereCreated = new File("/Users/valeriyl/Desktop/dir/dir1/dir2").mkdirs();
            File file = new File("/Users/valeriyl/Desktop/dir/file.txt");
            boolean fileWasCreated = file.createNewFile();
            System.out.println("File was created: " + fileWasCreated);

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr, 10);
            String str;
            while ((str = br.readLine()) != null)
            {
                System.out.println("Line is: " + str);
            }
            br.close(); //implicit call to fr.close()

        }
        catch (IOException ex)
        {
            System.out.println("Smth went wrong");
            ex.printStackTrace();
        }

    }
}
