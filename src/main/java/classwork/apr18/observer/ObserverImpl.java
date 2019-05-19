package classwork.apr18.observer;

import hw.utils.Logger;

public class ObserverImpl implements IObserver
{
    @Override
    public void react(Event event, Object data)
    {
        Logger.getLogger().info("Event " + event.toString() + " was triggered on ");
    }
}
