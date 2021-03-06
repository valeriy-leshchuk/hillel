package classwork.apr21.sockets;

import hw.utils.Logger;

import java.io.IOException;
import java.net.BindException;

public class ServerApp
{
    public static void main(String[] args)
    {
        try
        {
            IServer server = new Server(AppConstants.APP_DEMO_PORT);
            server.doWhileNotExit();
        }
        catch (BindException ex)
        {
            Logger.getLogger().warning("Address is already in use: " + AppConstants.APP_DEMO_PORT);
        }
        catch (IOException ex)
        {
            Logger.getLogger().warning("Server app error");
            ex.printStackTrace();
        }
    }
}
