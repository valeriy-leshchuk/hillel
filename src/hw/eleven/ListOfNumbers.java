package hw.eleven;

import hw.eleven.exceptions.*;
import hw.utils.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListOfNumbers
{
    private List<Integer> list_;
    private static final int SIZE = 10;

    public ListOfNumbers()
    {
        list_ = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i++)
            list_.add(i);
    }

    public void writeContentToFile(String fileLocation) throws IOException
    {
        File file = new File(fileLocation);

        String dirPath = fileLocation.replaceAll("/" + file.getName(), "");
        File dirs = new File(dirPath);

        if (!dirs.exists())
        {
            dirs.mkdirs();
        }
        if (!file.exists())
        {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);

        for (Integer elem : list_)
        {
            bw.write(elem.toString() + "\n");
        }
        bw.flush();
        bw.close();

    }

    public void readContentFromFile(String fileLocation) throws IOException
    {
        File file = new File(fileLocation);
        if (!file.exists())
        {
            throw new IOException("Requested file was not found.");
        }

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        List<Integer> tempList = new ArrayList<>();
        String line;
        int linesProcessed = 0;
        try
        {
            if (!file.canRead())
            {
                throw new FileCouldNotBeReadException();
            }

            while ((line = br.readLine()) != null && !line.isEmpty())
            {
                Logger.getLogger().info("Processing line [" + line + "]");
                if (linesProcessed == SIZE)
                {
                    throw new EOFWasNotReachedException();
                }
                try
                {
                    int elem = Integer.parseInt(line);
                    tempList.add(elem);
                    linesProcessed++;
                }
                catch (NumberFormatException ex)
                {
                    throw new NonIntegerLineException();
                }
            }
            if (linesProcessed < SIZE)
            {
                Logger.getLogger().warning("File was fully read but list was not fully filled.");
            }
        }
        finally
        {
            br.close();
        }

        list_ = tempList;
        Logger.getLogger().info("Done. List is filled.");
    }

    public List<Integer> getList()
    {
        return list_;
    }
}