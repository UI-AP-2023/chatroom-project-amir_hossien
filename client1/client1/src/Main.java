import ClientsController.InputController;
import ClientsController.OutputController;

import java.net.* ;
import java.io.* ;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket clientSocketOutput = new Socket("172.17.37.233",6686) ;
        Socket clientSocketInput =  new Socket("172.17.37.233",6686) ;
        InputController input  = new InputController(clientSocketOutput) ;
        OutputController output = new OutputController(clientSocketInput) ;
        input.start();
        output.start();
        Thread.currentThread().join();

    }
}

