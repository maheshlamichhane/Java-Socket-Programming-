import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TcpSocketClient {

    private static InetAddress host;
    private static final int PORT = 1234;


    public static void main(String[] args) {
        try{
            host = InetAddress.getLocalHost();
        }
        catch (UnknownHostException e){
            System.out.println("ERROR CAUSED : "+e.getMessage());
            System.exit(1);
        }

        accessServer();


    }



    private static void accessServer(){
        Socket link = null;
        try{
            link = new Socket(host.getHostAddress(),PORT);  //STEP 1
            Scanner input = new Scanner(link.getInputStream()); //STEP2

            PrintWriter output = new PrintWriter(link.getOutputStream(),true);
            Scanner userEntry = new Scanner(System.in);
            String message,response;
            do{
                System.out.println("Enter Message: ");
                message = userEntry.nextLine();
                output.println(message);
                response = input.nextLine();
                System.out.println("\nSERVER > "+response);
            }while (!message.equals("*** CLOSE ***"));
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        finally {
            try {
                System.out.println("\n CLOSING CONNECTION");
                link.close();
            }catch (IOException ioException){
                System.out.println("Unable to Disconnect ERROR : "+ioException.getMessage());
                System.exit(1);
            }
        }
    }
}
