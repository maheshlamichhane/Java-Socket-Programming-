import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerSocket {

    private static java.net.ServerSocket myServerSocket;
    private static final int PORT = 1234;

    public static void main(String[] args) throws IOException {

        System.out.println("Opening port... "+PORT + "\n");
        try {
            myServerSocket = new java.net.ServerSocket(PORT);
        }catch (IOException ioException){
            System.out.println("Unable to attach to port!");
            System.exit(1);
        }

        do{
            handleClient();
        }while (true);
    }

    private static void handleClient(){
        Socket myLink = null;
        try {
            myLink = myServerSocket.accept(); //Step2
            Scanner input = new Scanner(myLink.getInputStream());
            PrintWriter output = new PrintWriter(myLink.getOutputStream(),true); //Step3
            int myNumMessages = 0;
            String message = input.nextLine(); //Step4
            while (!message.equals("*** CLOSE ***")){
                System.out.println("Message received.");
                myNumMessages++;
                output.println("MESSAGE "+myNumMessages + ": "+message); // Step4
                message = input.nextLine();
            }
            output.println(myNumMessages + " MESSAGES RECEIVED.");
        }
        catch (IOException ioEx){
            ioEx.printStackTrace();
        }
        finally {
            try{
                System.out.println("\n********** CLOSING CONNECTION  ***************");
                myLink.close(); // step 5
            }
            catch (IOException ioEX){
                System.out.println("**** UNABLE TO DISCONNECT ! ****");
                System.exit(1);
            }
        }
    }
}
