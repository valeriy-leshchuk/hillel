package hw.eleven;

import hw.utils.Logger;

public class TestApp
{
    public static void main(String[] args) throws Exception
    {
        String filePath = "/Users/valeriyl/Desktop/dir/file.txt";
        ListOfNumbers list = new ListOfNumbers();

        //1
        {
            list.writeContentToFile(filePath);
            Logger.info("Writing to file is done.");
        }

        //2
        {
            list.readContentFromFile(filePath);
            Logger.info(list.getList().toString());
        }
    }
}