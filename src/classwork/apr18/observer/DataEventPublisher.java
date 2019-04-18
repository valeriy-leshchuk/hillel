package classwork.apr18.observer;

public interface DataEventPublisher
{
    void subscribe(Event event, IObserver observer);

    void notify(Event event);

    void unsubscribe(Event event, IObserver observer);
}
