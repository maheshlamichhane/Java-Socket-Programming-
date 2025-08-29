import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerUDPSocket {

    public static void main(String[] args) throws IOException {


        // STEP 1 Create a Datagram Socket Object
        DatagramSocket datagramSocket = new DatagramSocket(2082);

        // STEP 2 Create a buffer for incoming datagrams
        byte[] buffer = new byte[256];

        // STEP 3 Create a datagram packet for the incoming datagrams
        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);

        // STEP 4 Accept an incoming datagrams
        datagramSocket.receive(datagramPacket);

        // STEP 5 Accept the senders address and port from the packest
        InetAddress clientAddress = datagramSocket.getInetAddress();
        System.out.println("Client address="+clientAddress);
        // STEP 6 Retrieve the data from the buffer
        String message = new String(datagramPacket.getData(), 0, datagramPacket.getLength());

        // STEP 7 Create the response datagram
        DatagramPacket outPacket = new DatagramPacket(message.getBytes(), message.length(), clientAddress, datagramPacket.getPort());

        // STEP 8 Send the response datagram
        datagramSocket.send(outPacket);

        // STEP  Close the datagram socket9
        datagramSocket.close();

    }

    }
