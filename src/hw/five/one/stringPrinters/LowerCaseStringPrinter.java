package hw.five.one.stringPrinters;

public class LowerCaseStringPrinter extends AbstractStringPrinter
{
    @Override
    public void printStr(String str)
    {
        System.out.println(str.toLowerCase());
    }

    @Override
    public String modifyStr(String str)
    {
        return str.toLowerCase();
    }
}