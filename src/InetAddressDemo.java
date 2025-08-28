import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
//        InetAddress names []  = InetAddress.getAllByName("techbinz.com");
//        for (InetAddress name: names){
//            System.out.println(name);
//        }

        InetAddress myAddress = InetAddress.getLoopbackAddress();
        System.out.println(myAddress.getAddress());

        if (myAddress.isLoopbackAddress()){
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
