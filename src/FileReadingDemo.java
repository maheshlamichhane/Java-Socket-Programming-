import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class FileReadingDemo {
    public static void main(String[] args) throws IOException {

//        InetAddress oscalyWebsite = InetAddress.getByName("www.ocsaly.com");
//        System.out.println(oscalyWebsite);
//        System.out.println("HOST ADDRESS: "+oscalyWebsite.getHostAddress());
//        System.out.println("CANONICAL HOST NAME: "+oscalyWebsite.getCanonicalHostName());
//        System.out.println("HOST NAME: "+oscalyWebsite.getHostName());
//        oscalyWebsite.isReachable(10000);

//        try {
//            URL url = new URL("https://ocsaly.com");
//            URLConnection myUrlConnection = url.openConnection();
//            BufferedReader br = new BufferedReader(new InputStreamReader(myUrlConnection.getInputStream()));
//            String myLine;
//
//            while((myLine = br.readLine()) != null){
//                System.out.println(myLine);
//            }
//            br.close();
//
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }

        try {
            URL url = new URL("https://ocsaly.com");
            URLConnection myUrlConnection = url.openConnection();
            InputStream inputStream = myUrlConnection.getInputStream();
            ReadableByteChannel readableByteChannel = Channels.newChannel(inputStream);
            ByteBuffer buffer = ByteBuffer.allocate(64);


            while(readableByteChannel.read(buffer) > 0){
                System.out.println(new String(buffer.array()));
                buffer.clear();
            }

            readableByteChannel.close();


        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}