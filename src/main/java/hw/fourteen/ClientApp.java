package hw.fourteen;

import hw.utils.Logger;

import java.io.IOException;
import java.net.BindException;
import java.net.UnknownHostException;

public class ClientApp
{
    public static void main(String[] args)
    {
        try
        {
            Client client = new Client(Constants.CLIENT_HOST, Constants.CLIENT_PORT);
            client.performInLoop();
        }
        catch (BindException ex)
        {
            Logger.getLogger().error("Port " + Constants.CLIENT_PORT + " is already in use").error("Exiting...");
            Logger.getLogger().exception(ex);
        }
        catch (UnknownHostException ex)
        {
            Logger.getLogger().error("There is no server at destination host/port.").error("Exiting...");
            Logger.getLogger().exception(ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger().error("Could not connect.").error("Exiting...");
            Logger.getLogger().exception(ex);
        }
    }
}
