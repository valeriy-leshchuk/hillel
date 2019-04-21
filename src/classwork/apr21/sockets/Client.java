package classwork.apr21.sockets;

import hw.utils.Logger;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client implements IClient
{
    private final String serverHost_;
    private final int serverPort_;

    public Client(String serverHost, int serverPort)
    {
        serverHost_ = serverHost;
        serverPort_ = serverPort;
    }

    @Override
    public void doWhileNotExit() throws IOException
    {
        try (Socket socket = new Socket(serverHost_, serverPort_);
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in))
        {
            String userText = null;
            while (!AppConstants.EXIT_COMMAND.equals(userText))
            {
                Logger.getLogger().info("Enter message:");
                userText = scanner.nextLine();
                bw.write(userText);
                bw.newLine();
                bw.flush();
                System.out.println(br.readLine());
            }
        }
    }
}
