package classwork.apr11;

import java.io.File;

public class FileApp
{
    public static void main(String[] args)
    {
        File file = new File("/Users/valeriyl/Desktop/dir");
        if (file.exists() && file.isDirectory())
        {
            printAllChildren(file);
        }
    }

    private static void printAllChildren(File parent)
    {
        File[] childrenFiles = parent.listFiles();
        for (File file : childrenFiles)
        {
            if (file.isDirectory())
            {
                if (file.listFiles().length == 0)
                {
                    System.out.println(file.getAbsolutePath());
                }
                else
                {
                    printAllChildren(file);
                }

            }
            else
            {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}