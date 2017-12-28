package sem3.hw4.task1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Network {
    private ObjectInputStream input;
    private ObjectOutputStream output;

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

        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println("\nYour ip & port: " + localHost.getHostAddress() + " : " + Integer.toString(port));
        System.out.println("Waiting for a client...");

        ServerSocket server = new ServerSocket(port);
        Socket client = server.accept();
        input = new ObjectInputStream(client.getInputStream());
        output = new ObjectOutputStream(client.getOutputStream());

        System.out.println("Connected");
    }

    private void clientDialog(Scanner in) throws IOException {
        System.out.print("Enter server ip: ");
        String ip = in.nextLine();

        System.out.print("Enter port: ");
        int port = in.nextInt();

        Socket server = new Socket(ip, port);
        input = new ObjectInputStream(server.getInputStream());
        output = new ObjectOutputStream(server.getOutputStream());

        System.out.println("Connected");
    }
}
