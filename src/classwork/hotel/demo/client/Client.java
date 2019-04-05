package classwork.hotel.demo.client;

import java.util.Objects;

public class Client
{
    private String name_;
    private String phoneNumber_;

    public Client(String phoneNumber, String clientName)
    {
        phoneNumber_ = phoneNumber;
        name_ = clientName;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        Client client = (Client) o;
        return Objects.equals(getPhoneNumber(), client.getPhoneNumber()) && Objects.equals(getName(), client.getName());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getPhoneNumber(), getName());
    }

    public String getName()
    {
        return name_;
    }

    public String getPhoneNumber()
    {
        return phoneNumber_;
    }

    @Override
    public String toString()
    {
        return "Client: [" + "name_=" + name_ + ", phoneNumber_=" + phoneNumber_ + ']';
    }
}
