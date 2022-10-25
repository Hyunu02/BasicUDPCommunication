/*
    DatagramSockets are used for UDP connection instead TCP
*/

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        // Creating the DatagramSocket to carry data
        DatagramSocket ds = new DatagramSocket();

        // Getting the local IP
        InetAddress ip = InetAddress.getLocalHost();
        byte buf[] = null;

        while(true) {
            Scanner sc = new Scanner(System.in);
            String inp = sc.nextLine();

            // convert String input to byte array
            buf = inp.getBytes();

            // Creating datagramPacket to send data
            DatagramPacket dpSend = new DatagramPacket(buf, buf.length, ip, 1234);

            // invoke call to actually send the data

            ds.send(dpSend);

            // stop loop if enters "bye"

            if(inp.equals("bye")) break;
        }
    }
}