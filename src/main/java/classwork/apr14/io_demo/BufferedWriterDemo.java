package classwork.apr14.io_demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterDemo
{
    public static void main(String[] args)
    {
        try
        {
            FileWriter fw = new FileWriter("/Users/valeriyl/Desktop/dir/file.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < 100; i++)
            {
                bw.write("Line #" + (i + 1) + "\n");
            }
            bw.flush();

        }
        catch (IOException ex)
        {
            System.out.println("Error happened");
            ex.printStackTrace();
        }
    }
}
