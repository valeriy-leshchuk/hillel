package classwork.apr18.facade;

public class FacadeDemo
{
    public static void main(String[] args)
    {
        FormatFacade ff = new FormatFacadeImpl();
        ff.executeFormat(new FileFormat("txt"));
    }
}
