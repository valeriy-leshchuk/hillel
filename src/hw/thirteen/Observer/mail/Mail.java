package hw.thirteen.Observer.mail;

public class Mail
{
    private MailType type_;
    private String content_;

    public Mail(MailType type, String content)
    {
        type_ = type;
        content_ = content;
    }

    public MailType getType()
    {
        return type_;
    }

    @Override
    public String toString()
    {
        return "Mail: [" + "type_=" + type_ + ", content_=" + content_ + ']';
    }
}
