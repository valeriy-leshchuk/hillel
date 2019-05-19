package classwork.apr18.observer;

public class ObserverDemo
{
    public static void main(String[] args)
    {
        IObserver obs1 = new ObserverImpl();
        IObserver obs2 = new ObserverImpl();

        Event event = new Event("event1");

        DataEventPublisher ds = new DataStore();
        ds.notify(event);

        ds.subscribe(event, obs1);
        ds.subscribe(event, obs2);

        ds.notify(event);

        ds.notify(new Event("event2"));

        ds.unsubscribe(event, obs1);
        ds.notify(event);

    }
}
