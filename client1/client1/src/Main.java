import ClientsController.InputController;
import ClientsController.OutputController;

import java.net.* ;
import java.io.* ;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket clientSocket = new Socket("localhost",6686);
        OutputController output = new OutputController(clientSocket);
        InputController input = new InputController(clientSocket);
        input.start();
        output.start();
    }
}

