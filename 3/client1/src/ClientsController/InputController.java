package ClientsController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class InputController extends Thread{
    private Socket socket;
    public InputController(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run()  {
        try{

            InputStreamReader reader = new InputStreamReader(socket.getInputStream());
            BufferedReader in = new BufferedReader(reader);
            String massage = "h";
            while (!massage.equals("exit")){
                massage = in.readLine();
                if (massage.equals("connected")){
                    System.out.println(System.currentTimeMillis()-OutputController.currentTime);
                }
                System.out.println(massage);
            }
            in.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}




