import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;

public class TcpSocketServerNIO {

    public static void main(String[] args) {

        System.out.println("Time server is Started");
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(6000));
            while(true){
                System.out.println("waiting for request !");
                SocketChannel socketChannel = serverSocketChannel.accept();
                if (socketChannel != null){
                    String dateTimeMessage = "DATE : "+ new Date(System.currentTimeMillis());
                    ByteBuffer buffer = ByteBuffer.allocate(64);
                    buffer.put(dateTimeMessage.getBytes());
                    buffer.flip();
                    while (buffer.hasRemaining()){
                        socketChannel.write(buffer);
                    }
                    System.out.println("Sent :"+ dateTimeMessage);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
