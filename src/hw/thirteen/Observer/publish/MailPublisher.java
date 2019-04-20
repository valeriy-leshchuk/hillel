package hw.thirteen.Observer.publish;

import hw.thirteen.Observer.listen.IMailListener;
import hw.thirteen.Observer.mail.Mail;
import hw.thirteen.Observer.mail.MailType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MailPublisher implements IMailPublisher
{
    private Map<MailType, Set<IMailListener>> listeners_ = new HashMap<>();

    @Override
    public void subscribe(MailType mailType, IMailListener listener)
    {
        Set<IMailListener> listenersTemp;
        if (!listeners_.containsKey(mailType))
        {
            listenersTemp = new HashSet<>();
            listeners_.put(mailType, listenersTemp);
        }
        else
        {
            listenersTemp = listeners_.get(mailType);
        }
        listenersTemp.add(listener);
    }

    @Override
    public void notify(Mail mail)
    {
        MailType mailType = mail.getType();
        if (listeners_.containsKey(mailType))
        {
            listeners_.get(mailType).forEach(listener -> listener.processMail(mail));
        }
    }

    @Override
    public void unsubscribe(MailType mailType, IMailListener listener)
    {
        if (listeners_.containsKey(mailType))
        {
            Set<IMailListener> listenersOfType = listeners_.get(mailType);
            listenersOfType.remove(listener);
            if (listenersOfType.isEmpty())
            {
                listeners_.remove(mailType);
            }
        }
    }
}
