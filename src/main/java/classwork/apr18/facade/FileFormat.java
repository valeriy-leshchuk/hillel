package classwork.apr18.facade;

public class FileFormat
{
    String extension_;

    public FileFormat(String extension)
    {
        extension_ = extension;
    }

    public String getExtension()
    {
        return extension_;
    }

    public void setExtension(String extension)
    {
        extension_ = extension;
    }
}
