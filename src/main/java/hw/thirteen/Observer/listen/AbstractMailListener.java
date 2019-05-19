package hw.thirteen.Observer.listen;

public abstract class AbstractMailListener implements IMailListener
{
    protected int id_;

    public AbstractMailListener(int id)
    {
        id_ = id;
    }
}
