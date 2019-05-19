package hw.eleven.exceptions;

import java.io.IOException;

public class EOFWasNotReachedException extends IOException
{
    public EOFWasNotReachedException()
    {
        super("List of elements was fully filled, but EOF was not reached.");
    }
}