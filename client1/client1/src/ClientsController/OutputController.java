package ClientsController;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class OutputController extends Thread{
    public OutputController(Socket socket){
        this.socket = socket ;
    }
    private Socket socket;
    Scanner scanner = new Scanner(System.in) ;
    @Override
    public void run() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String massege="hossein";
            out.println(massege);
            while (!massege.equals("exit") || massege.equals(null)){
                massege = scanner.nextLine();
                out.println(massege);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
