package classwork.apr21.sockets;

import hw.utils.Logger;

import java.io.IOException;
import java.net.ConnectException;

public class ClientApp
{
    public static void main(String[] args)
    {
        try
        {
            IClient IClient = new Client("127.0.0.1", AppConstants.APP_DEMO_PORT);
            IClient.doWhileNotExit();
        }
        catch (ConnectException ex)
        {
            Logger.getLogger().warning("There is no server at destination host/port");
        }
        catch (IOException ex)
        {
            Logger.getLogger().warning("Could not connect");
            ex.printStackTrace();
        }
    }
}
