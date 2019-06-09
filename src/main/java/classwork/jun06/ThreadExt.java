package classwork.jun06;

import java.util.Date;

public class ThreadExt extends Thread
{
    @Override
    public void run()
    {
        print();
    }
    private void print()
    {
        System.out.println("thread name " + getName() + " " + (new Date()).getTime());
    }
}
