package classwork.hotel.demo.client;

import java.util.Objects;

public class Client
{
    private String phoneNumber;
    private String clientName;

    public Client (String phoneNumber, String clientName)
    {
        this.phoneNumber = phoneNumber;
        this.clientName = clientName;
    }

    @Override
    public boolean equals (Object o)
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
        return Objects.equals(getPhoneNumber(), client.getPhoneNumber()) && Objects.equals(getClientName(), client.getClientName());
    }

    @Override
    public int hashCode ()
    {
        return Objects.hash(getPhoneNumber(), getClientName());
    }

    public String getClientName ()
    {
        return clientName;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    @Override
    public String toString ()
    {
        return "Client{" + "phoneNumber='" + phoneNumber + '\'' + ", clientName='" + clientName + '\'' + '}';
    }
}
