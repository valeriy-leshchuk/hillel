package hw.thirteen.Observer.listen;

import hw.thirteen.Observer.mail.Mail;
import hw.utils.Logger;

public class ErrorMailListener extends AbstractMailListener implements IMailListener
{

    public ErrorMailListener(int id)
    {
        super(id);
    }

    @Override
    public void processMail(Mail mail)
    {
        Logger.info("Email was processed by error listener with id: " + id_ + ". " + mail.toString());
    }
}
