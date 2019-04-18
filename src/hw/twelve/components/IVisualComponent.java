package hw.twelve.components;

import hw.utils.Logger;

public interface IVisualComponent
{
    default void paint()
    {
        Logger.info("Paint was invoked for " + this.getClass().getSimpleName());
    }
}