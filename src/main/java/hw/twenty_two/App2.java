package hw.twenty_two;

import lombok.extern.log4j.Log4j;

import java.util.Random;

@Log4j
public class App2
{
    public static void main(String[] args)
    {

        Thread subThread = new Thread(() -> {
            log.debug("SubThread started");
            try
            {
                Thread.sleep(10 * 1000);
            }
            catch (InterruptedException ex)
            {
                Thread.currentThread().interrupt();
                log.error("Thread '" + Thread.currentThread().getName() + "' was interrupted.");
                return;
            }
        });
        subThread.setName("subThread");
        subThread.start();

        try
        {
            int sleepSeconds = new Random().nextInt(10);
            log.debug("Main thread will sleep for " + sleepSeconds + " seconds");
            Thread.sleep(sleepSeconds * 1000);
        }
        catch (InterruptedException ex)
        {
            log.error("Thread '" + Thread.currentThread().getName() + "' was interrupted.");
        }

        log.debug("Interrupting subThread with name '" + subThread.getName() + "'");
        subThread.interrupt();

    }
}
