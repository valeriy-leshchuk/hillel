package classwork.jun06;

public class ThreadsDemo
{
    public static void main(String[] args) throws Exception
    {
        //for (int i = 0; i < 10; i++)
        //{
        //    ThreadExt thread = new ThreadExt();
        //    thread.start();
        //}
        //for (int i = 0; i < 10; i++)
        //{
        //    Thread thread = new Thread(new ThreadExt2(), "threadName"+i);
        //    thread.start();
        //}
        for (int i = 0; i < 10; i++)
        {
            Thread thread = new Thread(()->
                System.out.println(Thread.currentThread())
            );
            thread.start();
            Thread.sleep(1000);
        }
    }
}
