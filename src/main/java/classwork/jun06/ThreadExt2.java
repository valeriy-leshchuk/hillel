package classwork.jun06;

import java.util.Date;

public class ThreadExt2 implements Runnable
{
    @Override
    public void run()
    {
        System.out.println("thread name " + Thread.currentThread() + " " + (new Date()).getTime());
    }
}
