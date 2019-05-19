package hw.fourteen;

import hw.utils.Logger;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client
{
    private final String serverHost_;
    private final int serverPort_;
    private final InetAddress address_;

    public Client(String serverHost, int serverPort) throws UnknownHostException
    {
        serverHost_ = serverHost;
        serverPort_ = serverPort;
        address_ = InetAddress.getByName(serverHost_);
    }

    public void performInLoop() throws IOException
    {
        try (DatagramSocket socket = new DatagramSocket(serverPort_);
             Scanner scanner = new Scanner(System.in))
        {
            String userText = "";
            while (!userText.equals("exit"))
            {
                Logger.getLogger().info("Enter message:");
                userText = scanner.nextLine();
                DatagramPacket packet = new DatagramPacket(userText.getBytes(), userText.length(), address_, Constants.SERVER_PORT);
                socket.send(packet);
            }
        }
    }
}
