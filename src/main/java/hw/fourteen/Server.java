package hw.fourteen;

import hw.utils.Logger;

import java.io.*;
import java.net.*;

public class Server
{
    private final int serverPort_;

    public Server(int serverPort)
    {
        serverPort_ = serverPort;
    }

    public void performInLoop() throws IOException
    {
        try (
            DatagramSocket serverSocket = new DatagramSocket(serverPort_))
        {
            Logger.getLogger().info("Server started on port " + serverPort_);

            String receivedData = "";
            while (!receivedData.trim().equals("exit"))
            {
                byte[] buffer = new byte[10000];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                serverSocket.receive(packet);
                receivedData = new String(packet.getData());
                Logger.getLogger().info("Received: " + receivedData);
            }
        }
    }
}
