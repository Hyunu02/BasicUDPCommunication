import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        // DatagramSocket to listen at port 1234
        DatagramSocket ds = new DatagramSocket(1234);
        byte[] receive = new byte[65535];

        DatagramPacket dpReceive = null;
        while(true) {
            // create DatagramPacket to receive data
            dpReceive = new DatagramPacket(receive, receive.length);

            // revive the data in byte buffer
            ds.receive(dpReceive);

            System.out.println("Client: " + data(receive));

            // exit server if client sends bye
            if(data(receive).toString().equals("bye")) {
                System.out.println("Client sent bye.....EXITING");
                break;
            }

            // clear buffer after every message
            receive = new byte[65535];

        }
    }

    public static StringBuilder data(byte[] a) {
        if (a == null)
            return null;
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while (a[i] != 0) {
            ret.append((char) a[i]);
            i++;
        }
        return ret;
    }
}