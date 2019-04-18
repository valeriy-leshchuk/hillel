package hw.eleven;

import java.io.IOException;

class FileCouldNotBeReadException extends IOException
{
    public FileCouldNotBeReadException()
    {
        super("File couldn't be read.");
    }
}

class EOFWasNotReachedException extends IOException
{
    public EOFWasNotReachedException()
    {
        super("Lit of elements was fully filled, but EOF was not reached.");
    }
}

class NonIntegerLineException extends IOException
{
    public NonIntegerLineException()
    {
        super("Couldn't parse line as integer.");
    }
}