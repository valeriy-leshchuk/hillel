package classwork.apr18.observer;

import java.util.*;

public class DataStore implements DataEventPublisher
{
    private Map<Event, Set<IObserver>> observers_ = new HashMap<>();

    @Override
    public void subscribe(Event event, IObserver observer)
    {
        Set<IObserver> observersTmp;
        if (!observers_.containsKey(event))
        {
            observersTmp = new HashSet<>();
            observers_.put(event, observersTmp);
        }
        else
        {
            observersTmp = observers_.get(event);
        }
        observersTmp.add(observer);
    }

    @Override
    public void notify(Event event)
    {
        if (observers_.containsKey(event))
        {
            observers_.get(event).forEach(observer -> {
                observer.react(event, observer);
            });
        }
    }

    @Override
    public void unsubscribe(Event event, IObserver observer)
    {
        if (observers_.containsKey(event))
        {
            observers_.get(event).remove(observer);
        }
    }
}
