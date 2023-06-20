package ServerController;

import MySQL.DataBaseController;
import com.sun.tools.javac.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class InPutController extends Thread {
    public static ArrayList<Socket> sockets = new ArrayList<>();
    private Socket socket;
    private String userName;
    private String massage;
    private static int ID = 1;
    DataBaseController dataBaseController = new DataBaseController();

    public InPutController(Socket socket, String userName) throws SQLException, ClassNotFoundException {
        this.socket = socket;
        this.userName = userName;
    }

    @Override
    public void run() {
        try {
            InputStreamReader reader = new InputStreamReader(this.socket.getInputStream());
            BufferedReader in = new BufferedReader(reader);
            PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
            String sqlCommand = "SELECT * FROM ChatRoom";
            Statement statement = dataBaseController.getConnection().prepareStatement(sqlCommand);
            ResultSet resultSet = statement.executeQuery(sqlCommand);
            while (resultSet.next()) {
                out.println(resultSet.getString(1) + ": " + resultSet.getString(2));
            }
            massage = in.readLine();
            while (!massage.equals("exit")) {
                for (Socket socketSearch : sockets) {
                    if (socketSearch != socket) {
                        PrintWriter outAll = new PrintWriter(socketSearch.getOutputStream(), true);
                        outAll.println(this.userName + ": " + massage);
                    }
                }
                dataBaseController.saveMassage(massage, userName);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
