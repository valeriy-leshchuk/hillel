package hw.twenty_two;

import lombok.extern.log4j.Log4j;

@Log4j
public class App1
{
    public static void main(String[] args)
    {

        Thread subThread = new Thread(()->{
            for (int i = 1; i <= 5; i++)
            {
                log.debug(i);
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException ex)
                {
                    return;
                }
            }
        });
        subThread.setName("subThread");
        subThread.start();
        try
        {
            subThread.join();
        }
        catch (InterruptedException ex)
        {
            log.error("Thread '" + subThread.getName() + "' was interrupted.");
        }
        log.debug("Done");
    }
}
