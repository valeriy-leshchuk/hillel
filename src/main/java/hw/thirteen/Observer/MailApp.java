package hw.thirteen.Observer;

import hw.thirteen.Observer.listen.ErrorMailListener;
import hw.thirteen.Observer.listen.IMailListener;
import hw.thirteen.Observer.listen.InfoMailListener;
import hw.thirteen.Observer.mail.Mail;
import hw.thirteen.Observer.mail.MailType;
import hw.thirteen.Observer.publish.MailPublisher;
import hw.utils.Logger;

public class MailApp
{
    public static void main(String[] args)
    {
        Mail infoMail1 = new Mail(MailType.INFO, "Some info");
        Mail errorMail1 = new Mail(MailType.ERROR, "Some error");

        IMailListener infoListener1 = new InfoMailListener(1);
        IMailListener infoListener2 = new InfoMailListener(2);
        IMailListener errorListener1 = new ErrorMailListener(3);
        IMailListener errorListener2 = new ErrorMailListener(4);

        MailPublisher mp = new MailPublisher();

        Logger.getLogger().delimiter(3);
        Logger.getLogger().info("Subsribing one listener for each type:");
        mp.subscribe(MailType.INFO, infoListener1);
        mp.subscribe(MailType.ERROR, errorListener1);
        mp.notify(infoMail1);
        mp.notify(errorMail1);

        Logger.getLogger().delimiter(3);
        Logger.getLogger().info("Subsribing one more listener for each type. Expect each mail be processed by two listeners:");
        mp.subscribe(MailType.INFO, infoListener2);
        mp.subscribe(MailType.ERROR, errorListener2);
        mp.notify(infoMail1);
        mp.notify(errorMail1);

        Logger.getLogger().delimiter(3);
        Logger.getLogger().info("Leaving one listener for each type:");
        mp.unsubscribe(MailType.INFO, infoListener1);
        mp.unsubscribe(MailType.ERROR, errorListener1);
        mp.notify(infoMail1);
        mp.notify(errorMail1);
    }
}
