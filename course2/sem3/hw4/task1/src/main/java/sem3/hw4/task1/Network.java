package sem3.hw4.task1;

import java.io.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Scanner;

public class Network {
    private DataInputStream input;
    private DataOutputStream output;
    private boolean server;

    public Network() {
        Scanner in = new Scanner(System.in);

        System.out.print("You are server or not: ");
        final String respond = in.nextLine();

        try {
            if ((respond.charAt(0) == 'Y') || (respond.charAt(0) == 'y')) {
                server = true;
                //serverDialog(in);
            } else {
                server = false;
                //clientDialog(in);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int[] synchronization(int[] send) {
        int[] receive = null;

        try {
            if (isServer()) {
                receive = receiveData();
                sendData(send);
            } else {
                sendData(send);
                receive = receiveData();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return receive;
    }

    public boolean isServer() {
        return server;
    }

    private void sendData(int[] send) throws IOException {
        final int size = send.length;
        output.writeInt(size);

        for (int i = 0; i < size; i++) {
            output.writeInt(send[i]);
        }

        output.flush();
    }

    private int[] receiveData() throws IOException {
        final int size = input.readInt();
        int[] receive = new int[size];

        for (int i = 0; i < size; i++) {
            receive[i] = input.readInt();
        }

        return receive;
    }

    private void serverDialog(Scanner in) throws IOException {
        System.out.print("Choose your port from 1025 to 65535: ");
        final int port = in.nextInt();

        System.out.println("\nYour ip & port: " + getCurrentIp() + " : " + Integer.toString(port));
        System.out.println("Waiting for a client...");

        ServerSocket server = new ServerSocket(port);
        Socket client = server.accept();

        input = new DataInputStream(client.getInputStream());
        output = new DataOutputStream(client.getOutputStream());

        System.out.println("Connected");
    }

    private void clientDialog(Scanner in) throws IOException {
        System.out.print("Enter server ip: ");
        String ip = in.nextLine();

        System.out.print("Enter port: ");
        final int port = in.nextInt();

        Socket server = new Socket(ip, port);

        input = new DataInputStream(server.getInputStream());
        output = new DataOutputStream(server.getOutputStream());

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

        return ip.isEmpty() ? InetAddress.getLocalHost().getHostAddress() : ip;
    }
}
