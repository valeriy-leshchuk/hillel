package hw.eleven.exceptions;

import java.io.IOException;

public class FileCouldNotBeReadException extends IOException
{
    public FileCouldNotBeReadException()
    {
        super("File couldn't be read.");
    }
}
