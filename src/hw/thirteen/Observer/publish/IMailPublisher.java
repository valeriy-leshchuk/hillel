package hw.thirteen.Observer.publish;

import hw.thirteen.Observer.listen.IMailListener;
import hw.thirteen.Observer.mail.Mail;
import hw.thirteen.Observer.mail.MailType;

public interface IMailPublisher
{
    void subscribe(MailType mailType, IMailListener listener);

    void notify(Mail mail);

    void unsubscribe(MailType mailType, IMailListener listener);
}
