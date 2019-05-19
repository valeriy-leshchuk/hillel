package hw.fourteen;

import hw.utils.Logger;

import java.io.IOException;
import java.net.BindException;

public class ServerApp
{
    public static void main(String[] args)
    {
        try
        {
            Server server = new Server(Constants.SERVER_PORT);
            server.performInLoop();
        }
        catch (BindException ex)
        {
            Logger.getLogger().error("Port " + Constants.SERVER_PORT + " is already in use").error("Exiting...");
            Logger.getLogger().exception(ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger().error("Could not connect.").error("Exiting...");
            Logger.getLogger().exception(ex);
        }
    }
}
