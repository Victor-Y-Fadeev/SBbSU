package sem3.hw4.task1;

import java.io.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Scanner;

public class Network {
    private InputStream input;
    private OutputStream output;

    public Network() throws IOException {
        Scanner in = new Scanner(System.in);

        System.out.print("You are server or not: ");
        final String respond = in.nextLine();

        if ((respond.charAt(0) == 'Y') || (respond.charAt(0) == 'y')) {
            serverDialog(in);
        } else {
            clientDialog(in);
        }
    }

    private void serverDialog(Scanner in) throws IOException {
        System.out.print("Choose your port from 1025 to 65535: ");
        int port = in.nextInt();

        System.out.println("\nYour ip & port: " + getCurrentIp() + " : " + Integer.toString(port));
        System.out.println("Waiting for a client...");

        ServerSocket server = new ServerSocket(port);
        Socket client = server.accept();

        input = client.getInputStream();
        output = client.getOutputStream();

        System.out.println("Connected");
    }

    private void clientDialog(Scanner in) throws IOException {
        System.out.print("Enter server ip: ");
        String ip = in.nextLine();

        System.out.print("Enter port: ");
        int port = in.nextInt();

        Socket server = new Socket(ip, port);

        input = server.getInputStream();
        output = server.getOutputStream();
        
        System.out.println("Connected");
    }

    private String getCurrentIp() throws IOException {
        String ip = "";

        Enumeration<NetworkInterface> network = NetworkInterface.getNetworkInterfaces();

        while (network.hasMoreElements()) {
            Enumeration<InetAddress> addresses = network.nextElement().getInetAddresses();

            while (addresses.hasMoreElements()) {
                String temp = addresses.nextElement().getHostAddress();

                if (temp.contains("192.168.")) {
                    ip = temp;
                }
            }
        }

        return ip.equals("") ? InetAddress.getLocalHost().getHostAddress() : ip;
    }
}
