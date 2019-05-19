package hw.eleven.exceptions;

import java.io.IOException;

public class NonIntegerLineException extends IOException
{
    public NonIntegerLineException()
    {
        super("Couldn't parse line as integer.");
    }
}