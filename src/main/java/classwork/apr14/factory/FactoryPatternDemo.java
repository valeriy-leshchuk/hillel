package classwork.apr14.factory;

import classwork.apr14.factory.entities.*;

import java.util.Scanner;

public class FactoryPatternDemo
{
    public static void main(String[] args)
    {
        System.out.println("Enter type of object:\nc-classic\nl-loft");
        Scanner scanner = new Scanner(System.in);
        String userChoice = scanner.nextLine();
        AbstractFactory factory;
        switch (userChoice)
        {
            case "c":
            {
                factory = new ClassicFactory();
                break;
            }
            case "l":
            {
                factory = new LoftFactory();
                break;
            }
            default:
            {
                factory = null;
            }
        }

        if (factory != null)
        {
            System.out.println("Chair is: " + createChair(factory));
            System.out.println("Table is: " + createTable(factory));
        }
    }

    private static IChair createChair(AbstractFactory factory)
    {
        return factory.createChair();
    }

    private static ITable createTable(AbstractFactory factory)
    {
        return factory.createTable();
    }
}
