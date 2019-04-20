package hw.thirteen.Observer.listen;

import hw.thirteen.Observer.mail.Mail;
import hw.utils.Logger;

public class InfoMailListener extends AbstractMailListener implements IMailListener
{
    public InfoMailListener(int id)
    {
        super(id);
    }

    @Override
    public void processMail(Mail mail)
    {
        Logger.info("Email was processed by info listener with id " + id_ + ". " + mail.toString());
    }
}
