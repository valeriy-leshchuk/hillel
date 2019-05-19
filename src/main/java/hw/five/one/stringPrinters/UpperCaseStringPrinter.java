package hw.five.one.stringPrinters;

public class UpperCaseStringPrinter extends AbstractStringPrinter
{
    @Override
    public void printStr(String str)
    {
        System.out.println(str.toUpperCase());
    }

    @Override
    public String modifyStr(String str)
    {
        return str.toUpperCase();
    }
}