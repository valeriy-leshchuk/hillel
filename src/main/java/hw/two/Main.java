package hw.two;

public class Main
{
    public static void main (String[] args)
    {
        while (true)
        {
            MenuUtils.printMenu();
            switch (MenuUtils.parseMenuItemFromUserInput())
            {
                case 1:
                {
                    TasksImpl.generateArrayWithMinMax();
                    break;
                }
                case 2:
                {
                    TasksImpl.generateNumberAndCalcFactorial();
                    break;
                }
                case 3:
                {
                    TasksImpl.generateAndPrintReactangles();
                    break;
                }
                case 0:
                {
                    return;
                }
            }

        }
    }
}
