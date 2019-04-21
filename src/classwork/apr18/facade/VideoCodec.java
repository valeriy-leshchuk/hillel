package classwork.apr18.facade;

import hw.utils.Logger;

public class VideoCodec implements ICodec
{
    @Override
    public void format(FileFormat format)
    {
        Logger.getLogger().info("This is video codec of file  " + format);
    }
}
