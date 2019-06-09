package classwork.jun06;

import java.io.File;

public class ProcessesDemo
{
    public static void main(String[] args) throws Exception
    {
        ProcessBuilder pb = new ProcessBuilder();
        pb.directory(new File(System.getProperty("user.home")));
        String[] command = { "open", "Downloads"};
        pb.command(command);
        Process process = pb.start();

        int status = process.waitFor();
        System.out.println(status);
    }
}
