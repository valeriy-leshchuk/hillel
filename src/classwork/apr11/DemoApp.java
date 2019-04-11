package classwork.apr11;

import java.util.Scanner;

class OddNumberException extends Exception
{
}

public class DemoApp
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int intVal = Integer.valueOf(line);
        try
        {
            processUserInput(intVal);
        }
        catch (OddNumberException ex)
        {
            System.out.println(ex);
        }
        finally
        {

        }
    }

    public static void processUserInput (int userNumber) throws OddNumberException
    {
        if(userNumber %2 !=0)
        {
            throw new OddNumberException();
        }
        System.out.println("Number is even.");
    }
}

