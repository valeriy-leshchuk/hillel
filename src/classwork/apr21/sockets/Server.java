package classwork.apr21.sockets;

import hw.utils.Logger;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements IServer
{
    private final int serverPort_;

    public Server(int serverPort)
    {
        serverPort_ = serverPort;
    }

    @Override
    public void doWhileNotExit() throws IOException
    {
        try (
            ServerSocket serverSocket = new ServerSocket(serverPort_);

        )
        {
            Logger.info("Server started on port " + serverPort_);
            try (Socket socket = serverSocket.accept();
                 BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
            )
            {
                String clientMessage = null;
                while (!AppConstants.EXIT_COMMAND.equals(clientMessage = br.readLine()))
                {
                    Logger.info("Message from client: " + clientMessage);
                    bw.write("Msg '" + clientMessage + "' received.");
                    bw.newLine();
                    bw.flush();
                }
            }
        }
    }
}
