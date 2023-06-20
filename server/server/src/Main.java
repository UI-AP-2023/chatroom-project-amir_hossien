import ServerController.InPutController;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;


//IN THE NAME OF GOD
public class Main {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        try {
            ServerSocket inPutServerSocket = new ServerSocket(6686);
            while (true) {
                Socket Socket = inPutServerSocket.accept();
                InPutController.sockets.add(Socket);
                InputStreamReader reader = new InputStreamReader(Socket.getInputStream());
                BufferedReader in = new BufferedReader(reader);
                InPutController inPutController = new InPutController(Socket,in.readLine());
                inPutController.start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}













