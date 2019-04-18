package classwork.apr18.facade;

public class FormatFacadeImpl implements FormatFacade
{
    @Override
    public void executeFormat(FileFormat fileFormat)
    {
        if (fileFormat.getExtension().equals("txt"))
        {
            new TextCodec().format(fileFormat);
        }
        else if (fileFormat.getExtension().equals("mpeg"))
        {
            new VideoCodec().format(fileFormat);
        }
    }
}
