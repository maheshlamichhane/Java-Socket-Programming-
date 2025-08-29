import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

public class NewtorkAdaptersDemo {

    public static void main(String[] args) throws SocketException {

        try {
            Enumeration<NetworkInterface> networkIe = NetworkInterface.getNetworkInterfaces();
            System.out.println("Newtork Display: \n");
            for (NetworkInterface element: Collections.list(networkIe)){
                System.out.printf("%-8s %-32s \n",element.getName(),element.getDisplayName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
