package hw.two;

import java.util.Scanner;

class MenuUtils
{
    private final static String WRONG_SELECTION_ERROR = "Wrong selection. Try once more.";

    static void printMenu ()
    {
        System.out.println("1. Generate array of with 100 elements, fill it with random numbers in range [100-10000], find min and max values.");
        System.out.println("2. Generate random numbers in range [1-10], calculate factorial for it in different ways.");
        System.out.println("3. Generate random rectangle with side length in range [10-20]. Print it. Print border only.");
        System.out.println("0. Exit.");
    }

    static int parseMenuItemFromUserInput ()
    {
        int selectedItem;
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.length() != 1)
        {
            System.out.println(WRONG_SELECTION_ERROR);
            return -1;
        }
        try
        {
            selectedItem = Integer.parseInt(input);
        }
        catch (NumberFormatException ex)
        {
            System.out.println(WRONG_SELECTION_ERROR);
            return -1;
        }
        if (selectedItem<0 || selectedItem>3)
        {
            System.out.println(WRONG_SELECTION_ERROR);
            return -1;
        }
        return selectedItem;
    }
}
