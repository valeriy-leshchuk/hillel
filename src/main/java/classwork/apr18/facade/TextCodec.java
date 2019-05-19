package classwork.apr18.facade;

import hw.utils.Logger;

public class TextCodec implements ICodec
{
    @Override
    public void format(FileFormat format)
    {
        Logger.getLogger().info("This is text codec of file  " + format);
    }
}
